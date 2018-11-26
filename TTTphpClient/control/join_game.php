<?php
include_once('SoapClientConnection.class.php');
include_once('util/GameDetails.php');
if(isset($_POST['gameId'])){
    try {
        session_start();
        $client = SoapClientConnection::getInstance();

        $params['gid'] = $_POST['gameId'];
        $params['uid'] = $_SESSION['userId'];

        $result = $client->joinGame($params)->return;
        $resultMessage = getJoinGameMessage($result);

        if ($resultMessage == null) {
            $_SESSION['details']->addNewGameRecord($_POST['gameId'], $_POST['playerOneName'], $_SESSION['username']);
            header("Location: game.php?gid={$_POST['gameId']}");
            exit;
        } else {
            echo "<script> alert(\"'.$resultMessage.'\");</script>";
        }
    } catch (SoapFault $sf){
        echo $sf->getCode();
    } catch (Exception $e){
        echo $e->getMessage();
    }
}


function getJoinGameMessage($result){

    if($result == "0"){
        return "Error: Could not join game!";
    }
    if($result === "ERROR-DB"){
        return "Error: Database connectivity issue!";
    }
    else if($result == "1"){
        return null;
    }
    else{
        return "Error: Unknown error!";
    }
}
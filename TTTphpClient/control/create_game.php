<?php
include_once('SoapClientConnection.class.php');

if(isset($_POST['userId'])){

    try {
        $params['uid'] = $_SESSION['userId'];

        $client = SoapClientConnection::getInstance();

        $result = $client->newGame($params)->return;

        $resultMessage = getCreateGameMessage($result);

        if ($resultMessage == null) {
            $details = $_SESSION['details'];
            $details->addNewGameRecord($result, $_SESSION['username'], "None");
            header("Location: game.php?gid={$result}");
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


function getCreateGameMessage($result){

    if($result === "ERROR-NOTFOUND"){
        return "Error: Could not find game Id!";
    }
    else if($result === "ERROR-INSERT"){
        return "Error: Could not insert game to DB!";
    }
    else if($result === "ERROR-RETRIEVE"){
        return "Error: Could acces games table!";
    }
    else  if($result === "ERROR-DB"){
        return "Error: Database connectivity issue!";
    }
    else{
        return null;
    }
}

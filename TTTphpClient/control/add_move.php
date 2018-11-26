<?php
include_once('SoapClientConnection.class.php');

$client = SoapClientConnection::getInstance();

if(isset($_POST['xCoordinate'])){
    addMove($client);
}

function addMove($client){
    $params['x'] = $_POST['xCoordinate'];
    $params['y'] = $_POST['yCoordinate'];
    $params['gid'] = $_GET['gid'];
    $params['pid'] = $_SESSION['userId'];

    try {
        $result = $client->takeSquare($params)->return;

        $resultMessage = getAddMoveMessage($result);

        if ($resultMessage == null) {


        } else {
            echo "<script> alert(\"'.$resultMessage.'\");</script>";
        }
    }
    catch(SoapFault $sf){
        echo $sf->getCode();
    }
    catch (Exception $e){
        echo $e->getMessage();
    }
}

function getAddMoveMessage($result){

    if($result == "ERROR-TAKEN"){
        return "Error: Square has already been taken!";
    }
    else if($result == "ERROR-DB"){
        return "Error: could not connect to DB!";
    }
    else if($result == "1"){
        return null;
    }
    else{
        return "Error occurred!";
    }
}
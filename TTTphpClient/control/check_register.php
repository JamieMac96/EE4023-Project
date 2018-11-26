<?php
include_once('SoapClientConnection.class.php');

if(isset($_POST['forename'])){
    try {
        $client = SoapClientConnection::getInstance();

        $data['username'] = $_POST['username'];
        $data['name'] = $_POST['forename'];
        $data['surname'] = $_POST['surname'];
        $data['password'] = $_POST['password'];

        $response = $client->register($data);
        $result = (string) $response->return;

        $resultMessage = getRegisterMessage($result);

        if($resultMessage == null){
            $_SESSION['userId'] = $result;
            $_SESSION['username'] = $_POST['username'];
            $_SESSION['details'] = new GameDetails();
            header("Location: main.php");
            exit;
        }
        else{
            echo "<script> alert(\"'.$resultMessage.'\");</script>";
        }

    }
    catch(SoapFault $sf){
        echo $sf->getCode();
    } catch (Exception $e) {
        echo $e->getMessage();
    }
}

function getRegisterMessage($result){

	if($result === "ERROR-REPEAT"){
		return "Error: User already exists!";
	}
	else if($result === "ERROR-INSERT"){
		return "Error: Could not insert user to DB!";
	}
	else if($result === "ERROR-RETRIEVE"){
		return "Error: Could not retrieve user Id!";
	}
	else  if($result === "ERROR-DB"){
		return "Error: Database connectivity issue!";
	}
	else{
		return null;
	}
}
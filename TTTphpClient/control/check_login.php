<?php

include_once('control/SoapClientConnection.class.php');
include_once ('util/GameDetails.php');

if(isset($_POST["loginUsername"])){
    try {
		$client = SoapClientConnection::getInstance();

        $data['username'] = $_POST['loginUsername'];
		$data['password'] = $_POST['loginPassword'];

		$response = $client->login($data);
		$result = (string) $response->return;

        if($result == "-1" || $result == "0"){
            echo "<script> alert(\"Error: Failed to log in!\");</script>";
        }
        else{
            session_start();
            $_SESSION['userId'] = $result;
            $_SESSION['username'] = $_POST['loginUsername'];
            $_SESSION['details'] = new GameDetails();
        	header("Location: main.php");
        	exit;
		}

        echo $result;

    } catch (Exception $e) {
        echo $e->getMessage();
	}
}
?>

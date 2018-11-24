<?php

include_once('control/SoapClientConnection.class.php');

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
        	header("Location: main.php");
        	exit;
		}

        echo $result;

    } catch (Exception $e) {
        echo $e->getMessage();
	}
}
?>

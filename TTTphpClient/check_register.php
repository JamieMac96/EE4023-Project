<?php
include_once('control/SoapClientConnection.class.php');

if(isset($_POST['forename'])){
	try {
		$client = SoapClientConnection::getInstance();

		$data['username'] = $_POST['username'];
        $data['name'] = $_POST['forename'];
        $data['surname'] = $_POST['surname'];
        $data['password'] = $_POST['password'];

		$response = $client->register($data);
		$val = (string) $response->return;

        echo $val;

	} catch (Exception $e) {
		echo $e->getMessage();
	}
}
?>

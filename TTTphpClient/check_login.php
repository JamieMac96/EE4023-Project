<?php
    include('control/SoapClientConnection.class.php');
if(isset($_POST["loginUsername"])){
    try {
		$client = SoapClientConnection::getInstance();

        $data['username'] = $_POST['loginUsername'];
		$data['password'] = $_POST['loginPassword'];

		$response = $client->login($data);
		$val = (string) $response->return;

        echo $val;

	} catch (Exception $e) {
		echo $e->getMessage();
	}
}
?>

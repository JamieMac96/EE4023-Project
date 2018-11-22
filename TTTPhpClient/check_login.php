<?php
	$wsdl = "http://localhost:8080/TTTWebApplication/TTTWebService?WSDL";
	$trace = true;
	$exceptions = true;

	try {
		$client = new SoapClient($wsdl, array('trace' => $trace, 'exceptions' => $exceptions));

		$data['username'] = $_POST['username'];
		$data['password'] = $_POST['password'];

		$response = $client->login($data);
		$val = (string) $response->return;
		echo $val;

	} catch (Exception $e) {
		echo $e->getMessage();
	}
?>

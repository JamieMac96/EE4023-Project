<?php
include_once('SoapClientConnection.class.php');

session_start();

$id = $_SESSION['userId'];

$client = SoapClientConnection::getInstance();

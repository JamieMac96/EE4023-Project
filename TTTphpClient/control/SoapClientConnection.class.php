<?php

final class SoapClientConnection {
    protected static $wsdl = "http://localhost:8080/TTTWebApplication/TTTWebService?WSDL";
    protected static $connection = null;

    public static function getInstance(){
        if(!isset(self::$connection)){
            self::$connection = new SoapClient(self::$wsdl, array('trace' => true, 'exceptions' => true));
        }
        return self::$connection;
    }
}


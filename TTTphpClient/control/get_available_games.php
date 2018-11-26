<?php
include_once('SoapClientConnection.class.php');

$client = SoapClientConnection::getInstance();

try{
    $result = $client->showOpenGames();

    if (isset($result->return)) {

        $games = explode("\n", $result->return);

        foreach($games as $row){
            $splitRow = explode(",", $row);
            printAvailableGames($splitRow);
        }

    } else {
        $resultMessage = getAvailableGamesMessage($result);
        echo "<script> alert(\"'.$resultMessage.'\");</script>";
    }

}
catch (Exception $e) {
    echo $e->getMessage();
}

function getAvailableGamesMessage($result){

    if($result == "ERROR-NOGAMES"){
        return "Error: Could not find any available games!";
    }
    else if($result == "ERROR-DB"){
        return "Error: Could not connect to DB!";
    }
    else{
        return "Error Occurred!";
    }
}

function printAvailableGames($param){
    echo "<div class=\"game-card card mb-3\">
    <div class=\"card-block\">
        <div class=\"card-text\">
            <div class=\"row\">
                <div class=\"col-md-6\">
                    <ul>
                        <li>Game Id: " . $param[0] . "</li>
                        <li>Owner Name: ". $param[1] .  "</li>
                        <li>Date Created: ". $param[2] . "</li>
                    </ul>
                </div>
                <div class=\"col-md-3 offset-md-3\">
                    <form action=\"main.php\" method=\"post\">
                        <input id=\"playerOneName\" name=\"playerOneName\" type=\"hidden\" value=\"$param[1]\">
                        <input id=\"gameId\" name=\"gameId\" type=\"hidden\" value=\"$param[0]\">
                        <button name=\"joinGame\" type=\"submit\">Join Game</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>";
}
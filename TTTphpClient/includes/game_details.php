<?php
    session_start();
    include_once('control/SoapClientConnection.class.php');

    $client = SoapClientConnection::getInstance();
    $details = $_SESSION['details'];
    $gameStateMessage = "";
    $playerOne = $details->getGameRecord($_GET['gid'])->getPlayerOneName();
    $playerTwo = $details->getGameRecord($_GET['gid'])->getPlayerTwoName();

    try {
        $params['gid'] = $_GET['gid'];
        $gameState = $client->getGameState($params)->return;
        $gameStateMessage = getGameStateMessage($gameState);
    }
    catch (SoapFault $sf){
        echo $sf->getCode();
    }
    catch (Exception $e){
        echo $e->getMessage();
    }

    function getGameStateMessage($gameState){
        error_log("from game_details:  " . $gameState);
        if($gameState == "-1"){
            return "Waiting for opponent.";
        }
        else if($gameState == "0"){
            return "Game in progress";
        }
        else if($gameState == "1"){
            return "Player one is the winner";
        }
        else if($gameState == "2"){
            return "Player two has won";
        }
        else if($gameState == "ERROR-NOGAME"){
            return "Error: Game does not exist!";
        }
        else if($gameState == "ERROR-DB"){
            return "Error: Could not connect to DB";
        }
        else{
            return "Could not determine game state";
        }
    }
?>


<div class="spacer"></div>
<div class="container">
    <div class="row row list">
        <h3 class="col-xs-3"><b>Game State:</b> <?php echo $gameStateMessage?></h3>
        <h3 class="col-xs-3"><b>Player One:</b> <?php echo $playerOne?></h3>
        <h3 class="col-xs-3"><b>Player Two:</b> <?php echo $playerTwo?></h3>
    </div>
</div>
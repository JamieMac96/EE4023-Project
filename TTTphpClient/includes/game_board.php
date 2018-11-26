<?php

include_once('control/SoapClientConnection.class.php');

$boardConfig = array();
$boardConfig['00'] = "";
$boardConfig['01'] = "";
$boardConfig['02'] = "";
$boardConfig['10'] = "";
$boardConfig['11'] = "";
$boardConfig['12'] = "";
$boardConfig['20'] = "";
$boardConfig['21'] = "";
$boardConfig['22'] = "";

$client = SoapClientConnection::getInstance();

try{
    $stateParam['gid'] = $_GET['gid'];
    $result = $client->getBoard($stateParam)->return;

    $resultMessage = getBoardMessage($result);

    if($resultMessage == null){
        error_log("game result: " . $result);
        $rows = explode("\n", $result);

        foreach ($rows as $row){
            $items = explode(",", $row);
            $key = $items[1] . $items[2];
            $uId = $items[0];
            error_log("key: " . $key);
            $boardConfig[$key] = getCorrectSymbol($uId);
        }
    }
    else if($resultMessage != "nm"){
        error_log("in else if");
        echo "<script> alert(\"'.$resultMessage.'\");</script>";
    }
    else{
        error_log("in else ");
    }
}
catch(SoapFault $sf){
    echo $sf->getCode();
}
catch (Exception $e){
    echo $e->getMessage();
}


function getBoardMessage($result){
    if($result == "ERROR-DB"){
        return "Error: Could not connect to DB";
    }
    else if($result == "ERROR-NOMOVES"){
        return "nm";
    }
    else{
        return null;
    }
}

function getCorrectSymbol($userId){
    $details = $_SESSION['details'];

    $playerOne = $details->getGameRecord($_GET['gid'])->getPlayerOneName();
    $loggedInPlayerName = $_SESSION['username'];
    $loggedInPlayerId = $_SESSION['userId'];
    $isLoggedInPlayer = ($userId == $loggedInPlayerId);
    $loggedInPlayerIsPlayerOne = ($playerOne == $loggedInPlayerName);

    if($isLoggedInPlayer xor $loggedInPlayerIsPlayerOne) return "O";
    else return "X";
}

?>

<div class="container">
    <table id="board">
        <tr>
            <td><?php echo $boardConfig['00']?></td>
            <td><?php echo $boardConfig['01']?></td>
            <td><?php echo $boardConfig['02']?></td>
        </tr>
        <tr>
            <td><?php echo $boardConfig['10']?></td>
            <td><?php echo $boardConfig['11']?></td>
            <td><?php echo $boardConfig['12']?></td>
        </tr>
        <tr>
            <td><?php echo $boardConfig['20']?></td>
            <td><?php echo $boardConfig['21']?></td>
            <td><?php echo $boardConfig['22']?></td>
        </tr>
    </table>
</div>
<?php
/**
 * Created by IntelliJ IDEA.
 * User: jamie
 * Date: 25/11/18
 * Time: 19:18
 */

require_once('GameRecord.php');

class GameDetails
{
    private $gameRecords;

    public function __construct()
    {
        $this->gameRecords = array();
    }

    public function addGameRecord($gid, $gameRecord){
        $this->gameRecords[$gid] = $gameRecord;
    }

    public function addNewGameRecord($gid, $playerOneName, $playerTwoName){
        $record = new GameRecord();
        $record->setGameId($gid);
        $record->setPlayerOneName($playerOneName);
        $record->setPlayerTwoName($playerTwoName);
        $this->gameRecords[$gid] = $record;
    }

    public function getGameRecord($gid){
        return $this->gameRecords[$gid];
    }

    public function clear(){
        $this->gameRecords= array();
    }

    public function __toString()
    {
        $return = "";
        foreach ($this->gameRecords as $record){
            $return += $record->__toString();
        }
        return $return;
    }
}
<?php
/**
 * Created by IntelliJ IDEA.
 * User: jamie
 * Date: 25/11/18
 * Time: 19:22
 */

class GameRecord
{
    private $gameId;
    private $playerOneName;
    private $playerTwoName;

    public function __construct(){
        $this->gameId = -1;
        $this->playerOneName = "None";
        $this->playerTwoName = "None";
    }

    /**
     * @param $gameId
     * @return GameRecord
     */
    public function setGameId($gameId)
    {
        $this->gameId = $gameId;
    }

    /**
     * @param mixed $playerOneName
     * @return GameRecord
     */
    public function setPlayerOneName($playerOneName)
    {
        $this->playerOneName = $playerOneName;
    }

    /**
     * @param mixed $playerTwoName
     * @return GameRecord
     */
    public function setPlayerTwoName($playerTwoName)
    {
        $this->playerTwoName = $playerTwoName;
    }

    /**
     * @return mixed
     */
    public function getGameId()
    {
        return $this->gameId;
    }

    /**
     * @return mixed
     */
    public function getPlayerOneName()
    {
        return $this->playerOneName;
    }

    /**
     * @return mixed
     */
    public function getPlayerTwoName()
    {
        return $this->playerTwoName;
    }

    public function __toString()
    {
        return " gid: " . $this->gameId
            . ", playerOne: " . $this->playerOneName
            . ", playerTwo: " . $this->playerTwoName;
    }
}
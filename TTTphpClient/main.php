<?php include_once('util/GameDetails.php');?>
<?php include_once('util/restrict_access.php');?>
<?php include_once('control/create_game.php');?>
<?php include_once('control/join_game.php');?>

<html lang="en">

    <?php
        session_start();
        include_once('includes/head.php');
    ?>

    <?php include_once('includes/headers/main_header.php');?>

    <body>

        <div class="container">
            <form action="main.php" method="post">
                <input name="userId" type="hidden" value="<?php echo $_SESSION['userId']?>">
                <button name="createGame" id="createGameButton" type="submit">Create Game</button>
            </form>
            <br>
            <h3>Available Games:</h3>
            <?php
            include_once('control/get_available_games.php');?>
        </div>

        <div class="spacer">
        </div>
    </body>

    <?php include_once('includes/footer.php')?>

</html>

<!-- php scripts-->
<?php include_once('util/GameDetails.php');?>
<?php include_once('util/restrict_access.php');?>
<?php include_once('control/add_move.php');?>
<html lang="en">

<?php include_once('includes/head.php');?>
<?php include_once('includes/headers/game_header.php');?>

<body>
    <?php include_once('includes/game_details.php');?>
    <?php include_once('includes/game_board.php');?>

    <div class="container">
        <form action="game.php?gid=<?php echo $_GET['gid']?>" method="post">
            <label class="blackText">
                X:
                <input type="number" name="xCoordinate" max="2" min="0">
            </label>
            <label class="blackText">
                Y:
                <input type="number" name="yCoordinate" max="2" min="0">
            </label>
            <button type="submit" >Add Move</button>
        </form>
    </div>
<div class="spacer">
</div>
</body>

<?php include_once('includes/footer.php')?>

</html>

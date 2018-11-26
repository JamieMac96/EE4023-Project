<?php include_once("control/check_login.php");?>
<?php include_once("control/check_register.php");?>

<html>
    <?php
            session_start();
            session_unset();
            session_destroy();
            session_write_close();
            setcookie(session_name(),'',0,'/');
            session_regenerate_id(true);
    ?>

    <?php include_once('includes/head.php'); ?>

    <?php include_once('includes/headers/login_header.php');?>

  <body>
    <?php include_once('includes/register_form.php')?>
  </body>

  <?php include_once('includes/footer.php');?>

</html>
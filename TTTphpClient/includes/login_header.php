<header>
    <div class="header">
        <form action="index.php" method="post">
          <div class="container">
              <div class="row">
                  <div class="col-xs-3">
                    <label for="username"><b>Username</b></label>
                    <input type="text" placeholder="Enter Username" name="loginUsername" required>
                  </div>
                    <div class="col-xs-3">
                      <label for="password"><b>Password</b></label>
                      <input type="password" placeholder="Enter Password" name="loginPassword" required>
                    </div>
                    <div class="col-xs-3">
                        <br>
                        <button name="sbmt" type="submit">Login</button>
                    </div>
                </div>
          </div>
       </form>
   </div>
   <?php include("check_login.php");?>
</header>

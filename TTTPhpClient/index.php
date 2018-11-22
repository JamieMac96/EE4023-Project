<html>
<head>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <!-- Latest compiled and minified CSS -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
  <link rel="stylesheet" href="css/index.css" media="all" />

  <!-- Latest compiled and minified JavaScript -->
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
  <script src="js/index.js"></script>
</head>
  <body>

    <div class="container">
      <div class="welcome">

        <div>
          Welcome to tic-tac-toe! Click the buttons below to either login with your existing
          credentials or create a new account.
        </div>

        <?php
          $response = file_get_contents('http://localhost/path/to/api/call?param1=5');
        ?>

        <button id="loginButton">Login</button>
        <button id="registerButton">Register</button>
      </div>

        <!-- The Login Modal -->
        <div id="loginModal" class="modal">
          <!-- Modal Content -->
          <form class="modal-content animate">
            <div class="container">
              <span id="loginSpan" class="close" title="Close Modal">&times;</span>
              <label for="uname"><b>Username</b></label>
              <input id="username" type="text" placeholder="Enter Username" name="uname" required>

              <label for="psw"><b>Password</b></label>
              <input id="password" type="password" placeholder="Enter Password" name="psw" required>

              <button id="submitButton" type="submit">Login</button>
              <button id="loginClose" type="button" class="cancelbtn">Cancel</button>
            </div>
          </form>
        </div>
    </div>
  </body>
</html>

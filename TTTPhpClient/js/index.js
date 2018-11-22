window.onload=function() {

  var loginBtn = document.getElementById('loginButton');
  loginBtn.addEventListener('click', function() {
    document.getElementById('loginModal').style.display='block'
  });

  var loginSpanClose = document.getElementById('loginSpan');
  loginSpanClose.addEventListener('click', function() {
     document.getElementById('loginModal').style.display='none'
  });

  var loginClose = document.getElementById('loginClose');
  loginClose.addEventListener('click', function() {
     document.getElementById('loginModal').style.display='none'
  });

  var registerBtn = document.getElementById('registerButton');
  registerBtn.addEventListener('click', function() {
    document.location.href = 'register.php';
  });

  var submitBtn = document.getElementById('submitButton');
  submitBtn.addEventListener('click', function() {
    var username = document.getElementById('username');
    var password = document.getElementById('password');
    $.ajax({
      url: "check_login.php",
      type: "post",
      dataType: 'json',
      data: {
        username: "$username",
        password: "password"
      },
      success:function(result){
       console.log("result.abc");
     },
     fail:function(result){
      console.log("result.abc");
    }
    });
    event.preventDefault();
  });

  var loginModal = document.getElementById('loginModal');
  window.onclick = function(event) {
    if (event.target == loginModal) {
        loginModal.style.display = "none";
    }
  }

}

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Sign Up Form</title>

    <!-- Font Icon -->
    <link rel="stylesheet"
          href="fonts/material-icon/css/material-design-iconic-font.min.css">

    <!-- Main css -->
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<input type="hidden" id="status" value="<%= request.getAttribute("status") %>">

<div class="main" >

    <!-- Sign up form -->
    <section class="signup">
        <div class="container">
            <div class="signup-content">
                <div class="signup-form">
                    <h2 class="form-title">Sign up</h2>

                    <form method="post" action="register" class="register-form"
                          id="register-form">
                        <div class="form-group">
                            <label for="name"><i
                                    class="zmdi zmdi-account material-icons-name"></i></label> <input
                                type="text" name="name" id="name" placeholder="Your Name" required="required"/>
                        </div>
                        <div class="form-group">
                            <label for="email"><i class="zmdi zmdi-email"></i></label> <input
                                type="email" name="email" id="email" placeholder="Your Email" required="required"/>
                        </div>
                        <div class="form-group">
                            <label for="pass"><i class="zmdi zmdi-lock"></i></label> <input
                                type="password" name="pass" id="pass" placeholder="Password" required="required"/>
                        </div>
                        <div class="form-group">
                            <label for="re-pass"><i class="zmdi zmdi-lock-outline"></i></label>
                            <input type="password" name="re_pass" id="re_pass"
                                   placeholder="Repeat your password" required="required"/>
                        </div>
                        <div class="form-group">
                            <label for="contact"><i class="zmdi zmdi-lock-outline"></i></label>
                            <input type="text" name="contact" id="contact"
                                   placeholder="Contact no" required="required"/>
                        </div>
                        <div class="form-group">

                        </div>
                        <div class="form-group form-button">
                            <input type="submit" name="signup" id="signup"
                                   class="form-submit" value="Register" />
                        </div>
                        <div class="social-login">
                            <a href="login.jsp" class="signup-image-link">I am already member</a>
                        </div>

                    </form>

                </div>

            </div>
        </div>
    </section>


</div>
<!-- JS -->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="js/main.js"></script>
<script src ="http://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<link rel="stylesheet" href="alert/dist/sweetalert.css">

<script type="text/javascript">
    var status = document.getElementById("status").value;
    if(status == "success"){
        swal("Congrats ", "Account created successfully ","success" )
    }
    if(status == "invalidName"){
        swal("Sorry ", "Please enter name ","error" )
    }
    if(status == "invalidEmail"){
        swal("Sorry ", "Please enter email ","error" )
    }
    if(status == "invalidPassword"){
        swal("Sorry ", "Please enter password ","error" )
    }
    if(status == "invalidConfirmPassword"){
        swal("Sorry ", "Please confirm password ","error" )
    }
    if(status == "invalidMObileNumber"){
        swal("Sorry ", "Please enter mobilenumber ","error" )
    }
    if(status == "invalidMObileNumber"){
        swal("Sorry ", "Please enter correct mobilenumber ","error" )
    }
</script>

</body>
<!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>
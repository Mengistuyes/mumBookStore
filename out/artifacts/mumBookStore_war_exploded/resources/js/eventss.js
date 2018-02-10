$(document).ready(function() {
    $("#register").click(function() {
        var uname = $("#uname").val();
        var email = $("#email").val();
        var password = $("#pass").val();
        var cpassword = $("#cpass").val();
        var fname = $("#firstname").val();
        var lname = $("#lastname").val();


        if (uname == '' || email == '' || password == '' || cpassword == '' || fname== '' || lname == '' ) {
            alert("Please fill all fields...!!!!!!");
            return false;
        } else if ((password.length) < 8) {
            alert("Password should atleast 8 character in length...!!!!!!");
            return false;
        } else if (!(password).match(cpassword)) {
            alert("Your passwords don't match. Try again?");
            return false;
        } else {
            alert("You signed up Succesfully ");

            // $.post("signUp.jsp", {
            //     name1: uname,
            //     email1: email,
            //     password1: password
            // }, function(data) {
            //     if (data == 'You have Successfully Registered.....') {
            //         $("signup")[0].reset();
            //     }
            //     alert(data);
            // });
        }
    });
});

    function confirmEmail() {
        var email = document.getElementById("email").value;
        var confemail = document.getElementById("email_conf").value;
        if(email != confemail) {
            //alert('Email Not Matching!');
            document.getElementById("email_conf").value="";
            document.getElementById("email").focus();
            document.getElementById("email").style.background = "#eda6ac";
            document.getElementById("email").style.borderWidth = "1px 1px 1px 1px";
        }
    }
    
    
	    function confirmPass() {
        var pass = document.getElementById("password").value;

        var confpass = document.getElementById("password_conf").value;
        if(pass != confpass) {
            //alert('Email Not Matching!');
            document.getElementById("password_conf").value="";
            document.getElementById("password").focus();
            document.getElementById("password").style.background = "#eda6ac";
         } 
    }

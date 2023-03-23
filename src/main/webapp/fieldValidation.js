
    function confirmEmail() {
        var email = document.getElementById("email").value
        var confemail = document.getElementById("emailConf").value
        if(email != confemail) {
            //alert('Email Not Matching!');
            document.getElementById("errorMessagy").innerHTML="Email does not match.";
            document.getElementById("emailConf").value=""
            document.getElementById("email").focus();
        } 
    }
    
    
	    function confirmPass() {
        var pass = document.getElementById("password").value

        var confpass = document.getElementById("password_conf").value
        if(pass != confpass) {
            //alert('Email Not Matching!');
          
            document.getElementById("errorMessagy").innerHTML="Password does not match";
            document.getElementById("password_conf").value="";
            document.getElementById("password").focus();
            document.getElementById("password").style.background = "#eda6ac";
        }
    }

//		function turnred(key) {
//    			console.log(key);
//    			//document.getElementById(key).innerHTML="value";
//    			document.getElementById(key).style.background = "#eda6ac";
//				document.getElementById(key).style.borderColor = "#f50015";
//				document.getElementById(key).style.borderStyle = "solid";
//		}	
		
    
  /* function ValidateEmail(inputText)
			{
				var mailformat = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;
				if(inputText.value.match(mailformat))
			{
				//alert("You have entered a valid email address!");    //The pop up alert for a valid email address
				document.getElementById("errorMessagy").innerHTML="";
				return true;
			}
			else
			{
				//alert("You have entered an invalid email address!");    //The pop up alert for an invalid email address
				document.getElementById("errorMessagy").innerHTML="Invalid email";
				inputText.focus();

				return false;
		}
	} */
	
	
	

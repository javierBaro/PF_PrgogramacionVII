


function validatePassword(){
	var pass1 = document.getElementById("pass1").value;
    var pass2 = document.getElementById("pass2").value;
    var ok=true;
  if(pass1 != pass2) {
	  document.getElementById("pass1").style.borderColor = "#E34234";
      document.getElementById("pass2").style.borderColor = "#E34234";
      
      document.getElementById("alert_confirm").style.borderColor = "#E34234";
      document.getElementById("alert_confirm").innerHTML = "Las contraseñas no coinciden!";
	  ok=false;  
  }
  return  ok;
}



window.onload = function () { 
    document.getElementById("form_reg").onsubmit = validatePassword;
}

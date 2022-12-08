const form = document.getElementById("form_id");
const dButtonLogin = document.getElementById("submit");
dButtonLogin.addEventListener("click", validation);

function validation(){
          var un=document.getElementById('username').value;
          var ps=document.getElementById('password').value;
          if (un == "admin" && ps == "admin"){
              window.alert("Login Successful");
              window.location.href = "index.jsp";
          }
          else{
              window.alert("Login Failed");
          }
        }
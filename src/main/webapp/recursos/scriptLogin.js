const $btnSignIn= document.querySelector('.sign-in-btn'),
      $btnSignUp = document.querySelector('.sign-up-btn'),  
      $signUp = document.querySelector('.sign-up'),
      $signIn  = document.querySelector('.sign-in');

document.addEventListener('click', e => {
    if (e.target === $btnSignIn || e.target === $btnSignUp) {
        $signIn.classList.toggle('active');
        $signUp.classList.toggle('active')
    }
});

const form = document.getElementById("form_id");
const dButtonLogin = document.getElementById("submit");
dButtonLogin.addEventListener("click", validation);

function validation() {
    var un = document.getElementById('username').value;
    var ps = document.getElementById('password').value;
    if (un == "admin" && ps == "123") {
        window.alert("Login Successful");
        window.location.href = "index.jsp";
       
    }
    else {
        window.alert("Login Failed");
    }
}


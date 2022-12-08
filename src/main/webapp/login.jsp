<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="recursos/styleLoginv2.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet">
    <link href='https://unpkg.com/boxicons@2.1.1/css/boxicons.min.css' rel='stylesheet'>
    <title>Bienvenido a Tanganxoan</title>
</head>

<body>
    <div class="container-form sign-up">
        <div class="welcome-back">
            <div class="message">
                <h2>Bienvenido a a Tanganxoan</h2>
                <p>Hola chulo</p>
                <button class="sign-up-btn">Iniciar Sesion</button>
            </div>
        </div>
  
    </div>
    <div class="container-form sign-in">
        <form class="formulario" method="post" name="myform" >
            <h2 class="create-account">Iniciar Sesion</h2>
            <div class="iconos">
                <div class="border-icon">
                    <i class='bx bxl-instagram'></i>
                </div>
                <div class="border-icon">
                    <i class='bx bxl-linkedin' ></i>
                </div>
                <div class="border-icon">
                    <i class='bx bxl-facebook-circle' ></i>
                </div>
            </div>
            <p class="cuenta-gratis">¿Aun no tienes una cuenta?</p>
            <input type="text" name="forms__name" placeholder="User" id="username" required=""> 
            <input type="password" name="forms__password" placeholder="Contraseña" id="password" required="">
            <input type="button" value="Iniciar Sesion" id="submit" class="botones" >
        </form>
   
    </div>
    <script src="recursos/scriptLogin.js"></script>
</body>

</html>
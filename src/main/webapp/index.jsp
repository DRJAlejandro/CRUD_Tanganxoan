<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="recursos/styleIndex.css">
  <title>Tanganxoan</title>
</head>

<body>
  <section class="showcase">
    <header>
      <h2 class="logo">Academia De Monta</h2>
      <div class="toggle"></div>
    </header>
    <video src="recursos/video1.mp4" muted loop autoplay></video>
    <div class="overlay"></div>
    <div class="text">
      <h2>El Manejo de </h2>
      <h3>Tu granja con nosotros</h3>
      <p>Administre su rancho y sus caballos con esta grandiosa herramienta de administracion.</p>
      <a href="#">Explora</a>
    </div>
    <ul class="social">
      <li><a href="#"><img src="https://i.ibb.co/x7P24fL/facebook.png"></a></li>
      <li><a href="#"><img src="https://i.ibb.co/Wnxq2Nq/twitter.png"></a></li>
      <li><a href="#"><img src="https://i.ibb.co/ySwtH4B/instagram.png"></a></li>
    </ul>
  </section>
  <div class="menu">
    <ul>
      <li><a href="${pageContext.request.contextPath}/ControladorVenta">Venta</a></li>
      <li><a href="${pageContext.request.contextPath}/ControladorEquino">Equinos</a></li>
      <li><a href="${pageContext.request.contextPath}/ControladorEmpleado">Empleado</a></li>
      <li><a href="${pageContext.request.contextPath}/ControladorServicio">Servicio</a></li>
      <li><a href="${pageContext.request.contextPath}/ControladorCliente">Cliente</a></li>
      <li><a href="login.jsp">Cerrar Sesion</a></li>
      
    </ul>
  </div>

  <script>
    const menuToggle = document.querySelector('.toggle');
    const showcase = document.querySelector('.showcase');

    menuToggle.addEventListener('click', () => {
      menuToggle.classList.toggle('active');
      showcase.classList.toggle('active');
    })
  </script>
</body>

</html>
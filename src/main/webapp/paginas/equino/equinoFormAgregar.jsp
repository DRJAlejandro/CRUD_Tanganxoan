<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="/Redencion/styles.css" />


    <script src="https://kit.fontawesome.com/08e2ce0e98.js" crossorigin="anonymous"></script>
  
    <title>Tanganxoan</title>
  </head>
  <body>
      <jsp:include page="../comunes/cabecero.jsp"/>

    <main>
      <div class="container">
        <div class="container__circle" id="circle-c">
            <i id="icon-client" class="fa-solid fa-horse-head"></i>
        </div>
        <form action="${pageContext.request.contextPath}/ControladorEquino?accion=insertar" method="POST" class="form" id="box" method="POST">
          <h1 class="form__h1" id="title">EQUINO</h1>

         <div class="forms__row">
          <div class="forms__container">
            <label for="" class="forms__label">Nombre</label>
            <input class="forms__input" type="text" id="forms__name" name="forms__name" />
          </div>
          <div class="forms__container">
            <label for="" class="forms__label">Raza</label>
            <select class="forms__input" type="text" id="forms__race" name="forms__race">
              <option>De Mar</option>
              <option>Pinto</option>
              <option>Pura Sangre Ingles</option>
              <option>Mustang</option>
              <option>Percherone</option>
              <option>Árabe</option>
              <option>Anda Luz</option>
              <option>TENNESSEE WALKING HORSE</option>
              <option>APALUSA</option>
              <option>PONI GALÉS</option>
            </select>
          </div>
        </div>

        <div class="forms__row">

          <div class="forms__container">
            <label for="" class="forms__label">Sexo</label>
            <select class="forms__input" type="text" id="forms__sex" name="forms__sex">
              <option>Macho</option>
              <option>Hembra</option>
            </select>
          </div>
        </div>

          <div class="forms__buttons">
            <button class="forms__button forms__button-add" type="button" id="forms__addHorse">Agregar</button>
          </div>
        </form>
      </div>

      <div class="container__modal" id="modal">
        <div class="modal">
          <div class="container__circle-x" id="circle-x">
            <i id="icon-x" class="fa-solid fa-xmark icon-x"></i>
          </div>

          <p class="modal__text" id="modal__text">No se permiten espacios en elssssssssssssss id</p>
          <div class="container__circle-cerrar" id="circle-cerrar">
            <button class="button__cerrar " type="button" id="button__cerrar">Cerrar</button>
          </div>
        </div>

      </div>
      <script src="../../recursos/script.js"></script>



  </body>
</html>
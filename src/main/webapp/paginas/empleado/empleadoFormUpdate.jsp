
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="/Redencion/styles.css" />


    <script src="https://kit.fontawesome.com/08e2ce0e98.js" crossorigin="anonymous"></script>
  </main>
    <title>Tanganxoan</title>
  </head>
  <body>
<jsp:include page="../comunes/cabecero.jsp"/>

    <main>
      <div class="container">
        <div class="container__circle" id="circle-c">
            <i id="icon-client" class="fa-solid fa-horse-head"></i>
        </div>
        <form action="${pageContext.request.contextPath}/ControladorEmpleado?accion=modificar&idEmpleado=${empleado.idEmpleado}" class="form" id="box" method="POST">
          <h1 class="form__h1" id="title">EMPLEADO</h1>

          <div class="forms__row">
            <div class="forms__container">
              <label for="" class="forms__label">Nombre</label>
              <input class="forms__input" type="text" id="forms__name" name="forms__name"/>
            </div>
            <div class="forms__container">
              <label for="" class="forms__label">Apellido</label>
              <input class="forms__input" type="text" id="forms__last-name" name="forms__last-name"/>
            </div>
            <div class="forms__container">
                <label for="" class="forms__label">Teléfono</label>
                <input class="forms__input" type="text" id="forms__phone" name="forms__phone"/>
              </div>
        </div>

        <div class="forms__row">
            <div class="forms__container">
              </div>
          <div class="forms__container">
            <label for="" class="forms__label">Sexo</label>
            <select class="forms__input" type="text" id="forms__sex" name="forms__sex">
              <option>Hombre</option>
              <option>Mujer</option>
            </select>
          </div>
          <div class="forms__container">
          </div>
        </div>

          <div class="forms__buttons">
            <button class="forms__button forms__button-update"  type="button" id="forms__addEmploye">Actualizar</button>
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
      <script src="recursos/script.js"></script>



  </body>
</html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="/Redencion/styles.css" />


    <script
    src="https://kit.fontawesome.com/eb4e2d360b.js"
    crossorigin="anonymous"
  ></script>
  </main>
    <title>Tanganxoan</title>
  </head>
  <body>
 <jsp:include page="../comunes/cabecero.jsp"/>

    <main>
      <div class="container">
        <div class="container__circle" id="circle-c">
          <i id="icon-client" class="fa-solid  fa-user icon"></i>
        </div>
        <form action="${pageContext.request.contextPath}/ControladorVenta?accion=modificar&idVenta=${venta.idVenta}" class="form" id="box" method="POST">
          <h1 class="form__h1" id="title">VENTA</h1>
<div class="forms__row">
            <div class="forms__container">
              <label for="" class="forms__label">Fecha</label>
              <input class="forms__input" type="date" id="forms__date" name="forms__date"/>
            </div>
            <div class="forms__container">
              <label for="" class="forms__label">Costo Total</label>
              <input class="forms__input" type="text" id="forms__cost" name="forms__cost"/>
            </div>
            <div class="forms__container">
              <label for="" class="forms__label">ID Caballo</label>
              <select class="forms__input" type="text" id="forms__horseid" name="forms__horseid">
                         <c:forEach var="equino" items="${equinos}" varStatus="status" >
                
                             
                             <option>${equino.idEquino}</option>
                         </c:forEach>
              </select>
            </div>
            
        </div>
          

        <div class="forms__row">
          <div class="forms__container">
            <label for="" class="forms__label">ID Cliente</label>
            <select class="select"  id="forms__clientid" name="forms__clientid">
                         <c:forEach var="cliente" items="${clientes}" varStatus="status" >
                             
                             
                             <option>${cliente.idCliente}</option>
                         </c:forEach>
            </select>
          </div>
          <div class="forms__container">
            <label for="" class="forms__label">ID Empleado</label>
            <select class="forms__input" type="text" id="forms__emplyeid" name="forms__emplyeid">
                         <c:forEach var="empleado" items="${empleados}" varStatus="status" >
                             
                             
                             <option>${empleado.idEmpleado}</option>
                         </c:forEach>
            </select>
          </div>
        
          <div class="forms__container">
            <label for="" class="forms__label">ID Servicio</label>
            <select class="forms__input" type="text" id="forms__serviceid" name="forms__serviceid">
                         <c:forEach var="servicio" items="${servicios}" varStatus="status" >
                             
                             
                             <option>${servicio.idServicio}</option>
                         </c:forEach>
            </select>
          </div>
        </div>


          <div class="forms__buttons">
            <button class="forms__button forms__button-update" type="button" id="forms__addSale">Actualizar</button>
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
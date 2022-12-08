<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="styles.css">
            <script
    src="https://kit.fontawesome.com/eb4e2d360b.js"
    crossorigin="anonymous"
  ></script>

        <title>Control de Ventas</title>
    </head>
    <body>
        <!--Cabecero-->
        <jsp:include page="paginas/comunes/cabecero.jsp"/>


    

<main>
        <div class="fill-background" id="background">

      <div class="container__table container">
        <table>
            <thead>
          <tr>
            <th>Id</th>
            <th>Fecha</th>
            <th>Caballo</th>
            <th>Cliente</th>
            <th>Empleado</th>
            <th>Servicio</th>
            <th>Total</th>
            <th>Actualizar</th>
            <th>Eliminar</th>
          </tr>
          </thead>
          
          <tbody><c:forEach var="venta" items="${ventas}" varStatus="status" >
                        <tr>
                                <td>${venta.idVenta}</td>
                                <td>${venta.fecha}</td>
                                <td>${venta.idEquino}</td>
                                <td>${venta.idCliente}</td>
                                <td>${venta.idEmpleado}</td>
                                <td>${venta.idServicio}</td>
                                <td>$${venta.costoTotal}</td>
                    <td>
                        <div class="actualizar-button">
                            <a id="forms__update" class="table__button update__buton"  href="${pageContext.request.contextPath}/ControladorVenta?accion=editar&idVenta=${venta.idVenta}">
                            Actualizar</a>
                          </div>
                    </td>
                    <td>
                        <div class="delete-button">
                            <a class="table__button delete__button" href="${pageContext.request.contextPath}/ControladorVenta?accion=eliminar&idVenta=${venta.idVenta}">
                            Eliminar</a>
                          </div>
                    </td>
                        </tr>
                </c:forEach>
         </tbody>
        </table>
        <div class="forms__buttons">
            <a class="forms__button forms__button-add" href="${pageContext.request.contextPath}/ControladorVenta?accion=agregarExterno">
                            Agregar</a>
          
        </div>
      </div>
    </div>

      <script src="script.js"></script>

  </body>
</html>
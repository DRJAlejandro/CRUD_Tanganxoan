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

        <title>Control de Clientes</title>
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
            <th>Nombre</th>
            <th>Apellido</th>
            <th>Teléfono</th>
            <th>Sexo</th>
            <th>Actualizar</th>
            <th>Eliminar</th>
          </tr>
            </thead>
            <tbody>
                <c:forEach var="cliente" items="${clientes}" varStatus="status" >
                        <tr>
                                <td>${cliente.idCliente}</td>
                                <td>${cliente.nombre}</td>
                                <td>${cliente.apellido}</td>
                                <td>${cliente.telefono}</td>
                                <td>${cliente.sexo}</td>
                    <td>
                        <div class="actualizar-button">
                            <a id="forms__update" class="table__button update__buton"  href="${pageContext.request.contextPath}/ControladorCliente?accion=editar&idCliente=${cliente.idCliente}">
                            Actualizar</a>
                          </div>
                    </td>
                    <td>
                        <div class="delete-button">
                            <a class="table__button delete__button" href="${pageContext.request.contextPath}/ControladorCliente?accion=eliminar&idCliente=${cliente.idCliente}">
                            Eliminar</a>
                          </div>
                    </td>
                        </tr>
                </c:forEach>

          </tbody>
        </table>
        <div class="forms__buttons">
          <button class="forms__button forms__button-add" onclick="location.href='paginas/cliente/clienteFormAgregar.jsp'" type="button" id="forms__add">Agregar</button>
        </div>
        
      </div>
    </div>

      <script src="script.js"></script>

  </body>
</html>


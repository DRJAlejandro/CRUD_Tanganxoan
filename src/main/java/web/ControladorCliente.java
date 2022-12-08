package web;

import datos.clienteDAO;
import dominio.Cliente;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ControladorCliente")
public class ControladorCliente extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "editar":
                    this.editarCliente(request, response);
                    break;
                case "eliminar":
                    this.eliminarCliente(request, response);
                    break;
     
                default:
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
    }

    private void accionDefault(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Cliente> clientes = new clienteDAO().seleccionar();
        HttpSession sesion = request.getSession();
        sesion.setAttribute("clientes", clientes);
        System.out.println("AyudA" + clientes);
     
        response.sendRedirect("clientes.jsp");
        
    }



    private void editarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));

        Cliente cliente = new clienteDAO().buscar(new Cliente(idCliente));
        request.setAttribute("cliente", cliente);
        String jspEditar = "paginas/cliente/clienteFormUpdate.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    this.insertarCliente(request, response);
                    break;
                case "modificar":
                    this.modificarCliente(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
    }

    private void insertarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nombre = request.getParameter("forms__name");
        String apellido = request.getParameter("forms__last-name");
        String telefono = request.getParameter("forms__phone");
        String sexo = request.getParameter("forms__sex");


        Cliente cliente = new Cliente(nombre, apellido, telefono, sexo);

        int registrosModificados = new clienteDAO().insertar(cliente);
        System.out.println("registrosModificados = " + registrosModificados);

        this.accionDefault(request, response);
    }

    private void modificarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        String nombre = request.getParameter("forms__name");
        String apellido = request.getParameter("forms__last-name");
        String telefono = request.getParameter("forms__phone");
        String sexo = request.getParameter("forms__sex");



        Cliente cliente = new Cliente(idCliente, nombre, apellido, telefono, sexo);

        int registrosModificados = new clienteDAO().actualizar(cliente);
        System.out.println("registrosModificados = " + registrosModificados);

        this.accionDefault(request, response);
    }
    
        private void eliminarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
     

        Cliente cliente = new Cliente(idCliente);

        int registrosModificados = new clienteDAO().eliminar(cliente);
        System.out.println("registrosModificados = " + registrosModificados);

        this.accionDefault(request, response);
    }
        
  

}

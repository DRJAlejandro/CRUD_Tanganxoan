package web;

import datos.empleadoDAO;
import dominio.Empleado;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ControladorEmpleado")
public class ControladorEmpleado extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "editar":
                    this.editarEmpleado(request, response);
                    break;
                case "eliminar":
                    this.eliminarEmpleado(request, response);
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
        List<Empleado> empleados = new empleadoDAO().seleccionar();
        HttpSession sesion = request.getSession();
        sesion.setAttribute("empleados", empleados);
        
     
        //request.getRequestDispatcher("consultCliente.jsp").forward(request, response);
        response.sendRedirect("empleados.jsp");
        System.out.println("AyudA" + empleados);
        
    }



    private void editarEmpleado(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recuperamos el idCliente
        int idEmpleado = Integer.parseInt(request.getParameter("idEmpleado"));

        Empleado empleado = new empleadoDAO().buscar(new Empleado(idEmpleado));
        request.setAttribute("empleado", empleado);
        String jspEditar = "paginas/empleado/empleadoFormUpdate.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    this.insertarEmpleado(request, response);
                    break;
                case "modificar":
                    this.modificarEmpleado(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
    }

    private void insertarEmpleado(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nombre = request.getParameter("forms__name");
        String apellido = request.getParameter("forms__last-name");
        String telefono = request.getParameter("forms__phone");
        String sexo = request.getParameter("forms__sex");


        Empleado empleado = new Empleado(nombre, apellido, telefono, sexo);

        int registrosModificados = new empleadoDAO().insertar(empleado);
        System.out.println("registrosModificados = " + registrosModificados);

        this.accionDefault(request, response);
    }

    private void modificarEmpleado(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idEmpleado = Integer.parseInt(request.getParameter("idEmpleado"));
        String nombre = request.getParameter("forms__name");
        String apellido = request.getParameter("forms__last-name");
        String telefono = request.getParameter("forms__phone");
        String sexo = request.getParameter("forms__sex");



        Empleado empleado = new Empleado(idEmpleado, nombre, apellido, telefono, sexo);

        int registrosModificados = new empleadoDAO().actualizar(empleado);
        System.out.println("registrosModificados = " + registrosModificados);

        this.accionDefault(request, response);
    }
    
        private void eliminarEmpleado(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idEmpleado = Integer.parseInt(request.getParameter("idEmpleado"));
     

        Empleado empleado = new Empleado(idEmpleado);

        int registrosModificados = new empleadoDAO().eliminar(empleado);
        System.out.println("registrosModificados = " + registrosModificados);

        this.accionDefault(request, response);
    }

}

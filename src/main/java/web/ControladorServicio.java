package web;

import datos.servicioDAO;
import dominio.Servicio;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ControladorServicio")
public class ControladorServicio extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "editar":
                    this.editarServicio(request, response);
                    break;
                case "eliminar":
                    this.eliminarServicio(request, response);
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
        List<Servicio> servicios = new servicioDAO().seleccionar();
        HttpSession sesion = request.getSession();
        sesion.setAttribute("servicios", servicios);
        System.out.println("AyudA" + servicios);
     
        response.sendRedirect("servicios.jsp");
        
    }

    private void editarServicio(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idServicio = Integer.parseInt(request.getParameter("idServicio"));

        Servicio servicio = new servicioDAO().buscar(new Servicio(idServicio));
        request.setAttribute("servicio", servicio);
        String jspEditar = "paginas/servicio/servicioFormUpdate.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    this.insertarServicio(request, response);
                    break;
                case "modificar":
                    this.modificarServicio(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
    }

    private void insertarServicio(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("forms__name");
        String descripcion = request.getParameter("forms__description");
        double precio = Double.parseDouble(request.getParameter("forms__price"));


        Servicio servicio = new Servicio(nombre, descripcion, precio);

        int registrosModificados = new servicioDAO().insertar(servicio);
        System.out.println("registrosModificados = " + registrosModificados);

        this.accionDefault(request, response);
    }

    private void modificarServicio(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idServicio = Integer.parseInt(request.getParameter("idServicio"));
        String nombre = request.getParameter("forms__name");
        String descripcion = request.getParameter("forms__description");
        double precio = Double.parseDouble(request.getParameter("forms__price"));


        Servicio servicio = new Servicio(idServicio, nombre, descripcion, precio);

        int registrosModificados = new servicioDAO().actualizar(servicio);
        System.out.println("registrosModificados = " + registrosModificados);

        this.accionDefault(request, response);
    }
    
        private void eliminarServicio(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idServicio = Integer.parseInt(request.getParameter("idServicio"));
     

        Servicio servicio = new Servicio(idServicio);

        int registrosModificados = new servicioDAO().eliminar(servicio);
        System.out.println("registrosModificados = " + registrosModificados);

        this.accionDefault(request, response);
    }

}

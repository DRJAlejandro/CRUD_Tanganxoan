package web;

import datos.ventaDAO;
import datos.clienteDAO;
import datos.empleadoDAO;
import datos.equinoDAO;
import datos.servicioDAO;
import dominio.Venta;
import dominio.Cliente;
import dominio.Empleado;
import dominio.Equino;
import dominio.Servicio;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ControladorVenta")
public class ControladorVenta extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "editar":
                    this.editarVenta(request, response);
                    break;
                case "eliminar":
                    this.eliminarVenta(request, response);
                    break;
                    case "agregarExterno":
                    this.agregarExterno(request, response);
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
        List<Venta> ventas = new ventaDAO().seleccionar();
        HttpSession sesion = request.getSession();
        sesion.setAttribute("ventas", ventas);
        
     
        response.sendRedirect("ventas.jsp");
        System.out.println("AyudA" + ventas);
        
    }



    private void editarVenta(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idVenta = Integer.parseInt(request.getParameter("idVenta"));
        HttpSession sesion = request.getSession();
        
        
        List<Cliente> clientes = new clienteDAO().seleccionar();
        List<Empleado> empleados = new empleadoDAO().seleccionar();
        List<Servicio> servicios = new servicioDAO().seleccionar();
        List<Equino> equinos = new equinoDAO().seleccionar();

        Venta venta = new ventaDAO().buscar(new Venta(idVenta));
        request.setAttribute("venta", venta);
        sesion.setAttribute("clientes", clientes);
        sesion.setAttribute("equinos", equinos);
        sesion.setAttribute("servicios", servicios);
        sesion.setAttribute("empleados", empleados);
        
        String jspEditar = "paginas/venta/ventaFormUpdate.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);
        System.out.println("AyudA" + clientes);
        System.out.println("AyudA" + empleados);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    this.insertarVenta(request, response);
                    break;
                case "modificar":
                    this.modificarVenta(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
    }

    private void insertarVenta(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String fecha = request.getParameter("forms__date");
        int caballo = Integer.parseInt(request.getParameter("forms__clientid"));
        int cliente = Integer.parseInt(request.getParameter("forms__horseid"));
        int empleado = Integer.parseInt(request.getParameter("forms__emplyeid"));
        int servicio = Integer.parseInt(request.getParameter("forms__serviceid"));
        double costoTotal = Double.parseDouble(request.getParameter("forms__cost"));
       

        Venta venta = new Venta(fecha, caballo, cliente, empleado,servicio,costoTotal);

        int registrosModificados = new ventaDAO().insertar(venta);
        System.out.println("registrosModificados = " + registrosModificados);

        this.accionDefault(request, response);
    }

    private void modificarVenta(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idVenta = Integer.parseInt(request.getParameter("idVenta"));
        String fecha = request.getParameter("forms__date");
        int caballo = Integer.parseInt(request.getParameter("forms__clientid"));
        int cliente = Integer.parseInt(request.getParameter("forms__horseid"));
        int empleado = Integer.parseInt(request.getParameter("forms__emplyeid"));
        int servicio = Integer.parseInt(request.getParameter("forms__serviceid"));
        double costoTotal = Double.parseDouble(request.getParameter("forms__cost"));
        
        



        Venta venta = new Venta(idVenta, fecha, caballo, cliente, empleado,servicio,costoTotal);

        int registrosModificados = new ventaDAO().actualizar(venta);
        System.out.println("registrosModificados = " + registrosModificados);

        this.accionDefault(request, response);
    }
    
        private void eliminarVenta(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idVenta = Integer.parseInt(request.getParameter("idVenta"));
     

        Venta venta = new Venta(idVenta);

        int registrosModificados = new ventaDAO().eliminar(venta);
        System.out.println("registrosModificados = " + registrosModificados);

        this.accionDefault(request, response);
    }
        
        private void agregarExterno(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Cliente> clientes = new clienteDAO().seleccionar();
        List<Empleado> empleados = new empleadoDAO().seleccionar();
        List<Servicio> servicios = new servicioDAO().seleccionar();
        List<Equino> equinos = new equinoDAO().seleccionar();
        
        HttpSession sesion = request.getSession();
        sesion.setAttribute("clientes", clientes);
        sesion.setAttribute("equinos", equinos);
        sesion.setAttribute("servicios", servicios);
        sesion.setAttribute("empleados", empleados);
        
        response.sendRedirect("paginas/venta/ventaFormAgregar.jsp");
        System.out.println("AyudA" + clientes);
        System.out.println("AyudA" + empleados);
    }

}

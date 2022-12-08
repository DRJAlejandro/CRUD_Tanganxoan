package web;

import datos.equinoDAO;
import dominio.Equino;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ControladorEquino")
public class ControladorEquino extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "editar":
                    this.editarEquino(request, response);
                    break;
                case "eliminar":
                    this.eliminarEquino(request, response);
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
        List<Equino> equinos = new equinoDAO().seleccionar();
        
        HttpSession sesion = request.getSession();
        sesion.setAttribute("equinos", equinos);
     System.out.println("Ayuda " + equinos);
        response.sendRedirect("equinos.jsp");
        
    }

    private void editarEquino(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idEquino = Integer.parseInt(request.getParameter("idEquino"));

        Equino equino = new equinoDAO().buscar(new Equino(idEquino));
        request.setAttribute("equino", equino);
        String jspEditar = "paginas/equino/equinoFormUpdate.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    this.insertarEquino(request, response);
                    break;
                case "modificar":
                    this.modificarEquino(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
    }

    private void insertarEquino(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("forms__name");
        String raza = request.getParameter("forms__race");
        String sexo = request.getParameter("forms__sex");


        Equino equino = new Equino(nombre, raza, sexo);

        int registrosModificados = new equinoDAO().insertar(equino);
        System.out.println("registrosModificados = " + registrosModificados);

        this.accionDefault(request, response);
    }

    private void modificarEquino(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idEquino = Integer.parseInt(request.getParameter("idEquino"));
        String nombre = request.getParameter("forms__name");
        String raza = request.getParameter("forms__race");
        String sexo = request.getParameter("forms__sex");


        Equino equino = new Equino(idEquino, nombre, raza, sexo);

        int registrosModificados = new equinoDAO().actualizar(equino);
        System.out.println("registrosModificados = " + registrosModificados);

        this.accionDefault(request, response);
    }
    
        private void eliminarEquino(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idEquino = Integer.parseInt(request.getParameter("idEquino"));
     

        Equino equino = new Equino(idEquino);

        int registrosModificados = new equinoDAO().eliminar(equino);
        System.out.println("registrosModificados = " + registrosModificados);

        this.accionDefault(request, response);
    }

}

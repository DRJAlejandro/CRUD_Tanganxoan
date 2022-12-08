package web;

import datos.usuarioDAO;
import dominio.Usuario;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ControladorUsuario")
public class ControladorUsuario extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "editar":
                    this.editarUsuario(request, response);
                    break;
                case "eliminar":
                    this.eliminarUsuario(request, response);
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
        List<Usuario> usuarios = new usuarioDAO().seleccionar();
        
        HttpSession sesion = request.getSession();
        sesion.setAttribute("usuarios", usuarios);
     System.out.println("Ayuda " + usuarios);
        response.sendRedirect("usuarios.jsp");
        
    }

    private void editarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));

        Usuario usuario = new usuarioDAO().buscar(new Usuario(idUsuario));
        request.setAttribute("usuario", usuario);
        String jspEditar = "paginas/usuario/usuarioFormUpdate.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    this.insertarUsuario(request, response);
                    break;
                case "modificar":
                    this.modificarUsuario(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
    }

    private void insertarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("forms__name");
        String password = request.getParameter("forms__password");


        Usuario usuario = new Usuario(nombre, password);

        int registrosModificados = new usuarioDAO().insertar(usuario);
        System.out.println("registrosModificados = " + registrosModificados);

        this.accionDefault(request, response);
    }

    private void modificarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
        String nombre = request.getParameter("forms__name2");
        String password = request.getParameter("forms__password2");



        Usuario usuario = new Usuario(idUsuario, nombre, password);

        int registrosModificados = new usuarioDAO().actualizar(usuario);
        System.out.println("registrosModificados = " + registrosModificados);

        this.accionDefault(request, response);
    }
    
        private void eliminarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
     

        Usuario usuario = new Usuario(idUsuario);

        int registrosModificados = new usuarioDAO().eliminar(usuario);
        System.out.println("registrosModificados = " + registrosModificados);

        this.accionDefault(request, response);
    }

}

package datos;

import static datos.Conexion.close;
import dominio.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class usuarioDAO {

    
    private static final String SQL_SELECT = "SELECT * from usuario";
    private static final String SQL_INSERT = "INSERT INTO usuario(nombre, password)"
            + " VALUES (?,?)";
    private static final String SQL_SEARCH = "SELECT idUSUARIO, nombre, password from usuario WHERE idUSUARIO = ?";
    private static final String SQL_UPDATE = "UPDATE usuario SET nombre = ?, password = ? WHERE idUSUAIO = ?";
    private static final String SQL_DELETE = "DELETE FROM usuario WHERE idUSUARIO = ?";

    public List<Usuario> seleccionar() {
        Connection con = null;
        PreparedStatement prestm = null;
        ResultSet rs = null;
        Usuario usuario = null;
        List<Usuario> usuarios = new ArrayList<>();

        try {
            con = Conexion.getConnection();//hace la conexión
            prestm = con.prepareStatement(SQL_SELECT); //Agarra el statement
            rs = prestm.executeQuery();//lo ejecuta

            while (rs.next()) {
                int idUsuario = rs.getInt("idUSUARIO");
                String nombre = rs.getNString("nombre");
                String password = rs.getNString("password");
             

                usuario = new Usuario(idUsuario, nombre, password);
                usuarios.add(usuario);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(rs);
            close(prestm);
            close(con);
        }
        return usuarios;
    }

    public int insertar(Usuario usuario) {
        Connection con = null;
        PreparedStatement prestm = null;

        int registros = 0;

        try {
            con = Conexion.getConnection();
            prestm = con.prepareStatement(SQL_INSERT);
            prestm.setString(1, usuario.getUsuario());
            prestm.setString(2, usuario.getPassword());
 

            registros = prestm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(prestm);
            close(con);
        }
        return registros;
    }

    public int actualizar(Usuario usuario){
        Connection con = null;
        PreparedStatement prestm = null;
        int registros = 0;

        try {
            con = Conexion.getConnection();
            prestm = con.prepareStatement(SQL_UPDATE);

            prestm.setString(1, usuario.getUsuario());
            prestm.setString(2, usuario.getPassword());
            prestm.setInt(3, usuario.getIdUsuario());
            registros = prestm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(prestm);
            close(con);
        }
        return registros;
    }

    public int eliminar(Usuario usuario) {
        Connection con = null;
        PreparedStatement prestm = null;

        int registros = 0;

        try {
            con = Conexion.getConnection();
            prestm = con.prepareStatement(SQL_DELETE);
            prestm.setInt(1, usuario.getIdUsuario());
            registros = prestm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(prestm);
            close(con);
        }
        return registros;
    }

    public Usuario buscar(Usuario usuario) {
        Connection con = null;
        PreparedStatement prestm = null;
        ResultSet rs = null;
        try {
            con = Conexion.getConnection();
            prestm = con.prepareStatement(SQL_SEARCH);
            prestm.setInt(1, usuario.getIdUsuario());
            rs = prestm.executeQuery();
            

            
                 while (rs.next()) {
                int idUsuario = rs.getInt("idUSUARIO");
                String nombre = rs.getNString("usuario");
                String password = rs.getNString("password");
 

                usuario = new Usuario(idUsuario, nombre, password);
            }                   

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(rs);
            close(prestm);
            close(con);
        }
        return usuario;
    }

}

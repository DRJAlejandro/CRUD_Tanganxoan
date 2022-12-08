package datos;

import static datos.Conexion.close;
import dominio.Servicio;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class servicioDAO {

    private static final String SQL_SELECT = "SELECT idSERVICIO, Nombre, Descripcion, Precio FROM servicio";
    private static final String SQL_INSERT = "INSERT INTO servicio(Nombre, Descripcion, Precio) VALUES (?,?,?)";
    private static final String SQL_UPDATE = "UPDATE servicio SET Nombre = ?, Descripcion = ?, Precio = ? WHERE idSERVICIO = ?";
    private static final String SQL_DELETE = "DELETE FROM servicio WHERE idSERVICIO = ?";
    
    private static final String SQL_SEARCH = "SELECT idSERVICIO, Nombre, Descripcion, Precio from servicio WHERE idSERVICIO = ?";


    public List<Servicio> seleccionar() {
        Connection con = null;
        PreparedStatement prestm = null;
        ResultSet rs = null;
        Servicio servicio = null;
        List<Servicio> servicios = new ArrayList<>();

        try {
            con = Conexion.getConnection();//hace la conexión
            prestm = con.prepareStatement(SQL_SELECT); //Agarra el statement
            rs = prestm.executeQuery();//lo ejecuta

            while (rs.next()) {
                int idServicio = rs.getInt("idSERVICIO");
                String nombre = rs.getString("Nombre");
                String descripcion = rs.getString("Descripcion");
                double precio = rs.getInt("Precio");
               
                
                servicio = new Servicio(idServicio, nombre, descripcion, precio);
                servicios.add(servicio);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(servicioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(rs);
            close(prestm);
            close(con);
        }
        return servicios;
    }

    public int insertar(Servicio servicio) {
        Connection con = null;
        PreparedStatement prestm = null;

        int registros = 0;

        try {
            con = Conexion.getConnection();
            prestm = con.prepareStatement(SQL_INSERT);
            prestm.setString(1, servicio.getNombre());
            prestm.setString(2, servicio.getDescripcion());
            prestm.setDouble(3, servicio.getPrecio());
            registros = prestm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(servicioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(prestm);
            close(con);
        }
        return registros;
    }

    public int actualizar(Servicio servicio){
        Connection con = null;
        PreparedStatement prestm = null;
        int registros = 0;

        try {
            con = Conexion.getConnection();
            prestm = con.prepareStatement(SQL_UPDATE);

            prestm.setString(1, servicio.getNombre());
            prestm.setString(2, servicio.getDescripcion());
            prestm.setDouble(3, servicio.getPrecio());
            prestm.setInt(4, servicio.getIdServicio());
            registros = prestm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(servicioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(prestm);
            close(con);
        }
        return registros;
    }

    public int eliminar(Servicio servicio) {
        Connection con = null;
        PreparedStatement prestm = null;

        int registros = 0;

        try {
            con = Conexion.getConnection();
            prestm = con.prepareStatement(SQL_DELETE);
            prestm.setInt(1, servicio.getIdServicio());
            registros = prestm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(servicioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(prestm);
            close(con);
        }
        return registros;
    }

    public Servicio buscar(Servicio servicio) {
        Connection con = null;
        PreparedStatement prestm = null;
        ResultSet rs = null;
        try {
            con = Conexion.getConnection();
            prestm = con.prepareStatement(SQL_SEARCH);
            prestm.setInt(1, servicio.getIdServicio());
            rs = prestm.executeQuery();
            

            
                 while (rs.next()) {
                int idServicio = rs.getInt("idSERVICIO");
                String nombre = rs.getString("Nombre");
                String descripcion = rs.getString("Descripcion");
                double precio = rs.getInt("Precio");

                servicio = new Servicio(idServicio, nombre, descripcion, precio);
            }                   

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(servicioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(rs);
            close(prestm);
            close(con);
        }
        return servicio;
    }

}


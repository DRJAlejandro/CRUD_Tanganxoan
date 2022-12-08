package datos;


import static datos.Conexion.close;
import dominio.Empleado;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class empleadoDAO {

    private static final String SQL_SELECT = "SELECT idEMPLEADO, Nombre, Apellido, Telefono, Sexo FROM empleado";
    private static final String SQL_INSERT = "INSERT INTO empleado(Nombre, Apellido, Telefono, Sexo) VALUES (?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE empleado SET Nombre = ?, Apellido = ?, Telefono = ?, Sexo = ? WHERE idEMPLEADO = ?";
    private static final String SQL_DELETE = "DELETE FROM empleado WHERE idEMPLEADO = ?";
    private static final String SQL_SEARCH = "SELECT idEMPLEADO, Nombre, Apellido, Telefono, Sexo from empleado WHERE idEMPLEADO = ?";


    public List<Empleado> seleccionar() {
        Connection con = null;
        PreparedStatement prestm = null;
        ResultSet rs = null;
        Empleado empleado = null;
        List<Empleado> empleados = new ArrayList<>();

        try {
            con = Conexion.getConnection();//hace la conexión
            prestm = con.prepareStatement(SQL_SELECT); //Agarra el statement
            rs = prestm.executeQuery();//lo ejecuta

            while (rs.next()) {
                int idEmpleado = rs.getInt("idEMPLEADO");
                String nombre = rs.getString("Nombre");
                String apellido = rs.getString("Apellido");
                String telefono = rs.getString("Telefono");
                String sexo = rs.getString("Sexo");            
                empleado = new Empleado(idEmpleado, nombre, apellido, telefono, sexo);
                empleados.add(empleado);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(empleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(rs);
            close(prestm);
            close(con);
        }
        return empleados;
    }

    public int insertar(Empleado empleado) {
        Connection con = null;
        PreparedStatement pst = null;

        int registros = 0;

        try {
            con = Conexion.getConnection();
            pst = con.prepareStatement(SQL_INSERT);
            pst.setString(1, empleado.getNombre());
            pst.setString(2, empleado.getApellido());
            pst.setString(3, empleado.getTelefono());
            pst.setString(4, empleado.getSexo());

            registros = pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(empleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(pst);
            close(con);
        }
        return registros;
    }

    public int actualizar(Empleado empleado){
        Connection con = null;
        PreparedStatement pst = null;
        int registros = 0;

        try {
            con = Conexion.getConnection();
            pst = con.prepareStatement(SQL_UPDATE);

            pst.setString(1, empleado.getNombre());
            pst.setString(2, empleado.getApellido());
            pst.setString(3, empleado.getTelefono());
            pst.setString(4, empleado.getSexo());
            pst.setInt(5, empleado.getIdEmpleado());
            
            registros = pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(empleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(pst);
            close(con);
        }
        return registros;
    }

    public int eliminar(Empleado empleado) {
        Connection con = null;
        PreparedStatement prestm = null;

        int registros = 0;

        try {
            con = Conexion.getConnection();
            prestm = con.prepareStatement(SQL_DELETE);
            prestm.setInt(1, empleado.getIdEmpleado());
            registros = prestm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(empleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(prestm);
            close(con);
        }
        return registros;
    }

    public Empleado buscar(Empleado empleado) {
        Connection con = null;
        PreparedStatement prestm = null;
        ResultSet rs = null;
        try {
            con = Conexion.getConnection();
            prestm = con.prepareStatement(SQL_SEARCH);
            prestm.setInt(1, empleado.getIdEmpleado());
            rs = prestm.executeQuery();
            

            
                 while (rs.next()) {
                int idEmpleado = rs.getInt("idEMPLEADO");
                String nombre = rs.getString("Nombre");
                String apellido = rs.getString("Apellido");
                String telefono = rs.getString("Telefono");
                String sexo = rs.getString("Sexo");
                
                empleado = new Empleado(idEmpleado, nombre, apellido, telefono, sexo);
            }                   

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(empleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(rs);
            close(prestm);
            close(con);
        }
        return empleado;
    }

}


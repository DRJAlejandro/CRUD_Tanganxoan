package datos;


import static datos.Conexion.close;
import dominio.Venta;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ventaDAO {

    private static final String SQL_SELECT = "SELECT idVENTA, Fecha, idCLIENTE, idEQUINO, idEMPLEADO, idSERVICIO, costoTotal  FROM venta";
    private static final String SQL_INSERT = "INSERT INTO venta(Fecha, idCLIENTE, idEQUINO, idEMPLEADO, idSERVICIO, costoTotal) VALUES (?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE venta SET Fecha = ?, idCLIENTE = ?, idEQUINO = ?, idEMPLEADO = ?, idSERVICIO = ?, costoTotal = ? WHERE idVENTA = ?";
    private static final String SQL_DELETE = "DELETE FROM venta WHERE idVenta = ?";
    private static final String SQL_SEARCH = "SELECT idVENTA, Fecha, idCLIENTE, idEQUINO, idEMPLEADO, idSERVICIO, costoTotal from venta WHERE idVENTA = ?";


    public List<Venta> seleccionar() {
        Connection con = null;
        PreparedStatement prestm = null;
        ResultSet rs = null;
        Venta venta = null;
        List<Venta> ventas = new ArrayList<>();

        try {
            con = Conexion.getConnection();//hace la conexión
            prestm = con.prepareStatement(SQL_SELECT); //Agarra el statement
            rs = prestm.executeQuery();//lo ejecuta

            while (rs.next()) {
                int idVenta = rs.getInt("idVENTA");
                String fecha = rs.getString("Fecha");
                int idCliente = rs.getInt("idCLIENTE");
                int idEquino = rs.getInt("idEQUINO");
                int idEmpleado = rs.getInt("idEMPLEADO");
                int idServicio = rs.getInt("idSERVICIO");
                double costoTotal = rs.getDouble("costoTotal");
                
                venta = new Venta(idVenta, fecha, idCliente, idEquino, idEmpleado,idServicio,costoTotal);
                ventas.add(venta);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ventaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(rs);
            close(prestm);
            close(con);
        }
        return ventas;
    }

    public int insertar(Venta venta) {
        Connection con = null;
        PreparedStatement pst = null;

        int registros = 0;

        try {
            con = Conexion.getConnection();
            pst = con.prepareStatement(SQL_INSERT);
            pst.setString(1, venta.getFecha());
            pst.setInt(2, venta.getIdCliente());
            pst.setInt(3, venta.getIdEquino());
            pst.setInt(4, venta.getIdEmpleado());
            pst.setInt(5, venta.getIdServicio());
            pst.setDouble(6, venta.getCostoTotal());
            registros = pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ventaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(pst);
            close(con);
        }
        return registros;
    }

    public int actualizar(Venta venta){
        Connection con = null;
        PreparedStatement pst = null;
        int registros = 0;

        try {
            con = Conexion.getConnection();
            pst = con.prepareStatement(SQL_UPDATE);

            pst.setString(1, venta.getFecha());
            pst.setInt(2, venta.getIdCliente());
            pst.setInt(3, venta.getIdEquino());
            pst.setInt(4, venta.getIdEmpleado());
            pst.setInt(5, venta.getIdServicio());
            pst.setDouble(6, venta.getCostoTotal());
            pst.setDouble(7, venta.getIdVenta());
            
            registros = pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ventaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(pst);
            close(con);
        }
        return registros;
    }

    public int eliminar(Venta venta) {
        Connection con = null;
        PreparedStatement prestm = null;

        int registros = 0;

        try {
            con = Conexion.getConnection();
            prestm = con.prepareStatement(SQL_DELETE);
            prestm.setInt(1, venta.getIdVenta());
            registros = prestm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ventaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(prestm);
            close(con);
        }
        return registros;
    }

    public Venta buscar(Venta venta) {
        Connection con = null;
        PreparedStatement prestm = null;
        ResultSet rs = null;
        try {
            con = Conexion.getConnection();
            prestm = con.prepareStatement(SQL_SEARCH);
            prestm.setInt(1, venta.getIdVenta());
            rs = prestm.executeQuery();
            

            
                 while (rs.next()) {
                int idVenta = rs.getInt("idVENTA");
                String fecha = rs.getString("Fecha");
                int idCliente = rs.getInt("idCLIENTE");
                int idEquino = rs.getInt("idEQUINO");
                int idEmpleado = rs.getInt("idEMPLEADO");
                int idServicio = rs.getInt("idSERVICIO");
                double costoTotal = rs.getDouble("costoTotal");
                
                venta = new Venta(idVenta, fecha, idCliente, idEquino, idEmpleado,idServicio,costoTotal);            }                   

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ventaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(rs);
            close(prestm);
            close(con);
        }
        return venta;
    }

}


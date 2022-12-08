package datos;


import static datos.Conexion.close;
import dominio.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class clienteDAO {

    //SQL sentences
    private static final String SQL_SELECT = "SELECT idCLIENTE, Nombre, Apellido, Telefono, Sexo FROM cliente";
    private static final String SQL_INSERT = "INSERT INTO cliente(Nombre, Apellido, Telefono, Sexo) VALUES (?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE cliente SET Nombre = ?, Apellido = ?, Telefono = ?, Sexo = ? WHERE idCLIENTE = ?";
    private static final String SQL_DELETE = "DELETE FROM cliente WHERE idCLIENTE = ?";

    private static final String SQL_SEARCH = "SELECT idCLIENTE, Nombre, Apellido, Telefono, Sexo from cliente WHERE idCLIENTE = ?";


    public List<Cliente> seleccionar() {
        Connection con = null;
        PreparedStatement prestm = null;
        ResultSet rs = null;
        Cliente cliente = null;
        List<Cliente> clientes = new ArrayList<>();

        try {
            con = Conexion.getConnection();//hace la conexión
            prestm = con.prepareStatement(SQL_SELECT); //Agarra el statement
            rs = prestm.executeQuery();//lo ejecuta

            while (rs.next()) {
                int idCliente = rs.getInt("idCLIENTE");
                String nombre = rs.getString("Nombre");
                String apellido = rs.getString("Apellido");
                String telefono = rs.getString("Telefono");
                String sexo = rs.getString("Sexo");            
                cliente = new Cliente(idCliente, nombre, apellido, telefono, sexo);
                clientes.add(cliente);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(clienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(rs);
            close(prestm);
            close(con);
        }
        return clientes;
    }

    public int insertar(Cliente cliente) {
        Connection con = null;
        PreparedStatement pst = null;

        int registros = 0;

        try {
            con = Conexion.getConnection();
            pst = con.prepareStatement(SQL_INSERT);
            pst.setString(1, cliente.getNombre());
            pst.setString(2, cliente.getApellido());
            pst.setString(3, cliente.getTelefono());
            pst.setString(4, cliente.getSexo());

            registros = pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(clienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(pst);
            close(con);
        }
        return registros;
    }

    public int actualizar(Cliente cliente){
        Connection con = null;
        PreparedStatement pst = null;
        int registros = 0;

        try {
            con = Conexion.getConnection();
            pst = con.prepareStatement(SQL_UPDATE);

            pst.setString(1, cliente.getNombre());
            pst.setString(2, cliente.getApellido());
            pst.setString(3, cliente.getTelefono());
            pst.setString(4, cliente.getSexo());
            pst.setInt(5, cliente.getIdCliente());
            
            registros = pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(clienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(pst);
            close(con);
        }
        return registros;
    }

    public int eliminar(Cliente cliente) {
        Connection con = null;
        PreparedStatement prestm = null;

        int registros = 0;

        try {
            con = Conexion.getConnection();
            prestm = con.prepareStatement(SQL_DELETE);
            prestm.setInt(1, cliente.getIdCliente());
            registros = prestm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(clienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(prestm);
            close(con);
        }
        return registros;
    }

    public Cliente buscar(Cliente cliente) {
        Connection con = null;
        PreparedStatement prestm = null;
        ResultSet rs = null;
        try {
            con = Conexion.getConnection();
            prestm = con.prepareStatement(SQL_SEARCH);
            prestm.setInt(1, cliente.getIdCliente());
            rs = prestm.executeQuery();
            

            
                 while (rs.next()) {
                int idCliente = rs.getInt("idCLIENTE");
                String nombre = rs.getString("Nombre");
                String apellido = rs.getString("Apellido");
                String telefono = rs.getString("Telefono");
                String sexo = rs.getString("Sexo");
                
                cliente = new Cliente(idCliente, nombre, apellido, telefono, sexo);
            }                   

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(clienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(rs);
            close(prestm);
            close(con);
        }
        return cliente;
    }

}




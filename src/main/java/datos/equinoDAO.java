package datos;

import static datos.Conexion.close;
import dominio.Equino;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class equinoDAO {

    private static final String SQL_SELECT = "SELECT * from equinos";
    private static final String SQL_INSERT = "INSERT INTO equinos(Nombre, Raza, Sexo)"
            + " VALUES (?,?,?)";
    private static final String SQL_SEARCH = "SELECT idEQUINOS, Nombre, Raza, Sexo from equinos WHERE idEQUINOS = ?";
    private static final String SQL_UPDATE = "UPDATE equinos SET Nombre = ?, Raza = ?, Sexo = ? WHERE idEQUINOS = ?";
    private static final String SQL_DELETE = "DELETE FROM equinos WHERE idEQUINOS = ?";

    public List<Equino> seleccionar() {
        Connection con = null;
        PreparedStatement prestm = null;
        ResultSet rs = null;
        Equino equino = null;
        List<Equino> equinos = new ArrayList<>();

        try {
            con = Conexion.getConnection();//hace la conexión
            prestm = con.prepareStatement(SQL_SELECT); //Agarra el statement
            rs = prestm.executeQuery();//lo ejecuta

            while (rs.next()) {
                int idEquino = rs.getInt("idEQUINOS");
                String nombre = rs.getNString("Nombre");
                String raza = rs.getNString("Raza");
                String sexo = rs.getNString("Sexo");

                equino = new Equino(idEquino, nombre, raza, sexo);
                equinos.add(equino);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(equinoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(rs);
            close(prestm);
            close(con);
        }
        return equinos;
    }

    public int insertar(Equino equino) {
        Connection con = null;
        PreparedStatement prestm = null;

        int registros = 0;

        try {
            con = Conexion.getConnection();
            prestm = con.prepareStatement(SQL_INSERT);
            prestm.setString(1, equino.getNombre());
            prestm.setString(2, equino.getRaza());
            prestm.setString(3, equino.getSexo());

            registros = prestm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(equinoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(prestm);
            close(con);
        }
        return registros;
    }

    public int actualizar(Equino equino){
        Connection con = null;
        PreparedStatement prestm = null;
        int registros = 0;

        try {
            con = Conexion.getConnection();
            prestm = con.prepareStatement(SQL_UPDATE);

            prestm.setString(1, equino.getNombre());
            prestm.setString(2, equino.getRaza());
            prestm.setString(3, equino.getSexo());
            prestm.setInt(4, equino.getIdEquino());
            registros = prestm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(equinoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(prestm);
            close(con);
        }
        return registros;
    }

    public int eliminar(Equino equino) {
        Connection con = null;
        PreparedStatement prestm = null;

        int registros = 0;

        try {
            con = Conexion.getConnection();
            prestm = con.prepareStatement(SQL_DELETE);
            prestm.setInt(1, equino.getIdEquino());
            registros = prestm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(equinoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(prestm);
            close(con);
        }
        return registros;
    }

    public Equino buscar(Equino equino) {
        Connection con = null;
        PreparedStatement prestm = null;
        ResultSet rs = null;
        try {
            con = Conexion.getConnection();
            prestm = con.prepareStatement(SQL_SEARCH);
            prestm.setInt(1, equino.getIdEquino());
            rs = prestm.executeQuery();
            

            
                 while (rs.next()) {
                int idEquino = rs.getInt("idEQUINO");
                String nombre = rs.getNString("Nombre");
                String raza = rs.getNString("Raza");
                String sexo = rs.getNString("Sexo");

                equino = new Equino(idEquino, nombre, raza, sexo);
            }                   

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(equinoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(rs);
            close(prestm);
            close(con);
        }
        return equino;
    }

}

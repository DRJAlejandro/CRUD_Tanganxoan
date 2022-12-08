/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;
import java.util.Date;

/**
 *
 * @author aleja
 */
public class Venta {
    private int idVenta;
    private String Fecha;
    private int idCliente;
    private int idEquino;
    private int idEmpleado;
    private int idServicio;
    private double costoTotal;

    public Venta() {
    }

    public Venta(int idVenta) {
        this.idVenta = idVenta;
    }

    public Venta(int idVenta, String Fecha, int idCliente, int idEquino, int idEmpleado, int idServicio, double costoTotal) {
        this.idVenta = idVenta;
        this.Fecha = Fecha;
        this.idCliente = idCliente;
        this.idEquino = idEquino;
        this.idEmpleado = idEmpleado;
        this.idServicio = idServicio;
        this.costoTotal = costoTotal;
    }

    public Venta(String Fecha, int idCliente, int idEquino, int idEmpleado, int idServicio, double costoTotal) {
        this.Fecha = Fecha;
        this.idCliente = idCliente;
        this.idEquino = idEquino;
        this.idEmpleado = idEmpleado;
        this.idServicio = idServicio;
        this.costoTotal = costoTotal;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdEquino() {
        return idEquino;
    }

    public void setIdEquino(int idEquino) {
        this.idEquino = idEquino;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Venta{");
        sb.append("idVenta=").append(idVenta);
        sb.append(", Fecha=").append(Fecha);
        sb.append(", idCliente=").append(idCliente);
        sb.append(", idEquino=").append(idEquino);
        sb.append(", idEmpleado=").append(idEmpleado);
        sb.append(", idServicio=").append(idServicio);
        sb.append(", costoTotal=").append(costoTotal);
        sb.append('}');
        return sb.toString();
    }
    

}

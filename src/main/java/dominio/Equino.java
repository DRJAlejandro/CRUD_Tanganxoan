/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author aleja
 */
public class Equino {
    private int idEquino;
    private String nombre;
    private String raza;
    private String sexo;
    
    public Equino() {
        
    }

    public Equino(int idEquino) {
        this.idEquino = idEquino;
    }

    public Equino(int idEquino, String nombre, String raza, String sexo) {
        this.idEquino = idEquino;
        this.nombre = nombre;
        this.raza = raza;
        this.sexo = sexo;
    }

    public Equino(String nombre, String raza, String sexo) {
        this.nombre = nombre;
        this.raza = raza;
        this.sexo = sexo;
    }

    public int getIdEquino() {
        return idEquino;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRaza() {
        return raza;
    }

    public String getSexo() {
        return sexo;
    }

    public void setIdEquino(int idEquino) {
        this.idEquino = idEquino;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Equino{");
        sb.append("idEquino=").append(idEquino);
        sb.append(", nombre=").append(nombre);
        sb.append(", raza=").append(raza);
        sb.append(", sexo=").append(sexo);
        sb.append('}');
        return sb.toString();
    }
    
    
        
    
}

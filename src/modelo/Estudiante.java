package modelo;


import java.util.*;

/**
 * 
 */

public class Estudiante {
    private String id;
    private String nombre;
    private String apellido;
    private int idInstitucion;
    private String correo;
    private Date fechaNacimiento;
    private String direccion;
    private String telefono;

    public Estudiante() {
        // TODO implement here
    }

    public Estudiante(String id, String nombre, String apellido, int idInstitucion, String correo, Date fechaNacimiento, String direccion, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.idInstitucion = idInstitucion;
        this.correo = correo;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getIdInstitucion() {
        return idInstitucion;
    }

    public void setIdInstitucion(int idInstitucion) {
        this.idInstitucion = idInstitucion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String toString() {
        String info = "";
        info += "id: " + id + "\n" + 
                "Nombre: " + nombre + "\n" +
                "Apellido: " + apellido + "\n" +
                "idInstitucion: " + idInstitucion + "\n" +
                "Correo: " + correo + "\n" +
                "Fecha de Nacimiento: " + fechaNacimiento + "\n" +
                "Direccion: " + direccion + "\n" +
                "Telefono: " + telefono;
        return info;
    }
    //0 iguales /1 param mayor /-1 param menor
    public int compareTo(Estudiante z){
        String nombreCompleto1=z.getNombre()+z.getApellido();
        String nombreCompleto2=getNombre()+getApellido();
        int comparacion=nombreCompleto1.compareTo(nombreCompleto2);
        if(comparacion>0){
            return 1;
        }
        if(comparacion<0){
            return -1;
        }
        return comparacion;
    }
    

}
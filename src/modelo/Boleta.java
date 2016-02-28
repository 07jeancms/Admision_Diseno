package modelo;


import java.util.*;
import modelo.Estado;
import modelo.Resultado;

public class Boleta {
    
    private Date fechaDeSolicitud;
    private int numeroDeBoleta;
    private float calificacion;
    private Estado estado;
    private Resultado resultado;
    private Estudiante estudiante;
    
    public Boleta() {
    }

    public Boleta(Date fechaDeSolicitud, int numeroDeBoleta, float calificacion, Estado estado, Estudiante estudiante) {
        this.fechaDeSolicitud = fechaDeSolicitud;
        this.numeroDeBoleta = numeroDeBoleta;
        this.estado = estado;
        setNota(calificacion);
        this.estudiante = estudiante;
    }

    public Date getFechaDeSolicitud() {
        return fechaDeSolicitud;
    }

    public void setFechaDeSolicitud(Date fechaDeSolicitud) {
        this.fechaDeSolicitud = fechaDeSolicitud;
    }

    public int getNumeroDeBoleta() {
        return numeroDeBoleta;
    }

    public void setNumeroDeBoleta(int numeroDeBoleta) {
        this.numeroDeBoleta = numeroDeBoleta;
    }

    public float getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(float calificacion) {
        this.calificacion = calificacion;
        if(calificacion >= 70) 
            setResultado(resultado.Aprobado);
        if(calificacion >= 65 && calificacion < 70) 
            setResultado(resultado.Elegible);
        if (calificacion < 65) 
            setResultado(resultado.Rechazado);
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Resultado getResultado() {
        return resultado;
    }

    public void setResultado(Resultado resultado) {
        this.resultado = resultado;
    }
    
    // Cambia la nota y de acuerdo a esa nota cambia el resultado y ademas cambia el estado de la boleta a Activo 
    public void setNota(float calificacion) {
        setCalificacion(calificacion);
        setEstado(estado.Activo);
    }

    @Override
    public String toString() {
        String info = "";
        info += "Fecha de Solicitud: " + fechaDeSolicitud.toString() + "\n" + 
        "Numero de Boleta: " + numeroDeBoleta + "\n" + 
        "Calificacion: " + calificacion + "\n" + 
        "Estado: " + estado + "\n" + 
        "Resultado: " + resultado + 
        "\n --- Info Estudiante --- \n" + 
        estudiante.toString();
        return info;
    }
    
    
    // Cambia la nota y de acuerdo a esa nota cambia el resultado
    public void actualizarCalificacion(float calificacion) {
        setCalificacion(calificacion);
    }
    
    public boolean equals(int id){
        return numeroDeBoleta == id;
    }
    
}
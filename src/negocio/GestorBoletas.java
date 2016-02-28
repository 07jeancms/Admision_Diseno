package negocio;


import modelo.Boleta;
import java.util.*;
import modelo.Estado;
import modelo.Estudiante;
import modelo.Generador;

/**
 * 
 */
public class GestorBoletas {
    
    private ArrayList<Boleta> boletas;
    private int contadorAprobados;
    private int contadorRechazados;
    private int contadorElegibles;
    private Generador generador;


    public GestorBoletas() {
        boletas = new ArrayList<>();
        contadorAprobados = 0;
        contadorRechazados = 0;
        contadorElegibles = 0;
        generador = new Generador();
    }

    public ArrayList<Boleta> getBoletas() {
        return boletas;
    }

    public void setBoletas(ArrayList<Boleta> boletas) {
        this.boletas = boletas;
    }

    public int getContadorAprobados() {
        return contadorAprobados;
    }

    public void setContadorAprobados(int contadorAprobados) {
        this.contadorAprobados = contadorAprobados;
    }

    public int getContadorRechazados() {
        return contadorRechazados;
    }

    public void setContadorRechazados(int contadorRechazados) {
        this.contadorRechazados = contadorRechazados;
    }

    public int getContadorElegibles() {
        return contadorElegibles;
    }

    public void setContadorElegibles(int contadorElegibles) {
        this.contadorElegibles = contadorElegibles;
    }

    public Generador getGenerador() {
        return generador;
    }

    public void setGenerador(Generador generador) {
        this.generador = generador;
    }

    public void insertarBoleta(Boleta boleta) {
        boletas.add(boleta);
    }

    public ArrayList <Boleta> ordenamientoAlfabetico() {
        // TODO implement here
        return null;
    }

    public ArrayList <Boleta> ordenamientoNota() {
        // TODO implement here
        return null;
    }

    public String toString() {
        String info = "";
        for(int boletaActual = 0; boletaActual < boletas.size(); boletaActual++){
            info += "BOLETA #" + boletas.get(boletaActual).getNumeroDeBoleta() + "\n" +
                    boletas.get(boletaActual).toString() +
                    "\n-------------------------------\n";
        }
        return info;
    }

    public ArrayList <Boleta> filtrarPorResultado() {
        // TODO implement here
        return null;
    }

    public String construirReporte() {
        // TODO implement here
        return "";
    }

    public String construirReporteConTresMejoresPromedios() {
        // TODO implement here
        return "";
    }

    public String actualizarCalificacion(float calificacion, int numeroBoleta) {
        for(int actual = 0; actual < boletas.size(); actual++){
            Boleta actualBoleta = boletas.get(actual);
            if(actualBoleta.equals(numeroBoleta)){
                actualBoleta.actualizarCalificacion(calificacion);
                return "Se ha actualizado la boleta #" + numeroBoleta;
            }
        }
        return "Boleta no valida";
    }
        
    // Crear boletas usando a la clase "Generador" (De forma aleatoria)
    public void crearBoletas(int cantidad) {
        for(int cantidadBoletas = 0; cantidadBoletas < cantidad; cantidadBoletas++){      
            String nombre = generador.seleccionarNombre();
            String apellido = generador.seleccionarAppellido();
            Estudiante estudiante = new Estudiante(cantidadBoletas+"", nombre, apellido, 
                    cantidadBoletas, generador.crearCorreo(nombre, apellido), generador.crearFecha(), generador.crearDireccion(), generador.crearTelefono());
            Boleta boleta = new Boleta(generador.crearFecha(), cantidadBoletas, generador.crearNota(), Estado.Activo, estudiante);
            insertarBoleta(boleta);
        }
    }

}
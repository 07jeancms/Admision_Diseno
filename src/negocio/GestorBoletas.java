package negocio;

import modelo.Boleta;
import java.util.*;
import modelo.Estado;
import modelo.Estudiante;
import modelo.Generador;
import modelo.Resultado;

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
        switch(boleta.getResultado()){
            case Rechazado:
                this.contadorRechazados++;
                break;
            case Aprobado:
                this.contadorAprobados++;
                break;
            case Elegible:
                this.contadorElegibles++;
                break;
            default:
                break;
             
        }
    }

    public String toString() {
        String info = "";
        for (int boletaActual = 0; boletaActual < boletas.size(); boletaActual++) {
            info += "BOLETA #" + boletas.get(boletaActual).getNumeroDeBoleta() + "\n"
                    + boletas.get(boletaActual).toString()
                    + "\n-------------------------------\n";
        }
        return info;
    }

    public ArrayList<Boleta> filtrarPorResultado(Resultado resultadoAFiltrar) {
        // TODO implement here
        ArrayList<Boleta> boletasFiltradas = new ArrayList<>();
        for (Boleta boletaAFiltrar : this.getBoletas()) {
            if(boletaAFiltrar.getResultado().equals(resultadoAFiltrar)){
                boletasFiltradas.add(boletaAFiltrar);
            }
                
            }
        return boletasFiltradas;
    }
    public HashMap obtenerPorcentajes(){
        float cantidadDeAplicantes = this.boletas.size();
        HashMap<Resultado,Float> porcentajes = new HashMap<>() ;
        porcentajes.put(Resultado.Aprobado, (this.contadorAprobados/cantidadDeAplicantes)*100);
        porcentajes.put(Resultado.Rechazado, (this.contadorRechazados/cantidadDeAplicantes)*100);
        porcentajes.put(Resultado.Elegible, (this.contadorElegibles/cantidadDeAplicantes)*100);
        
        //porcentajes.<"admitidos",this.contadorAprobados/cantidadDeAplicantes>;
        return porcentajes;
    }
    public String construirReporte() {
        // TODO implement here
        String reporte = "Reporte \n";
        //Primero se muestran el total de aplicantes
        int cantidadDeAplicantes = this.boletas.size();
        reporte +="-Total de aplicantes "+cantidadDeAplicantes;
        HashMap porcentajes = obtenerPorcentajes();
        //Porcentaje de admitidos 
        reporte +="\n-Porcentaje aprobados "+porcentajes.get(Resultado.Aprobado);
        //Porcentaje de elegibles 
        
        reporte +="\n-Porcentaje elegibles "+porcentajes.get(Resultado.Elegible);
         //Porcentaje de rechazados 
        reporte +="\n-Porcentaje rechazados "+porcentajes.get(Resultado.Rechazado);
        
                
        return reporte;
    }
 
    public String construirReporteConTresMejoresPromedios() {
        // TODO implement here
        int posicion = 1;
        String reporte = "Reporte de tres mejores promedios\n";
        this.ordenarPorNota();
        for (int mejorPromedioIndice = 0; mejorPromedioIndice < 3; mejorPromedioIndice++) {
           //reporte += "\n +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-";
            reporte += "\n Posicion "+(posicion++);
            reporte += "\n \t Estudiante : "+ boletas.get(mejorPromedioIndice).getEstudiante().getNombre() + " "+ boletas.get(mejorPromedioIndice).getEstudiante().getApellido();
            reporte += "\n \t Calificacion : "+ boletas.get(mejorPromedioIndice).getCalificacion();
            
        }
        return reporte;
    }

    public String actualizarCalificacion(float calificacion, int numeroBoleta) {

        for (Boleta actualBoleta : boletas) {
            if (actualBoleta.equals(numeroBoleta)) {
                actualBoleta.actualizarCalificacion(calificacion);
                return "Se ha actualizado la boleta #" + numeroBoleta;
            }
        }
        return "Boleta no valida";
        /**
         *
         */
    }

    /**
     * public String modificar(float calificacion, int numeroBoleta){ Boleta obj
     * = new Boleta(); obj.setCalificacion(calificacion); int
     * donde=boletas.indexOf(obj); obj=boletas.get(donde);
     * obj.setCalificacion(calificacion); if (donde != -1){ boletas.set(donde,
     * obj ); return "Se ha actualizado la boleta #" + numeroBoleta; } return
     * "Boleta no valida";
    }*
     */
    // Crear boletas usando a la clase "Generador" (De forma aleatoria)
    public void crearBoletas(int cantidad) {
        for (int cantidadBoletas = 0; cantidadBoletas < cantidad; cantidadBoletas++) {
            String nombre = generador.seleccionarNombre();
            String apellido = generador.seleccionarAppellido();
            Estudiante estudiante = new Estudiante(cantidadBoletas + "", nombre, apellido,
                    cantidadBoletas, generador.crearCorreo(nombre, apellido), generador.crearFecha(), generador.crearDireccion(), generador.crearTelefono());
            Boleta boleta = new Boleta(generador.crearFecha(), cantidadBoletas, generador.crearNota(), Estado.Activo, estudiante);
            insertarBoleta(boleta);
        }
    }
    
    //Ordena de mayor a menor
    public void ordenarPorNota() {
        ArrayList<Boleta> list;
        list = this.boletas;
        Boleta temp;
        if (list.size() > 1) {
            for (int j = 0; j < list.size(); j++) {
                for (int i = 0; i < list.size() - j - 1; i++) {
                    if (list.get(i).compareTo(list.get(i + 1)) > 0) {
                        temp = list.get(i);
                        list.set(i, list.get(i + 1));
                        list.set(i + 1, temp);
                    }
                }
            }
        }
    }//Fin Ordenar por nota
    
    //Ordena por nombre y lo secundario apellidos luego por apellidos
    //Orden descendente A-Z
    public void ordenarPorAlfabeto() {
        ArrayList<Boleta> list;
        list = this.boletas;
        Boleta BTemp;
        if (list.size() > 1) {
            for (int j = 0; j < list.size(); j++) {
                for (int i = 0; i < list.size() - j - 1; i++) {
                    if (list.get(i).getEstudiante().compareTo(list.get(i + 1).getEstudiante()) < 0) {
                        BTemp = list.get(i);
                        list.set(i, list.get(i + 1));
                        list.set(i + 1, BTemp);
                    }
                }
            }
        }
    }//Fin Ordenar por alfabeto

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import static java.lang.reflect.Array.set;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;
import java.util.Random;

/**
 *
 * @author JeanCarlo
 */
public class Generador {
    private Hashtable<String, String> nombres;
    private Hashtable<String, String> apellidos;
    private Hashtable<String, String> correos;
    private Hashtable<String, String> provincias;
    private Hashtable<String, String> cantones;
    private Hashtable<String, String> distritos;
    
    public Generador(){
        nombres = new Hashtable<String, String>();
        apellidos = new Hashtable<String, String>();
        correos = new Hashtable<String, String>();
        provincias = new Hashtable<String, String>();
        cantones = new Hashtable<String, String>();
        distritos = new Hashtable<String, String>();
        llenarNombres();
        llenarApellidos();
        llenarCorreos();
        llenarProvincias();
        llenarCantones();
        llenarDistritos();
    }
    
    public void llenarNombres(){
        nombres.put("Nombre1", "JeanCarlo");
        nombres.put("Nombre2", "Katherine");
        nombres.put("Nombre3", "Maikol");
        nombres.put("Nombre4", "Andres");
        nombres.put("Nombre5", "Mariano");
        nombres.put("Nombre6", "Felipe");
        nombres.put("Nombre7", "Manuel");
        nombres.put("Nombre8", "Oscar");
        nombres.put("Nombre9", "Rosa");
        nombres.put("Nombre10", "Pablo");
    }
    
    public void llenarApellidos(){
        apellidos.put("Apellido1", "Mata");
        apellidos.put("Apellido2", "Calderon");
        apellidos.put("Apellido3", "Flores");
        apellidos.put("Apellido4", "Jimenez");
        apellidos.put("Apellido5", "Montero");
        apellidos.put("Apellido6", "Ulate");
        apellidos.put("Apellido7", "Perez");
        apellidos.put("Apellido8", "Quiros");
        apellidos.put("Apellido9", "Meneses");
        apellidos.put("Apellido10", "Lopez");   
    }
    
    public void llenarCorreos(){
        correos.put("Correo1", "hotmail.es");
        correos.put("Correo2", "gmail.com");
        correos.put("Correo3", "outlook.es");
        correos.put("Correo4", "yahoo.com");        
    }
    
    public void llenarProvincias(){
        provincias.put("Provincia1", "San Jose");
        provincias.put("Provincia2", "Cartago");
        provincias.put("Provincia3", "Alajuela");
        provincias.put("Provincia4", "Guanacaste");
        provincias.put("Provincia5", "Heredia");
        provincias.put("Provincia6", "Limon");
        provincias.put("Provincia7", "Puntarenas");
    }
    
    public void llenarCantones(){
        cantones.put("Canton1", "San Jose");
        cantones.put("Canton2", "Escazu");
        cantones.put("Canton3", "Vazquez de Coronado");
        cantones.put("Canton4", "Cartago");
        cantones.put("Canton5", "Paraiso");
        cantones.put("Canton6", "San Rafael");
        cantones.put("Canton7", "Santo Domingo");
        cantones.put("Canton8", "Guanacaste");
        cantones.put("Canton9", "Puntarenas");
        cantones.put("Canton10", "Centro");
    }
    
    public void llenarDistritos(){
        distritos.put("Distrito1", "Ipis");
        distritos.put("Distrito2", "Mozotal");
        distritos.put("Distrito3", "Escazu");
        distritos.put("Distrito4", "El Guarco");
        distritos.put("Distrito5", "Carmen");
        distritos.put("Distrito6", "Zapote");
        distritos.put("Distrito7", "Uruca");
        distritos.put("Distrito8", "Pavas");
        distritos.put("Distrito9", "Desamparados");
        distritos.put("Distrito10", "Rosario");
        
    }
    
    public String crearCorreo(String nombre, String apellido){
        Random rand = new Random();
        int randomNum = rand.nextInt((4 - 1) + 1) + 1;
        String correo = correos.get("Correo"+randomNum);
        return nombre+apellido+"@"+correo;
    }
    
    public Date crearFecha(){
        int numero = 0;
        Random aleatorio;
        aleatorio = new Random();
        Calendar unaFecha = Calendar.getInstance();
        unaFecha.set (aleatorio.nextInt(10)+2014, aleatorio.nextInt(12)+1, aleatorio.nextInt(30)+1);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MMMMM/yyyy");
        return unaFecha.getTime();
    }
    
    public String crearTelefono(){
        String numero = "";
        for (int cantidadDeDigitos = 0; cantidadDeDigitos < 8; cantidadDeDigitos++){
            Random rand = new Random();
            int randomNum = rand.nextInt((9 - 0) + 1) + 0;
            numero += randomNum;
        }
        return numero;
    }
    
    public String seleccionarNombre(){
        Random rand = new Random();
        int randomNum = rand.nextInt((10 - 1) + 1) + 1;
        return nombres.get("Nombre"+randomNum);
    }

    public String seleccionarAppellido(){
        Random rand = new Random();
        int randomNum = rand.nextInt((10 - 1) + 1) + 1;
        return apellidos.get("Apellido"+randomNum);
    }
    
    public String seleccionarProvincia(){
        Random rand = new Random();
        int randomNum = rand.nextInt((7 - 1) + 1) + 1;
        return provincias.get("Provincia"+randomNum);
    }

    public String seleccionarCanton(){
        Random rand = new Random();
        int randomNum = rand.nextInt((10 - 1) + 1) + 1;
        return cantones.get("Canton"+randomNum);
    }
 
    public String seleccionarDistrito(){
        Random rand = new Random();
        int randomNum = rand.nextInt((10 - 1) + 1) + 1;
        return distritos.get("Distrito"+randomNum);
    }
    
    public float crearNota(){
        Random rand = new Random();
        int randomNum = rand.nextInt((100 - 23) + 1) + 23;
        return randomNum; 
    }
    
    public String crearDireccion(){
        Random rand = new Random();
        int randomProvincia = rand.nextInt((7 - 1) + 1) + 1;
        int randomCanton = rand.nextInt((10 - 1) + 1) + 1;
        int randomDistrito = rand.nextInt((10 - 1) + 1) + 1;
        return provincias.get("Provincia"+randomProvincia) +", "+ cantones.get("Canton"+randomCanton) +", "+ distritos.get("Distrito"+randomDistrito);
    }
    
    
}

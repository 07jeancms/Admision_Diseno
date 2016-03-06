/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;
import java.util.Random;
import modelo.Resultado;
import negocio.GestorBoletas;
import vista.General;

/**
 *
 * @author JeanCarlo
 */
public class Admision {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        GestorBoletas gb = new GestorBoletas();
        //gb.crearBoletas(5);
        General guiGeneral= new General();
        guiGeneral.setLocationRelativeTo(null);
        guiGeneral.setVisible(true);
  
    }
    
}

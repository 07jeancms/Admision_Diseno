/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;
import javax.swing.JFrame;
import negocio.GestorBoletas.*;
import vista.GenerarBoletas;
import vista.ActualizarNota;
import vista.ListaGeneral;
import vista.Estadisticas;
/**
 *
 * @author Felipe Mora
 */
public class AdministradorInt {
    GestorBoletas gestor;


    public AdministradorInt() {
        this.gestor = new GestorBoletas();
    }
    
    public int generarEstudiantes(GenerarBoletas boleta)
    {
        GenerarBoletas boletas = boleta;
        int bol = Integer.parseInt(boletas.getTxt_Generar().getText());
        gestor.crearBoletas(bol);
        gestor.construirReporteConTresMejoresPromedios();
        return 0;
    }
    
    public String actualizarNota(ActualizarNota actN)
    {
        String text = actN.getTxt_NotaBol().getText();
        float calificacion = Float.parseFloat(text);
        int numBol = Integer.parseInt(actN.getTxt_NumBol().getText());
        return gestor.actualizarCalificacion(calificacion, numBol);
    }
    
    public int obtenerBoletas(ListaGeneral list)
    {
        list.setTxt_BolSist(String.valueOf(gestor.getBoletas().size()));
        list.setTxt_Boletas(gestor.getBoletas().toString());        
        return 0;
    }
    
    public void ordenarAlfab(ListaGeneral list)
    {
        list.setTxt_BolSist(String.valueOf(gestor.getBoletas().size()));
        gestor.ordenarPorAlfabeto();
        list.setTxt_Boletas(gestor.getBoletas().toString());   
    }
    
    public void rankingAdmitidos(ListaGeneral list)
    {
        list.setTxt_BolSist(String.valueOf(gestor.getBoletas().size()));
        
        list.setTxt_Boletas(gestor.rankingAdmitidos());
    }
    
    public void obtenerTresMej(ListaGeneral list)
    {
        list.setTxt_Boletas(gestor.construirReporteConTresMejoresPromedios());
    }
    
    public void obtenerElegibles_Rechazados(ListaGeneral list)
    {
        list.setTxt_Boletas(gestor.filtrarPorResultado());
    }
    
    public int estadisticas(Estadisticas stats)
    {
        stats.setTxt_Recibidas(String.valueOf(gestor.getBoletas().size()));
        stats.setTxt_Aceptados(String.valueOf(gestor.getContadorAprobados()));
        stats.setTxt_Elegibles(String.valueOf(gestor.getContadorElegibles()));
        stats.setTxt_Rechazados(String.valueOf(gestor.getContadorRechazados()));
        return 0;
    }
    
}

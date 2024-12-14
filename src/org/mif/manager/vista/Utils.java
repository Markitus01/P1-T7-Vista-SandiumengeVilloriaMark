/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.mif.manager.vista;

import java.util.List;
import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.logging.Level;
import org.mif.manager.interficiepersistencia.IGestorBDManager;
import org.mif.manager.interficiepersistencia.GestorBDManagerException;
import org.mif.manager.model.Categoria;
import org.mif.manager.model.Temporada;

/**
 * Classe Utils per a que els JFrames facin ús de funcions/variables/constants
 * https://stackoverflow.com/questions/10425962/java-access-main-class-variables
 * @author marks
 */
public class Utils
{
    public static IGestorBDManager gBD = null;
    private static List<Temporada> temporades = new ArrayList<>();
    private static Temporada tempAct = null;
    private static List<Categoria> categories = new ArrayList<>();
    
    private Utils(){}
    
    public static IGestorBDManager getGBD()
    {
        return gBD;
    }
    
    public static List<Temporada> getTemporades()
    {
        return temporades;
    }
    
    public static Temporada getTemporadaActual()
    {
        return tempAct;
    }
    
    public static List<Categoria> getCategories()
    {
        return categories;
    }
    
    public static void setGBD(String nomClassePersist)
    {
        try
        {
            gBD = (IGestorBDManager) Class.forName(nomClassePersist).newInstance();
        } 
        catch (Exception ex)
        {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void setTemporades()
    {
        try
        {
            gBD.obtenirTemporades();
        }
        catch (GestorBDManagerException ex)
        {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

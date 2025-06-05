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
import org.mif.manager.model.Equip;
import org.mif.manager.model.Jugador;
import org.mif.manager.model.Membre;
import org.mif.manager.model.Temporada;

/**
 * Classe Utils per a que els JFrames facin ús de certes funcions/variables/constants
 * https://stackoverflow.com/questions/10425962/java-access-main-class-variables
 * @author marks
 */
public class Utils
{
    private static IGestorBDManager gBD = null;
    private static List<Temporada> temporades = new ArrayList();
    private static Temporada tempAct = null;
    private static List<Categoria> categories = new ArrayList();
    private static List<Equip> equips = new ArrayList();
    private static Equip equipActual = new Equip();
    private static List<Jugador> jugadors = new ArrayList();
    private static List<Membre> membres = new ArrayList();
    private static List<Jugador> jugsDinsEquip = new ArrayList();
    private static List<Jugador> jugsForaEquip = new ArrayList();
    
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
    
    public static List<Equip> getEquips()
    {
        return equips;
    }
    
    public static Equip getEquipActual()
    {
        return equipActual;
    }
    
    public static List<Jugador> getJugadors()
    {
        return jugadors;
    }
    
    public static List<Jugador> getJugadorsDinsEquip()
    {
        return jugsDinsEquip;
    }
    
    public static List<Jugador> getJugadorsInscriptiblesEquip()
    {
        return jugsForaEquip;
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
            temporades = gBD.obtenirTemporades();
        }
        catch (GestorBDManagerException ex)
        {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void setTemporadaActual(Temporada t)
    {
        tempAct = t;
    }
    
    public static void setEquips(Temporada t)
    {    
        try
        {
            equips = gBD.obtenirEquips(tempAct);
        }
        catch (GestorBDManagerException ex)
        {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void setEquipActual(Equip e)
    {
        if (e != null)
        {
            equipActual = e;
        }
        else 
        {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, "L'equip actual no s'ha pogut assignar correctament!");
        }
    }
    
    public static void setJugadors()
    {
        try 
        {
            jugadors = gBD.obtenirJugadors();
        }
        catch (GestorBDManagerException ex)
        {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void setMembres()
    {
        try 
        {
            membres = gBD.obtenirMembres();
        }
        catch (GestorBDManagerException ex)
        {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void setJugsDinsEquip(int eqId)
    {
        try 
        {
            jugsDinsEquip = gBD.obtenirJugadorsEquip(eqId);
        }
        catch (GestorBDManagerException ex)
        {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void setJugsInscriptiblesEquip(int eqId)
    {
        try 
        {
            jugsForaEquip = gBD.obtenirJugadorsEquipInscriptibles(eqId);
        }
        catch (GestorBDManagerException ex)
        {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void setCategories()
    {
        try 
        {
            categories = gBD.obtenirCategories();
        }
        catch (GestorBDManagerException ex)
        {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

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
    
    public static List<Membre> getMembres()
    {
        return membres;
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
            membres = gBD.obtenirMembres(tempAct);
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
    
    
    /**
     * Crea una nova temporada
     * 
     * @param any any de la nova temporada a crear
     * @return 
     */
    public static String crearNovaTemporada(String any)
    {
        try
        {
            int afegit = gBD.crearTemporada(any);
            if (afegit > 0) 
            {
                setTemporades(); // Actualitza la llista
                return null; // Tot correcte, sense error
            } 
            else 
            {
                return "No s'ha pogut afegir la temporada (potser ja existeix?)";
            }
        } 
        catch (GestorBDManagerException ex) 
        {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            return ex.getMessage();
        }
    }
    
    /**
     * Retorna el jugador pel seu idLegal, o null si hi ha error.
     * @param idLegal identificador legal del jugador
     * @return Jugador trobat o null si error
    */
    public static Jugador obtenirJugadorPerIdLegal(String idLegal)
    {
       try
       {
           return gBD.obtenirJugador(idLegal);
       }
       catch (GestorBDManagerException ex)
       {
           Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
           return null;
       }
    }
   
    public static Integer obtenirEquipOnEsTitular(int idJugador)
    {
        try
        {
            return gBD.obtenirEquipOnEsTitular(idJugador);
        }
        catch (GestorBDManagerException ex)
        {
            javax.swing.JOptionPane.showMessageDialog(null, ex.getMessage(), "Error al comprovar titularitat", javax.swing.JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    public static String afegirMembreEquip(Membre membre, int equipId)
    {
        try
        {
            getGBD().afegirMembre(membre);
            setJugsDinsEquip(equipId);
            setJugsInscriptiblesEquip(equipId);
            return null; // èxit
        }
        catch (GestorBDManagerException ex)
        {
            return ex.getMessage(); // retorna l'error
        }
    }
    
    public static String eliminarMembreEquip(Membre membre, int equipId)
    {
        try
        {
            getGBD().eliminarMembre(membre);
            setJugsDinsEquip(equipId);
            setJugsInscriptiblesEquip(equipId);
            return null;
        }
        catch (GestorBDManagerException ex)
        {
            return ex.getMessage();
        }
    }

    /**
     * Retorna si un jugador es titular o no
     * @param equipId equip al que l'hem de buscar
     * @param jugadorId jugador a buscar
     * @return retorna si es titular o no
     */
    public static boolean esTitular(int equipId, int jugadorId)
    {
        try
        {
            return getGBD().esTitular(equipId, jugadorId);
        }
        catch (GestorBDManagerException ex)
        {
            java.util.logging.Logger.getLogger(Utils.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            return false;
        }
    }


    public static boolean modificarTitularitatMembre(Membre membre, boolean titularNou)
    {
        try
        {
            gBD.modificarMembre(membre, titularNou);
            return true;
        }
        catch (GestorBDManagerException ex)
        {
            javax.swing.JOptionPane.showMessageDialog(null, ex.getMessage(), "Error canviant titularitat", javax.swing.JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    /**
     * Afegeix o guarda un jugador a la bd
     * @param jug jugador a inserir o editar
     * @param esNou booleà indicant si es nou o no
     * @return null si tot va bé o msg d'error
     */
    public static String guardarJugador(Jugador jug, boolean esNou)
    {
        try
        {
            if (esNou)
            {
                gBD.afegirJugador(jug);
            }
            else
            {
                gBD.modificarJugador(jug);
            }
            setJugadors();
            return null;
        }
        catch (GestorBDManagerException ex)
        {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            return ex.getMessage();
        }
    }
    
    /**
    * Intenta eliminar un jugador si no està assignat a cap equip.
    * @param idLegal Identificador legal del jugador (NIF/NIE)
    * @return null si tot correcte, o missatge d'error si no s'ha pogut eliminar
    */
    public static String eliminarJugadorSiNoAssignat(String idLegal)
    {
        try
        {
            Jugador jug = getGBD().obtenirJugador(idLegal);

            // Comprova si el jugador és membre d'algun equip
            for (Temporada temp : getTemporades())
            {
                List<Membre> membresTemp = getGBD().obtenirMembres(temp);
                for (Membre m : membresTemp)
                {
                    if (m.getJugMembre() == jug.getId())
                    {
                        return "No pots eliminar aquest jugador perquè està assignat a un equip!";
                    }
                }
            }

            int eliminat = getGBD().eliminarJugador(jug);
            if (eliminat == 1)
            {
                return null; // Eliminació correcta
            }
            else
            {
                return "No s'ha pogut eliminar el jugador.";
            }
        }
        catch (GestorBDManagerException ex)
        {
            return "Error intern: " + ex.getMessage();
        }
    }

    
    public static Equip obtenirEquipPerId(int id)
    {
        try
        {
            return getGBD().obtenirEquip(id);
        }
        catch (Exception ex) 
        {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    /**
     * Eliminem un equip complet
     * @param equipId id de l'equip a eliminar
     * @return null si tot va bé, o el missatge d'error corresponent
     */
    public static String eliminarEquipComplet(int equipId)
    {
        try
        {
            // Elimina tots els membres associats a l'equip
            getGBD().eliminarMembresEquip(equipId);

            // Recupera l'objecte equip per eliminar-lo després
            Equip e = getGBD().obtenirEquip(equipId);
            int eliminat = getGBD().eliminarEquip(e);

            if (eliminat == 1)
            {
                setEquips(getTemporadaActual());
                return null; // èxit
            }
            else
            {
                return "No s'ha pogut eliminar l'equip.";
            }
        }
        catch (GestorBDManagerException ex)
        {
            return "Error intern: " + ex.getMessage();
        }
    }

    /**
     * 
     * @return 
     */
    public static List<String> obtenirNomsCategories() {
        List<String> noms = new ArrayList<>();
        noms.add("Totes");
        try {
            for (Categoria c : getGBD().obtenirCategories()) {
                noms.add(c.getNom());
            }
        }
        catch (GestorBDManagerException ex)
        {
            // Si hi ha un error ens petem la llista de categories i posem un error
            noms.clear();
            noms.add("Error carregant categories");
        }
        return noms;
    }


    /**
     * Fa commit a la BD
     * @return null si tot va bé o msg d'error
     */
    public static String confirmarCanvis()
    {
        try
        {
            getGBD().confirmarCanvis();
            return null;
        }
        catch (GestorBDManagerException ex)
        {
            return ex.getMessage();
        }
    }
}

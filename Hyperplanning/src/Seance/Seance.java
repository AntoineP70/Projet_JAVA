/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Seance;

import Data.*;
import User.Professeur;
import User.User;

/**
 *
 * @author Antoine
 */
public class Seance  {
    private int m_ID;
    private String m_nom;
    private String m_type;
    private Creneau m_creneau;
    private boolean m_etat;
    private Salle m_salle;
    private Professeur m_prof;
    private Groupes m_classe;
    
    
    public Seance(int id,String nom,String type,Creneau cr, boolean etat,Salle salle,User prof,Groupes classe)
    {
   
        m_ID = id;
        m_nom = nom;
        m_type = type;
        m_creneau = cr;
        m_etat = etat;
        m_salle = salle;
        m_prof = (Professeur) prof;
        m_classe = classe;
    }
     
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Seance;

import Data.*;
import User.Professeur;

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
    
    
    public Seance(int id,String nom,String type,int semaine,int date, int heureD,int heureF, boolean etat,Salle salle,Professeur prof,Groupes classe)
    {
        Creneau cr = new Creneau(semaine,date,heureD,heureF);
        m_ID = id;
        m_nom = nom;
        m_type = type;
        m_creneau = cr;
        m_etat = etat;
        m_salle = salle;
        m_prof = prof;
        m_classe = classe;
    }
     
    
    
}

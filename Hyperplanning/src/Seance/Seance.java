/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Seance;

import Data.*;
import User.Professeur;
import User.User;
import java.util.Date;

/**
 *
 * @author Antoine
 */
public class Seance  {
    private int m_ID;
    private String m_nom;
    private String m_type;
    private Date m_debut;
    private Date m_fin;
    private boolean m_etat;
    private Salle m_salle;
    private Professeur m_prof;
    private Groupes m_classe;
    
    
    public Seance(int id,String nom,String type,Date debut,Date fin, boolean etat,Salle salle,Professeur prof,Groupes classe)
    {
   
        m_ID = id;
        m_nom = nom;
        m_type = type;
        m_debut = debut;
        m_fin = fin;
        m_etat = etat;
        m_salle = salle;
        m_prof = prof;
        m_classe = classe;
    }
    
    public String getNom()
    {
        return m_nom;
    }
     
    
    
}

package Seance;

import Data.*;
import User.Professeur;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Antoine
 */
public class Seance  {
    private int m_ID;
    private String m_nom = "";
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
    
    public Date getDebut()
    {
        return m_debut;
    }
    
    public ArrayList<String> show() //return toutes les infos relatives à la séance pour affichage dans EDT
    {
        ArrayList<String> aff = new ArrayList<> ();
        aff.add(m_nom);
        aff.add(m_type);
        aff.add(m_prof.getNom());
        aff.add(m_classe.getNom());
        aff.add(m_salle.getNom());
        aff.add(m_salle.m_site.getNom());
        return aff;   
    }
     
    
    
}

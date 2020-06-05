/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;

import Seance.Seance;
import java.util.ArrayList;

/**
 *
 * @author Antoine
 */
public class Professeur extends User{
    private ArrayList<Seance> m_cours;

    public Professeur(int id, String email, String mdp, String nom, String prenom, boolean droit, ArrayList<Seance> cours) {
        super(id, email, mdp, nom, prenom, droit);
        m_cours = cours;
    }
    
    public ArrayList<Seance> getCours()
    {
        return m_cours;
    }
}

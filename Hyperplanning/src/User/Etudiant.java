/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;

import Data.Groupes;

/**
 *
 * @author Antoine
 */
public class Etudiant extends User{
    private int m_num;
    private Groupes m_group;

    public Etudiant(int id, String email, String mdp, String nom, String prenom, boolean droit,int num, Groupes classe) {
        super(id, email, mdp, nom, prenom, droit);
        m_group = classe;
        m_num = num;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;

/**
 *
 * @author Antoine
 */
public class User {
    private int m_ID;
    private String m_email;
    private String m_password;
    private String m_nom;
    private String m_prenom;
    private boolean m_droit;
    
    public User(int id,String email,String mdp,String nom,String prenom,boolean droit)
    {
        m_ID = id;
        m_email = email;
        m_password = mdp;
        m_nom = nom;
        m_prenom = prenom;
        m_droit = droit;
    }
}

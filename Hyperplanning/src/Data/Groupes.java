package Data;

import User.Etudiant;
import java.util.*;

/**
 *
 * @author Antoine
 */
public class Groupes{
    private ArrayList<Etudiant> m_etudiants;
    private int m_ID;
    private String m_nom;
    private Promotions m_promo;
    
    public Groupes(int id,String nom, Promotions promo)
    {
        m_ID = id;
        m_nom = nom;
        m_promo = promo;
    }
    
    public String getNom()
    {
        return m_nom;
    }
}

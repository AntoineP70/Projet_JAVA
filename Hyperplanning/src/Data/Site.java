package Data;

import java.util.*;

/**
 *
 * @author Antoine
 */
public class Site {
    private int m_ID;
    private String m_nom;
    private ArrayList<Salle> m_salles;

    public Site(int ID, String nom) {
        m_ID= ID;
        m_nom= nom;
    }
    
    public String getNom()
    {
        return m_nom;
    }
}

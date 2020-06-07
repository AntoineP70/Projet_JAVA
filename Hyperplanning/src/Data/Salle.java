package Data;

/**
 *
 * @author Antoine
 */
public class Salle {
    private int m_ID;
    private String m_nom;
    private int m_capacité;
    public Site m_site;
    
    public Salle(int ID,String nom,int cap,Site site)
    {
        m_ID =ID;
        m_nom =nom;
        m_capacité = cap;
        m_site = site;
    }
    
    public String getNom()
    {
        return m_nom;
    }
}

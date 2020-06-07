package User;

import Seance.Seance;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

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
    private int m_droit;
    
    
    
    public User(int id,String email,String mdp,String nom,String prenom,int droit)
    {
        m_ID = id;
        m_email = email;
        m_password = mdp;
        m_nom = nom;
        m_prenom = prenom;
        m_droit = droit;
    }
    
    public int getId()
    {
        return m_ID;
    }
    
    public String getNom()
    {
        return m_nom;
    }
    
    public int getDroit()
    {
        return m_droit;
    }
    
    public ArrayList<Seance> getEDT() throws SQLException, ParseException //récupération emploi du temps 
    {
        UserImp userImp = new UserImp();
        ArrayList<Seance> edt = userImp.getEDT(m_ID);
        return edt;
    }
            
        
}

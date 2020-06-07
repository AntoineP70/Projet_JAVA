package User;

import Seance.Seance;
import java.util.ArrayList;

/**
 *
 * @author Antoine
 */
public class Professeur extends User{
    private ArrayList<Seance> m_cours;

    public Professeur(int id, String email, String mdp, String nom, String prenom, int droit) {
        super(id, email, mdp, nom, prenom, droit);
    }
    
    public ArrayList<Seance> getCours()
    {
        return m_cours;
    }
}

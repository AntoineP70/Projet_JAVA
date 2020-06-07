package User;

import Data.Groupes;

/**
 *
 * @author Antoine
 */
public class Etudiant extends User{
    public int m_num;
    private Groupes m_group;

    public Etudiant(int id, String email, String mdp, String nom, String prenom, int droit,int num, Groupes classe) {
        super(id, email, mdp, nom, prenom, droit);
        m_group = classe;
        m_num = num;
    }
    
    public int getNum()
    {
        return m_num;
    }
}

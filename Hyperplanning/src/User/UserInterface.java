package User;

import Seance.Seance;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

/**
 *
 * @author Antoine
 */
public interface UserInterface {
    public void ajouter(Etudiant e);//ajouter à BDD un etudiant     --Pas implémenté--
    public void ajouter(Professeur p);//ajouter à BDD un professeur --Pas implémenté--
    public void modifier(Etudiant e);//modifié un étudiant          --Pas implémenté--
    public void modifier(Professeur p);//modifié un professeur      --Pas implémenté--
    public ArrayList<Seance> getEDT(int ID_user)throws SQLException, ParseException; //Return l'emploi du temps d'un utilisateur
}

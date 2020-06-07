package hyperplanning;

import Seance.Seance;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

/**
 *
 * @author Antoine
 */
public class Hyperplanning {
   // private static View.LogIn Loged;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ParseException {
        // TODO code application logic here
        View.LogIn Loged = null; 
        Loged = new  View.LogIn(); // récupération des informations de l'utilisateur

        while(Loged.user==null) //boucle d'attente rentrée email et password
        {
            Loged.setVisible(true);   
        }

        ArrayList<Seance> edt = null;
        edt = Loged.user.getEDT(); // récupération de l'emploi du temps lié à l'utilisateur
        View.Window EDT = new View.Window(edt,Loged.user);   //affichage EDT
    } 
}

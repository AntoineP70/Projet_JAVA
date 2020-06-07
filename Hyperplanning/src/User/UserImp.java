/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;

import Data.Groupes;
import Data.Promotions;
import Data.Salle;
import Data.Site;
import Seance.Seance;
import hyperplanning.JDBC;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Antoine
 */
public class UserImp implements UserInterface {
    
    @Override
    public void ajouter(Etudiant e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ajouter(Professeur p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modifier(Etudiant e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modifier(Professeur p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public ArrayList<Seance> getEDT(int ID_user) throws SQLException, ParseException
    {

        ArrayList<String> results;
        results = new ArrayList<> ();
        JDBC maconnexion = null;
        User tmp = null;
        
        ArrayList<Seance> edt = new ArrayList<>();
        
        try {
            maconnexion = new JDBC("projet_java","root","");
            results = maconnexion.QueryList("Select * from utilisateur where ID = '"+ID_user+"'");
        } catch (SQLException ex) {
          //  Logger.getLogger(LogIn.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
         //   Logger.getLogger(LogIn.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //tmp = new User(Integer.parseInt(results.get(0)),results.get(1),results.get(2),results.get(3),results.get(4),Integer.parseInt(results.get(5)));
        tmp = new User(Integer.parseInt(results.get(0)),results.get(1),results.get(2),results.get(3),results.get(4),Integer.parseInt(results.get(5)));

        
        if(tmp.getDroit()==1)//élève
        {
            //ArrayList<String> res_user=null;
            results = maconnexion.QueryList("Select * from etudiant where ID_utilisateur = "+tmp.getId()+"");

            results= maconnexion.QueryList("Select ID_Seance from seance_groupes where ID_Groupe = '"+results.get(2)+"'");
            
            ArrayList<String> seance = null;
            
            for(int i=0;i<results.size();i++)
            {
                            
                seance= maconnexion.QueryList("SELECT * from seance where ID = '"+results.get(i)+"'");

                ArrayList<String> nom = maconnexion.QueryList("SELECT nom from cours where ID = '"+seance.get(6)+"' ");
                ArrayList<String> type = maconnexion.QueryList("SELECT nom from type_cours where ID = '"+seance.get(7)+"' ");

                DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
                Date debut = null, fin = null;

                debut = sdf.parse(seance.get(2) +"-"+ seance.get(3));                         
                fin = sdf.parse(seance.get(2) +"-"+ seance.get(4));

                ArrayList<String> sa = maconnexion.QueryList("SELECT ID_Salle from seance_salles where ID_Seance = '"+seance.get(0)+"'");
                sa = maconnexion.QueryList("SELECT * from salle where ID like '"+sa.get(0)+"'");
                ArrayList<String> si = maconnexion.QueryList("Select * from site where ID like '"+sa.get(3)+"'");

                Site site = new Site(Integer.parseInt(si.get(0)),si.get(1));
                Salle salle = new Salle(Integer.parseInt(sa.get(0)),sa.get(1),Integer.parseInt(sa.get(2)),site);

                ArrayList<String> pro = maconnexion.QueryList("SELECT ID_Enseignant from seance_enseignants where ID_Seance = '"+seance.get(0)+"'");
                pro = maconnexion.QueryList("SELECT * from utilisateur where ID = '"+pro.get(0)+"'");

                Professeur professeur = new Professeur(Integer.parseInt(pro.get(0)),pro.get(1),pro.get(2),pro.get(3),pro.get(4),Integer.parseInt(pro.get(5)));


                ArrayList<String> gp = maconnexion.QueryList("SELECT ID_Groupe from seance_groupes where ID_Seance = '"+seance.get(0)+"'");
                gp = maconnexion.QueryList("SELECT * from groupe where ID = '"+gp.get(0)+"'");
                ArrayList<String> prom = maconnexion.QueryList("SELECT * from promotion where ID = '"+gp.get(2)+"'");
                Promotions promo = new Promotions(Integer.parseInt(prom.get(0)),prom.get(1));
                Groupes classe= new Groupes(Integer.parseInt(gp.get(0)),gp.get(1),promo);


                Seance cours;        
                
                
                cours = new Seance(Integer.parseInt(seance.get(0)),nom.get(0),type.get(0),debut,fin,Boolean.parseBoolean(seance.get(5)),salle,professeur,classe);

                System.out.println("*****************************************");
                
                cours.show();


                edt.add(cours);
            }
        }
        if(tmp.getDroit()==2)//prof
        {
            //ArrayList<String> res_user=null;
            results = maconnexion.QueryList("Select ID_Seance from seance_enseignants where ID_Enseignant = "+tmp.getId()+"");

            
            
            ArrayList<String> seance = null;
            
            for(int i=0;i<results.size();i++)
            {
                            
                seance= maconnexion.QueryList("SELECT * from seance where ID = '"+results.get(i)+"'");

                ArrayList<String> nom = maconnexion.QueryList("SELECT nom from cours where ID = '"+seance.get(6)+"' ");
                ArrayList<String> type = maconnexion.QueryList("SELECT nom from type_cours where ID = '"+seance.get(7)+"' ");

                DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
                Date debut = null, fin = null;

                debut = sdf.parse(seance.get(2) +"-"+ seance.get(3));                         
                fin = sdf.parse(seance.get(2) +"-"+ seance.get(4));

                ArrayList<String> sa = maconnexion.QueryList("SELECT ID_Salle from seance_salles where ID_Seance = '"+seance.get(0)+"'");
                sa = maconnexion.QueryList("SELECT * from salle where ID like '"+sa.get(0)+"'");
                ArrayList<String> si = maconnexion.QueryList("Select * from site where ID like '"+sa.get(3)+"'");

                Site site = new Site(Integer.parseInt(si.get(0)),si.get(1));
                Salle salle = new Salle(Integer.parseInt(sa.get(0)),sa.get(1),Integer.parseInt(sa.get(2)),site);

                ArrayList<String> pro = maconnexion.QueryList("SELECT ID_Enseignant from seance_enseignants where ID_Seance = '"+seance.get(0)+"'");
                pro = maconnexion.QueryList("SELECT * from utilisateur where ID = '"+pro.get(0)+"'");

                Professeur professeur = new Professeur(Integer.parseInt(pro.get(0)),pro.get(1),pro.get(2),pro.get(3),pro.get(4),Integer.parseInt(pro.get(5)));


                ArrayList<String> gp = maconnexion.QueryList("SELECT ID_Groupe from seance_groupes where ID_Seance = '"+seance.get(0)+"'");
                gp = maconnexion.QueryList("SELECT * from groupe where ID = '"+gp.get(0)+"'");
                ArrayList<String> prom = maconnexion.QueryList("SELECT * from promotion where ID = '"+gp.get(2)+"'");
                Promotions promo = new Promotions(Integer.parseInt(prom.get(0)),prom.get(1));
                Groupes classe= new Groupes(Integer.parseInt(gp.get(0)),gp.get(1),promo);


                Seance cours;        
                
                
                cours = new Seance(Integer.parseInt(seance.get(0)),nom.get(0),type.get(0),debut,fin,Boolean.parseBoolean(seance.get(5)),salle,professeur,classe);

                System.out.println("*****************************************");
                
                cours.show();


                edt.add(cours);
            }
        }
        
        return edt;
    }
}

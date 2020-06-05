/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Data.Groupes;
import Data.Promotions;
import Data.Salle;
import Data.Site;
import Seance.Seance;
import User.Etudiant;
import User.Professeur;
import User.User;
import hyperplanning.JDBC;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.*;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.*;

/**
 *
 * @author Antoine
 */
public class LogIn extends JFrame /*implements ActionListener*/{
  JButton btn = new JButton("Continue");
  private KeyListener k1, k2;
  private JTextField jTextField1,jTextField2;
  private JLabel lbl;
  
  String str = "";
  public Etudiant userE = null;
  public Professeur userP =null ;

  
  public LogIn()
  {
    setTitle("Log in");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocation(200,100);
    setSize(500,500);
    
    Container frame = getContentPane();
    
    JPanel jp = new JPanel();
    jp.setLayout(null);
    
    initListener();
    
    jTextField1 = new JTextField("testProf");
    jTextField1.addKeyListener(k1);
    jTextField1.setBounds(10, 10, 100, 20);
    
    
    jTextField2 = new JTextField("testProf");
    jTextField2.addKeyListener(k2);
    jTextField2.setBounds(10, 35, 100, 20);
    
    
    btn.setBounds(50, 100, 100, 20);
    btn.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae)
        {

          ArrayList<String> results;
          results = new ArrayList<> ();
          JDBC maconnexion = null;
          try {
              maconnexion = new JDBC("projet_java","root","");
              results = maconnexion.QueryList("Select * from utilisateur where Email = '"+jTextField1.getText()+"' and Passwd = '"+jTextField2.getText()+"'");
          } catch (SQLException ex) {
            //  Logger.getLogger(LogIn.class.getName()).log(Level.SEVERE, null, ex);
          } catch (ClassNotFoundException ex) {
           //   Logger.getLogger(LogIn.class.getName()).log(Level.SEVERE, null, ex);
          }
         // System.out.println("Select * from utilisateur where ID = 3");// Email like "+jTextField1.getText()+" and Passwd like "+jTextField2.getText()+"");   
         /* for(int i=0;i<results.size();i++)
          {
              System.out.println(results.get(i));
          }
            */
          if (results.size() != 0)
          {

              if (Integer.parseInt(results.get(5)) == 1) //student
              {

                  ArrayList<String> res_student = null;
                  ArrayList<String> res_gp = null;
                  try {
                      res_student = maconnexion.QueryList("SELECT * from etudiant where ID_Utilisateur = '"+results.get(0)+"'");

                      res_gp = maconnexion.QueryList("SELECT * from groupe where ID = '"+res_student.get(2)+"'");
                  } catch (SQLException ex) {
                      Logger.getLogger(LogIn.class.getName()).log(Level.SEVERE, null, ex);
                  }

                  Groupes classe;
                  classe = new Groupes(Integer.parseInt(res_gp.get(0)),res_gp.get(1));
                  //user = new User(1,"a","b","c","d",true);
                  //user = new User(Integer.parseInt(results.get(0)),results.get(1),results.get(2),results.get(3),results.get(4),Boolean.parseBoolean(results.get(5)));
                  userE = new Etudiant(Integer.parseInt(results.get(0)),results.get(1),results.get(2),results.get(3),results.get(4),Boolean.parseBoolean(results.get(5)),Integer.parseInt(res_student.get(1)),classe);
                  
                  /*
                  
                  new EDTWindow().setVisible(true);
                  System.out.println("e" + str);
                  this.dispose();

                  */
              }
              else if (Integer.parseInt(results.get(5)) == 2) //prof
              {



                  ArrayList<String> res_IDprof = null;
                  ArrayList<String> res_IDcours = null;
                  try {
                      res_IDcours = maconnexion.QueryList("Select ID_Cours from enseignant where ID_Utilisateur = '"+results.get(0)+"'");
                  } catch (SQLException ex) {
                      Logger.getLogger(LogIn.class.getName()).log(Level.SEVERE, null, ex);
                  }
                  
                  ArrayList<Seance> res_cours = null;
                  

/*for(int i=0;i<res_prof.size();i++)
{
  System.out.println(res_prof.get(i));
}*/

      /*            for(int i=1;i<res_prof.size();i+=3)
                  {
                      res_IDcours.add(res_prof.get(i));
                  }
*/
      System.out.println(res_IDcours.size());
                  for(int j=0;j<res_IDcours.size();j++)
                  {
                    ArrayList<String> res_Infocours = null;
                    ArrayList<String> res_Salle= null,ID_Salle = null;
                    ArrayList<String> res_Site = null;
                    ArrayList<String> Nom_cours = null;                 
                    ArrayList<String> Type_cours = null;
                    ArrayList<String> ID_Classe = null;
                    ArrayList<String> res_Classe = null;
                    ArrayList<String> res_Promo = null;
                      System.out.println("success");
                      try {
                          
                          res_Infocours = maconnexion.QueryList("SELECT * from seance where ID = '"+res_IDcours.get(j)+"'");

                          Nom_cours = maconnexion.QueryList("SELECT nom from cours where ID = '"+res_Infocours.get(6)+"'");
                         
                          Type_cours = maconnexion.QueryList("SELECT nom from type_cours where ID = '"+res_Infocours.get(7)+"'");
                          ID_Salle = maconnexion.QueryList("Select ID_Salle from seance_salles where ID_Seance = '"+res_Infocours.get(0)+"'");
                          res_Salle = maconnexion.QueryList("SELECT * from salle where ID = '"+ID_Salle.get(0)+"'");
                       
                          res_Site = maconnexion.QueryList("Select * from site where ID = '"+res_Salle.get(3)+"'");
                        
                          ID_Classe = maconnexion.QueryList("SELECT ID_Groupe from seance_groupes where ID_Seance= '"+res_Infocours.get(0)+"'");
   
                          res_Classe = maconnexion.QueryList("Select * from groupe where ID = '"+ID_Classe.get(0)+"'");
                         
                          res_Promo = maconnexion.QueryList("Select * from promotion where ID = '"+res_Classe.get(2)+"'");


                      } catch (SQLException ex) {
                          System.out.println("echec");
                          Logger.getLogger(LogIn.class.getName()).log(Level.SEVERE, null, ex);
                      }
                      Site si = new Site(Integer.parseInt(res_Site.get(0)),res_Site.get(1));
                      Salle sa = new Salle(Integer.parseInt(res_Salle.get(0)),res_Salle.get(1),Integer.parseInt(res_Salle.get(2)),si);
                        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
                        Date debut = null, fin = null;
                      try {
                          
                            debut = sdf.parse(res_Infocours.get(2) +"-"+ res_Infocours.get(3));                         
                            fin = sdf.parse(res_Infocours.get(2) +"-"+ res_Infocours.get(4));

                      } catch (ParseException ex) {
                          Logger.getLogger(LogIn.class.getName()).log(Level.SEVERE, null, ex);
                      }

                      Promotions promo = new Promotions(Integer.parseInt(res_Promo.get(0)),res_Promo.get(1));
                      Groupes classe = new Groupes(Integer.parseInt(res_Classe.get(0)),res_Classe.get(1));
                     /*              
System.out.println("TEST");
System.out.println(res_Infocours.get(0));
System.out.println(Nom_cours.get(0));
System.out.println(Type_cours.get(0));
System.out.println(debut);
System.out.println(fin);
System.out.println(res_Infocours.get(5));
System.out.println(sa.getNom());
System.out.println(classe.getNom());

*/

                    Seance se = new  Seance(Integer.parseInt(res_Infocours.get(0)),Nom_cours.get(0),Type_cours.get(0),debut,fin,Boolean.parseBoolean(res_Infocours.get(5)),sa,userP,classe);

                    res_cours.add(se);
                  }   

                  userP = new Professeur(Integer.parseInt(results.get(0)),results.get(1),results.get(2),results.get(3),results.get(4),Boolean.parseBoolean(results.get(5)),res_cours);

ArrayList<Seance> cours = userP.getCours();




                  //new EDTWindow().setVisible(true);
                  //this.dispose();
              }
              else if (results.get(5) == "3")
              {
                  //new AdminWindow().setVisible(true);
                  //this.dispose();
              }
          }
          else
          {
              System.out.println("ERROR CONNEXION");
          }
        }
    });
    
    
    jp.add(jTextField1);
    jp.add(jTextField2);
    jp.add(btn);
    
    frame.add(jp);
  }

  
  
  public void initListener()
  {
      k1 = new KeyListener()
      {
          public void keyPressed(KeyEvent e)
          {
              str += e.getKeyChar();
          }
          public void keyReleased(KeyEvent e){}
          public void keyTyped(KeyEvent e){}
          
      };
      k2 = new KeyListener()
      {
          public void keyPressed(KeyEvent e)
          {
              str += e.getKeyChar();
          }
          public void keyReleased(KeyEvent e){}
          public void keyTyped(KeyEvent e){}
          
      };
      
  }
}

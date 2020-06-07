package View;

import User.User;
import hyperplanning.JDBC;
import java.awt.Container;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.*;

/**
 *
 * @author Antoine
 */
public class LogIn extends JFrame{
  JButton btn = new JButton("Continue");
  private KeyListener k1, k2;
  private JTextField jTextField1,jTextField2;
  
  String str = "";
  
  public User user = null;

  
  public LogIn()//Connexion
  {
        setTitle("Log in");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(200,100);
        setSize(500,500);

        Container frame = getContentPane();

        JPanel jp = new JPanel();
        jp.setLayout(null);

        initListener();
JLabel leg1 = new JLabel("Email :");
        jTextField1 = new JTextField("");//Email

        jTextField1.addKeyListener(k1);
        jTextField1.setBounds(10, 10, 100, 20);

JLabel leg2 = new JLabel("Mot de passe :");
        jTextField2 = new JTextField("");//mot de passe
        jTextField2.addKeyListener(k2);
        jTextField2.setBounds(10, 35, 100, 20);


        btn.setBounds(50, 100, 100, 20);
        btn.addActionListener(new ActionListener(){
        @Override
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

            if (results.size() != 0)
            {
                System.out.println("TEST");
                for(int i=0;i<results.size();i++)
                {
                    System.out.println(results.get(i));
                }                  
                user = new User(Integer.parseInt(results.get(0)),results.get(1),results.get(2),results.get(3),results.get(4),Integer.parseInt(results.get(5)));     
            }
            else
            {
                System.out.println("ERROR CONNEXION");
            }
        }
    });
    jp.add(jTextField1);
    jp.add(leg1);
    jp.add(leg2);
    jp.add(jTextField2);
    jp.add(btn);
    
    frame.add(jp);
  }

  
  
  public void initListener() //initialisation des Listener sur prise Text
  {
      k1 = new KeyListener()//Email
      {
          @Override
          public void keyPressed(KeyEvent e)
          {
              str += e.getKeyChar();
          }
          @Override
          public void keyReleased(KeyEvent e){}
          @Override
          public void keyTyped(KeyEvent e){}
          
      };
      k2 = new KeyListener()//Password
      {
          @Override
          public void keyPressed(KeyEvent e)
          {
              str += e.getKeyChar();
          }
          @Override
          public void keyReleased(KeyEvent e){}
          @Override
          public void keyTyped(KeyEvent e){}
          
      };
      
  }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import hyperplanning.JDBC;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;
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
public class LogIn extends JFrame implements ActionListener{
  JButton btn = new JButton("Continue");
  private KeyListener k1, k2;
  private JTextField jTextField1,jTextField2;
  private JLabel lbl;
  
  String str = "";
  
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
    
    jTextField1 = new JTextField("email");
    jTextField1.addKeyListener(k1);
    jTextField1.setBounds(10, 10, 100, 20);
    
    
    jTextField2 = new JTextField("password");
    jTextField2.addKeyListener(k2);
    jTextField2.setBounds(10, 35, 100, 20);
    
    btn.addActionListener(this);
    btn.setBounds(50, 100, 100, 20);

    
    
    jp.add(jTextField1);
    jp.add(jTextField2);
    jp.add(btn);
    
    frame.add(jp);
  }
  public void actionPerformed(ActionEvent ae)
  {
    ArrayList<String> results;
    results = new ArrayList<> ();
    JDBC maconnexion;
    try {
        maconnexion = new JDBC("projet_java","root","");
        results = maconnexion.QueryList("Select * from utilisateur where Email = '"+jTextField1.getText()+"' and Passwd = '"+jTextField2.getText()+"'");
    } catch (SQLException ex) {
      //  Logger.getLogger(LogIn.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ClassNotFoundException ex) {
     //   Logger.getLogger(LogIn.class.getName()).log(Level.SEVERE, null, ex);
    }
   // System.out.println("Select * from utilisateur where ID = 3");// Email like "+jTextField1.getText()+" and Passwd like "+jTextField2.getText()+"");
    
    System.out.println(results);
      
    if (results.size() != 0)
    {
        for(int i=0;i<results.size();i++)
    {
        System.out.println(results.get(i));
    }
        /*if (results.get(5) == '1') //student
        {
            new EDTWindow().setVisible(true);
            System.out.println("e" + str);
            this.dispose();
            
            
        }
        else*/ if (str.charAt(0) == '2')
        {
            new FacultyWindow().setVisible(true);
            this.dispose();
        }
        else if (str.charAt(0) == '3')
        {
            new AdminWindow().setVisible(true);
            this.dispose();
        }
    }
    else
    {
        System.out.println("ERROR CONNEXION");
    }
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

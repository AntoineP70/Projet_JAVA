/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 *
 * @author Helen
 */
public class Window extends JFrame{
    
    
    private JPanel m_vue = new JPanel();
    private ArrayList<JComponent> m_tab =  new ArrayList();
    
    public Window(){
        System.out.println("creation d'une fenetre");
        this.setTitle("joris le plus beau");
        this.setMinimumSize(new Dimension(900, 500));
        //this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.menu_connexion();
    }
    
    public static void main(String[] args){
        Window _window = new Window();
    }
    private void menu_connexion(){
        JPanel affichage = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        c.gridx = 1;
        c.gridy = 0;
        c.fill = GridBagConstraints.BOTH;
        JButton lundi = new JButton("lundi");
        lundi.setBackground(Color.white);
        lundi.setEnabled(false);
        affichage.add(lundi,c);
        this.m_tab.add(lundi);   
        
        c.gridx = 2;
        c.gridy = 0;
        c.fill = GridBagConstraints.BOTH;
        JButton mardi = new JButton("mardi");
        mardi.setBackground(Color.white);
        mardi.setEnabled(false);
        affichage.add(mardi,c);
        this.m_tab.add(mardi);
        
        c.gridx = 3;
        c.gridy = 0;
        c.fill = GridBagConstraints.BOTH;
        JButton mercredi = new JButton("mercredi");
        mercredi.setBackground(Color.white);
        mercredi.setEnabled(false);
        affichage.add(mercredi,c);
        this.m_tab.add(mercredi);
        
        c.gridx = 4;
        c.gridy = 0;
        c.fill = GridBagConstraints.BOTH;
        JButton jeudi = new JButton("jeudi");
        jeudi.setBackground(Color.white);
        jeudi.setEnabled(false);
        affichage.add(jeudi,c);
        this.m_tab.add(jeudi);
        
        c.gridx = 5;
        c.gridy = 0;
        c.fill = GridBagConstraints.BOTH;
        JButton vendredi = new JButton("vendredi");
        vendredi.setBackground(Color.white);
        vendredi.setEnabled(false);
        affichage.add(vendredi,c);
        this.m_tab.add(vendredi);
        
        c.gridx = 0;
        c.gridy = 1;
        c.fill = GridBagConstraints.BOTH;
        JButton a = new JButton("8h00-10h00");
        a.setBackground(Color.white);
        a.setEnabled(false);
        affichage.add(a,c);
        this.m_tab.add(a);
        
        c.gridx = 0;
        c.gridy = 2;
        c.fill = GridBagConstraints.BOTH;
        JButton b = new JButton("10h15-11h45");
        b.setBackground(Color.white);
        b.setEnabled(false);
        affichage.add(b,c);
        this.m_tab.add(b);
        
        c.gridx = 0;
        c.gridy = 3;
        c.fill = GridBagConstraints.BOTH;
        JButton d = new JButton("12h00-13h30");
        d.setBackground(Color.white);
        d.setEnabled(false);
        affichage.add(d,c);
        this.m_tab.add(d);
        
        c.gridx = 0;
        c.gridy = 4;
        c.fill = GridBagConstraints.BOTH;
        JButton e = new JButton("13h45-15h15");
        e.setBackground(Color.white);
        e.setEnabled(false);
        affichage.add(e,c);
        this.m_tab.add(e);
        
        c.gridx = 0;
        c.gridy = 5;
        c.fill = GridBagConstraints.BOTH;
        JButton f = new JButton("15h30-17h00");
        f.setBackground(Color.white);
        f.setEnabled(false);
        affichage.add(f,c);
        this.m_tab.add(f);
        
        c.gridx = 0;
        c.gridy = 6;
        c.fill = GridBagConstraints.BOTH;
        JButton g = new JButton("17h15-18h45");
        g.setBackground(Color.white);
        g.setEnabled(false);
        affichage.add(g,c);
        this.m_tab.add(g);
        
        c.gridx = 0;
        c.gridy = 7;
        c.fill = GridBagConstraints.BOTH;
        JButton h = new JButton("19h00-20h30");
        h.setBackground(Color.white);
        h.setEnabled(false);
        affichage.add(h,c);
        this.m_tab.add(h);
        
        //int index = 0; // <---- Make sure you've declared and initialized the index

        for(int j = 1; j <= 7; j++) {
            c.fill = GridBagConstraints.BOTH;
            c.gridy = j;
            c.ipady = 50;
            for(int i = 1; i <= 5; i++) {
                c.gridx = i;
                c.ipadx = 100;
                JButton z = new JButton("blabla");
                affichage.add(z, c); // <---- This will actually do what you want
                //index++; // <---- Don't forget to increment the index to get to all the buttons
            }
        }
        this.m_vue.add(affichage, BorderLayout.CENTER);
        this.afficher();
        
    }
    
    public void afficher(){
       
        this.add(this.m_vue, BorderLayout.CENTER);
        this.setVisible(true);
    }
    public void clear_screen(){
        for(int i = 0; i < this.m_tab.size(); i++){
            this.m_tab.get(i).setVisible(false);
            this.setEnabled(false);
            
        }
    }
}

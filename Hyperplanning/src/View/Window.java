package View;

import Seance.Seance;
import User.User;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Hélène & Antoine
 */
public class Window extends JFrame{
    
    
    private JPanel m_vue = new JPanel(); 
    private ArrayList<JComponent> m_tab =  new ArrayList();
    public int m_week = 0;
    public int clicked_w;
    JButton[] btn_w;
    
    public Window(ArrayList<Seance> edt,User user){      
        this.setTitle("edt");
        this.setMinimumSize(new Dimension(900, 500));
        
        JPanel affichage = new JPanel(new GridBagLayout());
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Seance[][][] planning = new Seance[52][7][7]; //Array 3D pour stocker les seances en fonction de la semaine, du jour et du creneau
        
        
        Calendar cal = Calendar.getInstance();
        System.out.println(edt.size());
        for(int i=0;i<edt.size();i++)
        {
            cal.setTime(edt.get(i).getDebut());
            int week = cal.get(Calendar.WEEK_OF_YEAR);//Identification de la semaine
            int day = cal.get(Calendar.DAY_OF_WEEK);// Identification du jour (L,M,M,J,V,S,D)
            int hour =cal.get(Calendar.HOUR_OF_DAY);// Identification de l'heure


            int creneau = 0; // Attribution d'un creneau en fonction de l'heure
            if(hour==8)creneau=0;
            if(hour==10)creneau=1;
            if(hour==12)creneau=2;
            if(hour==13)creneau=3;
            if(hour==15)creneau=4;
            if(hour==17)creneau=5;
            if(hour==19)creneau=6;
            
            System.out.println(creneau);
            planning[week][day][creneau]=edt.get(i);// remplissage de l'Array
        }
        
        GridBagConstraints c = new GridBagConstraints();
        
        ActionListener listener;
        listener = new ActionListener(){ //Si on clique sur l'un des boutons semaine, cela change l'affichage pour afficher l'EDT de cette semaine la
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(ae.getSource()instanceof JButton){                   
                    m_week = Integer.parseInt(((JButton)ae.getSource()).getText());//Changement de semaine
                    maj(planning,affichage,c,user);                    //Affichage
                }               
            }
        };

        JPanel aff_week = new JPanel();//Pannel affichage des 52 semaines
        aff_week.setLayout(new GridLayout(1,52));       
        aff_week.setMinimumSize(new Dimension(2500,50));
        aff_week.setMaximumSize(new Dimension(2500,50));
        aff_week.setPreferredSize(new Dimension(2500,50));
        
        btn_w = new JButton[52];//Passage en Array
        for(int i=0;i<52;i++)
        {
            btn_w[i] = new JButton(String.valueOf(i+1));
            btn_w[i].setBackground(Color.white);
            aff_week.add(btn_w[i]); 
            btn_w[i].addActionListener(listener);    
        }
        c.gridx=0;
        c.gridy=1;
        c.fill = GridBagConstraints.BOTH;
        c.weightx=1;
        c.weighty=1;
        m_vue.add(aff_week,c);

        this.afficher();//affichage de la fenetre
    }
   
    public void afficher(){//affichage de la fenêtre
       
        this.add(this.m_vue, BorderLayout.CENTER);
        this.setVisible(true);
    }

    public void maj(Seance[][][] planning,JPanel affichage,GridBagConstraints c,User user){// Mise a jour des données relatives à l'EDT
        affichage.removeAll();//On clear tout l'affichage
        for(int j = 0; j < 7; j++) {//pour chaque creneau
            c.fill = GridBagConstraints.BOTH;
            c.gridy = j+2;
            c.ipady = 50;
            for(int i = 0; i < 7; i++) {//pour chaque jour
                c.gridx = i+1;
                c.ipadx = 100;
                try{//Si il y a un cours alors on affiche les infos à cette case
                    ArrayList<String> info = planning[m_week][i][j].show();
                    JButton z = new JButton();
                    //Différenciation de l'affichage en fonction de la nature de l'utilisateur (Prof ou Etudiant)
                    //Etudiant :    (Nom cours, Type Cours, Nom Professeur, Salle, Site)
                    if(user.getDroit()==1) z.setText("<html>"+info.get(0)+" - "+info.get(1)+" <br> "+info.get(2)+" <br> "+info.get(4)+" - " +info.get(5)+"</html>");
                    //Etudiant :    (Nom cours, Type Cours, Nom TD, Salle, Site)
                    if(user.getDroit()==2) z.setText("<html>"+info.get(0)+" - "+info.get(1)+" <br> "+info.get(3)+" <br> "+info.get(4)+" - " +info.get(5)+"</html>");
                    affichage.add(z,c);
                    System.out.println("OK");
                }
                catch(NullPointerException empt)//Si il n'y a pas de cours on affiche une case vide
                {
                    JButton z = new JButton("");
                    affichage.add(z,c);
                  
                }
            }
        }
        aff_leg(c,affichage);//Affichage des légendes (jour et heures)
        afficher();    //affichage de la totalité 
    }
 
    public void aff_leg(GridBagConstraints c,JPanel affichage)//affichage légende
    {
//****************AFFICHAGE DES JOURS DE LA SEMAINE (AXE X)*****************************/
        c.gridx = 1;
        c.gridy = 1;
        c.fill = GridBagConstraints.BOTH;
        JButton lundi = new JButton("lundi");
        lundi.setBackground(Color.white);
        lundi.setEnabled(false);
        affichage.add(lundi,c);
        this.m_tab.add(lundi);   

        c.gridx = 2;
        c.gridy = 1;
        c.fill = GridBagConstraints.BOTH;
        JButton mardi = new JButton("mardi");
        mardi.setBackground(Color.white);
        mardi.setEnabled(false);
        affichage.add(mardi,c);
        this.m_tab.add(mardi);

        c.gridx = 3;
        c.gridy = 1;
        c.fill = GridBagConstraints.BOTH;
        JButton mercredi = new JButton("mercredi");
        mercredi.setBackground(Color.white);
        mercredi.setEnabled(false);
        affichage.add(mercredi,c);
        this.m_tab.add(mercredi);

        c.gridx = 4;
        c.gridy = 1;
        c.fill = GridBagConstraints.BOTH;
        JButton jeudi = new JButton("jeudi");
        jeudi.setBackground(Color.white);
        jeudi.setEnabled(false);
        affichage.add(jeudi,c);
        this.m_tab.add(jeudi);

        c.gridx = 5;
        c.gridy = 1;
        c.fill = GridBagConstraints.BOTH;
        JButton vendredi = new JButton("vendredi");
        vendredi.setBackground(Color.white);
        vendredi.setEnabled(false);
        affichage.add(vendredi,c);
        this.m_tab.add(vendredi);

        c.gridx = 6;
        c.gridy = 1;
        c.fill = GridBagConstraints.BOTH;
        JButton samedi = new JButton("samedi");
        samedi.setBackground(Color.white);
        samedi.setEnabled(false);
        affichage.add(samedi,c);
        this.m_tab.add(samedi);

        c.gridx = 7;
        c.gridy = 1;
        c.fill = GridBagConstraints.BOTH;
        JButton dimanche = new JButton("dimanche");
        dimanche.setBackground(Color.white);
        dimanche.setEnabled(false);
        affichage.add(dimanche,c);
        this.m_tab.add(dimanche);
//********************AFFICHAGE DES HEURES (AXE Y)***********************************
        c.gridx = 0;
        c.gridy = 2;
        c.fill = GridBagConstraints.BOTH;
        JButton a = new JButton("8h00-10h00");
        a.setBackground(Color.white);
        a.setEnabled(false);
        affichage.add(a,c);
        this.m_tab.add(a);

        c.gridx = 0;
        c.gridy = 3;
        c.fill = GridBagConstraints.BOTH;
        JButton b = new JButton("10h15-11h45");
        b.setBackground(Color.white);
        b.setEnabled(false);
        affichage.add(b,c);
        this.m_tab.add(b);

        c.gridx = 0;
        c.gridy = 4;
        c.fill = GridBagConstraints.BOTH;
        JButton d = new JButton("12h00-13h30");
        d.setBackground(Color.white);
        d.setEnabled(false);
        affichage.add(d,c);
        this.m_tab.add(d);

        c.gridx = 0;
        c.gridy = 5;
        c.fill = GridBagConstraints.BOTH;
        JButton e = new JButton("13h45-15h15");
        e.setBackground(Color.white);
        e.setEnabled(false);
        affichage.add(e,c);
        this.m_tab.add(e);

        c.gridx = 0;
        c.gridy = 6;
        c.fill = GridBagConstraints.BOTH;
        JButton f = new JButton("15h30-17h00");
        f.setBackground(Color.white);
        f.setEnabled(false);
        affichage.add(f,c);
        this.m_tab.add(f);

        c.gridx = 0;
        c.gridy = 7;
        c.fill = GridBagConstraints.BOTH;
        JButton g = new JButton("17h15-18h45");
        g.setBackground(Color.white);
        g.setEnabled(false);
        affichage.add(g,c);
        this.m_tab.add(g);

        c.gridx = 0;
        c.gridy = 8;
        c.fill = GridBagConstraints.BOTH;
        JButton h = new JButton("19h00-20h30");
        h.setBackground(Color.white);
        h.setEnabled(false);
        affichage.add(h,c);
        this.m_tab.add(h);


        this.m_vue.add(affichage, BorderLayout.CENTER);
    }

}




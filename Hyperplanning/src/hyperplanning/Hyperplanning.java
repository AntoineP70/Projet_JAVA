/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hyperplanning;

import Seance.Seance;
import User.Etudiant;
import User.Professeur;
import User.User;
import java.awt.event.ActionEvent;
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
    
    public static void main(String[] args) {
        // TODO code application logic here
        Etudiant UsingE;
        Professeur UsingP;
        View.LogIn Loged = null;
        Loged = new  View.LogIn();
        
        while(Loged.userE==null && Loged.userP==null)
        {
            Loged.setVisible(true);
           
            if(Loged.userE!=null)
            {
                System.out.println(Loged.userE.getNum());
                
            }
            if(Loged.userP!=null)
            {
                ArrayList<Seance> cours = Loged.userP.getCours();

                
            }
            
        }
        
        
    }
    
}

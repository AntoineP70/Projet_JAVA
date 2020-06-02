/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;

/**
 *
 * @author Antoine
 */
public interface UserInterface {
    public void ajouter(Etudiant e);
    public void ajouter(Professeur p);
    public void modifier(Etudiant e);
    public void modifier(Professeur p);
    
}

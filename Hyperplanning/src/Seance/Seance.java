/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Seance;

import Data.*;
import User.Professeur;

/**
 *
 * @author Antoine
 */
public class Seance  {
    private int m_ID;
    private String m_nom;
    private String m_type;
    private Creneau m_creneau;
    private boolean etat;
    private Salle salle;
    private Professeur m_prof;
    private Groupes m_classe;
}

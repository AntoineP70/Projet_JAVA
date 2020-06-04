/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.util.*;

/**
 *
 * @author Antoine
 */
public class Site {
    private int m_ID;
    private String m_nom;
    private ArrayList<Salle> m_salles;

    public Site(int ID, String nom) {
        m_ID= ID;
        m_nom= nom;
    }
}

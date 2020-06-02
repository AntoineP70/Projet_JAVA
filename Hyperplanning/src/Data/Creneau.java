/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 *
 * @author Antoine
 */
public class Creneau {
    private int m_semaine;
    private int m_date;
    private int heure_D;
    private int heure_F;

    
    
    public Creneau(int s,int d,int hd,int hf)
    {
        m_semaine = s;
        m_date = d;
        heure_D = hd;
        heure_F = hf;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Modele.Batiment;
import Modele.Jeu;
import java.util.HashMap;

/**
 *
 * @author Loïc Cimon
 */

public class Plateau extends ImagePanel {
    
    private Jeu jeu;

    public Plateau() {
        //Image de fond
        super("Images/3070_1.jpg");
        
        this.jeu = new Jeu(0, 0, new HashMap<Integer, Batiment>());        
        initComponents();
    }
    
    private void initComponents() {        
        //Création des cases pour les batiments normaux
        for(int i = 14; i < 36; i++){
            this.add(new Case(jeu.getCoord()[i], 70, 50));
        }
    }
}

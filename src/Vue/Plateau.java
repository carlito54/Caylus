/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Modele.Batiment;
import Modele.Jeu;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

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
        //Création des batiments neutres
        List<String> batNeutre = new ArrayList<>();
        batNeutre.add("Images/Bois1.jpg");
        batNeutre.add("Images/Pierre1.jpg");
        batNeutre.add("Images/BoisNourriture1.jpg");
        batNeutre.add("Images/CharpentierNeutre.jpg");
        batNeutre.add("Images/Marche1.jpg");
        batNeutre.add("Images/Nourriture1.jpg");
        
        //Mélange aléatoire
        Collections.shuffle(batNeutre);
        
        for(int i = 8; i < 14; i++){
            this.add(new Case(jeu.getCoord()[i], batNeutre.get(i-8)));
        }
        
        //Création des cases vides
        for(int i = 14; i < 36; i++){
            this.add(new Case(jeu.getCoord()[i]));
        }
    }
}

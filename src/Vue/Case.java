/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Modele.Coordonnee;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Loïc Cimon
 */
public class Case extends ImagePanel {
    
    private Coordonnee coord;

    public Case(Coordonnee coord) {
        super("Images/Marche1.jpg");
        
        this.coord = coord;        
        initComponents();
    }
    
    public Case(Coordonnee coord, String img) {
        super(img);
        
        this.coord = coord;
        initComponents();
    }
    
    private void initComponents() {
        //Position de la case
        this.setBounds(coord.getX(), coord.getY(), this.getImage().getWidth(null), this.getImage().getHeight(null));
    }
}

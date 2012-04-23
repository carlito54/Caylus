package Modele;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.text.NumberFormat;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;


public class IHM {
	
	private JFrame jf;
	private JPanel jp;
	private JFormattedTextField jt;
	
	private Jeu jeu;
	
	public IHM(){
		jf = new JFrame();
		jp = new JPanel();
		ArrayList<Batiment> listeBatiment = new ArrayList<Batiment>();
		jeu = new Jeu(14, 14, listeBatiment);
		jf.setTitle("Caylus");
		jf.setSize(300,150);
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		jf.setVisible(true);
		jf.setLayout(new BorderLayout());
		
		JLabel jl = new JLabel("Combien de joueurs (1 à 5)? : ");
		jt = new JFormattedTextField(NumberFormat.getIntegerInstance());
		jt.setPreferredSize(new Dimension(20,20));
		JButton jb = new JButton("Valider");
		jp.add(jl);
		jp.add(jt);
		jp.add(jb,BorderLayout.SOUTH);

		jf.add(jp);	
		
		
		jb.addActionListener(new BoutonListener());
	}
	 class BoutonListener  implements ActionListener{
		 
         /**
          * Redéfinition de la méthode actionPerformed
          */
         public void actionPerformed(ActionEvent arg0) {
        	 if( Integer.parseInt(jt.getText())>0 && Integer.parseInt(jt.getText())<6){
	    		 Image image = Toolkit.getDefaultToolkit().getImage("Images/3070_1.jpg");
	    		 ImagePanel imp = new ImagePanel(image);
	    		 imp.setLayout(null);
	    		 jf.remove(jp);
	    		 jf.setSize(650,750);
	 			 JPanel jp1 = new JPanel();
				 Image imagetest = Toolkit.getDefaultToolkit().getImage("Images/Alchimiste.jpg");
				 ImagePanel imptest = new ImagePanel();
				 imptest.setPreferredSize(new Dimension(60,50));
				 imptest.setImage(imagetest);
				 imptest.setLayout(null);
				 imptest.setBounds(123, 626, 70, 50);
				// imp.setSize(500,500);
				 //jp1.add(imptest);
				 imp.add(imptest);
       			 jf.add(imp);
       			
        	 }else{
        		 JOptionPane.showMessageDialog(jp,"Le nombre de joueur est incorrect");
        	 }
         }

         public void initialisationPlateau(int joueur){
        	 
        	 Joueur j1 = new Joueur("Joueur1", 0, 0, new Ressource(0,0,0,0,0));
        	 Joueur j2 = new Joueur("Joueur2", 0, 0, new Ressource(0,0,0,0,0));
        	 Joueur j3 = new Joueur("Joueur3", 0, 0, new Ressource(0,0,0,0,0));
        	 Joueur j4 = new Joueur("Joueur4", 0, 0, new Ressource(0,0,0,0,0));
        	 Joueur j5 = new Joueur("Joueur5", 0, 0, new Ressource(0,0,0,0,0));
        	 
        	 switch (joueur) {
        	 	case 1:
        	 		jeu.getJoueur().add(j1);
        	 		break;
        	 	case 2:
        	 		jeu.getJoueur().add(j1);
        	 		jeu.getJoueur().add(j2);
        	 		break;
        	 	case 3:
        	 		jeu.getJoueur().add(j1);
        	 		jeu.getJoueur().add(j2);
        	 		jeu.getJoueur().add(j3);
        	 		break;
        	 	case 4:
        	 		jeu.getJoueur().add(j1);
        	 		jeu.getJoueur().add(j2);
        	 		jeu.getJoueur().add(j3);
        	 		jeu.getJoueur().add(j4);
        	 		break;
        	 	case 5:
        	 		jeu.getJoueur().add(j1);
        	 		jeu.getJoueur().add(j2);
        	 		jeu.getJoueur().add(j3);
        	 		jeu.getJoueur().add(j4);
        	 		jeu.getJoueur().add(j5);
        	 		break;

        	 	default:
        	 		break;
			}
         }
         
 }
	public static void main(String[] args){
		
		IHM affichage = new IHM();
		
		
	}

}

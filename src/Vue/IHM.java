package Vue;

import Modele.Batiments.Auberge;
import Modele.Batiment;
import Modele.Batiments.BatimentSpeciaux;
import Modele.Batiments.Chateau;
import Modele.Coordonnee;
import Modele.Ecurie;
import Modele.Jeu;
import Modele.Joueur;
import Modele.Ressource;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;

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
	private String[] neutre; 
	private ImagePanel imp;
	
	private Jeu jeu;
	
	public IHM(){
		jf = new JFrame();
		jp = new JPanel();
		HashMap<Integer, Batiment> listeBatiment = new HashMap<Integer, Batiment>();
		jeu = new Jeu(14, 14, listeBatiment);
		jf.setTitle("Caylus");
		jf.setSize(300,150);
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		jf.setVisible(true);
		jf.setLayout(new BorderLayout());
		neutre = new String[6];
		neutre[0] = "Images/Bois1.jpg";
		neutre[1] = "Images/Pierre1.jpg";
		neutre[2] = "Images/BoisNourriure1.jpg";
		neutre[3] = "Images/CharpentierNeutre.jpg";
		neutre[4] = "Images/Marche1.jpg";
		neutre[5] = "Images/Nourriture1.jpg";
		JLabel jl = new JLabel("Combien de joueurs (1 � 5)? : ");
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
          * Red�finition de la m�thode actionPerformed
          */
         public void actionPerformed(ActionEvent arg0) {
        	 Coordonnee[] coord = jeu.getCoord();
        	 if(Integer.parseInt(jt.getText())>0 && Integer.parseInt(jt.getText())<6){
	    		Image image = Toolkit.getDefaultToolkit().getImage("Images/3070_1.jpg");
	    		imp = new ImagePanel(image);
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
       			
       			jeu.setJoueur(initialisationPlateau(Integer.parseInt(jt.getText())));
       			initBatiment();
       			ArrayList<Integer> choixBatNeutre = jeu.batNeutreRamdom();
       			
       			imagetest = Toolkit.getDefaultToolkit().getImage(neutre[choixBatNeutre.get(0)]);
				ImagePanel jp8 = new ImagePanel();
				jp8.setPreferredSize(new Dimension(60,50));
				jp8.setImage(imagetest);
				jp8.setLayout(null);
				jp8.setBounds(coord[8].getX(), coord[8].getY(), 70, 50);
				imp.add(jp8);
				jeu.ajoutNeutre(choixBatNeutre.get(0),8);
				
       			imagetest = Toolkit.getDefaultToolkit().getImage(neutre[choixBatNeutre.get(1)]);
				ImagePanel jp9 = new ImagePanel();
				jp9.setPreferredSize(new Dimension(60,50));
				jp9.setImage(imagetest);
				jp9.setLayout(null);
				jp9.setBounds(coord[9].getX(), coord[9].getY(), 70, 50);
				imp.add(jp9);
				jeu.ajoutNeutre(choixBatNeutre.get(1),9);
				
       			imagetest = Toolkit.getDefaultToolkit().getImage(neutre[choixBatNeutre.get(2)]);
       			ImagePanel jp10 = new ImagePanel();
       			jp10.setPreferredSize(new Dimension(60,50));
       			jp10.setImage(imagetest);
       			jp10.setLayout(null);
       			jp10.setBounds(coord[10].getX(), coord[10].getY(), 70, 50);
				imp.add(jp10);
				jeu.ajoutNeutre(choixBatNeutre.get(2),10);
				
       			imagetest = Toolkit.getDefaultToolkit().getImage(neutre[choixBatNeutre.get(3)]);
       			ImagePanel jp11 = new ImagePanel();
       			jp11.setPreferredSize(new Dimension(60,50));
       			jp11.setImage(imagetest);
       			jp11.setLayout(null);
       			jp11.setBounds(coord[11].getX(), coord[11].getY(), 70, 50);
				imp.add(jp11);
				jeu.ajoutNeutre(choixBatNeutre.get(3),11);
       			
       			imagetest = Toolkit.getDefaultToolkit().getImage(neutre[choixBatNeutre.get(4)]);
       			ImagePanel jp12 = new ImagePanel();
       			jp12.setPreferredSize(new Dimension(60,50));
       			jp12.setImage(imagetest);
       			jp12.setLayout(null);
       			jp12.setBounds(coord[12].getX(), coord[12].getY(), 70, 50);
				imp.add(jp12);
				jeu.ajoutNeutre(choixBatNeutre.get(4),12);
       			
       			imagetest = Toolkit.getDefaultToolkit().getImage(neutre[choixBatNeutre.get(5)]);
       			ImagePanel jp13 = new ImagePanel();
       			jp13.setPreferredSize(new Dimension(60,50));
       			jp13.setImage(imagetest);
       			jp13.setLayout(null);
				jp13.setBounds(coord[13].getX(), coord[13].getY(), 70, 50);
				imp.add(jp13);
				jeu.ajoutNeutre(choixBatNeutre.get(5),13);
       			jf.add(imp);
        	 }else{
        		 JOptionPane.showMessageDialog(jp,"Le nombre de joueur est incorrect");
        	 }
         }

         public ArrayList<Joueur> initialisationPlateau(int joueur){
        	 
        	 Joueur j1 = new Joueur("Joueur1", 0, 0, new Ressource(0,0,0,0,0));
        	 Joueur j2 = new Joueur("Joueur2", 0, 0, new Ressource(0,0,0,0,0));
        	 Joueur j3 = new Joueur("Joueur3", 0, 0, new Ressource(0,0,0,0,0));
        	 Joueur j4 = new Joueur("Joueur4", 0, 0, new Ressource(0,0,0,0,0));
        	 Joueur j5 = new Joueur("Joueur5", 0, 0, new Ressource(0,0,0,0,0));
        	 ArrayList<Joueur> j = new ArrayList<Joueur>();
        	 //j = jeu.getJoueur();
        	 switch (joueur) {
        	 	case 1:
        	 		j.add(j1);
        	 		//ArrayList<String> j = new ArrayList() {{ add("nom1"); add("nom2"); add("nom3) }};
        	 		break;
        	 	case 2:
        	 		j.add(j1);
        	 		j.add(j2);
        	 		break;
        	 	case 3:
        	 		j.add(j1);
        	 		j.add(j2);
        	 		j.add(j3);
        	 		break;
        	 	case 4:
        	 		j.add(j1);
        	 		j.add(j2);
        	 		j.add(j3);
        	 		j.add(j4);
        	 		break;
        	 	case 5:
        	 		j.add(j1);
        	 		j.add(j2);
        	 		j.add(j3);
        	 		j.add(j4);
        	 		j.add(j5);
        	 		break;

        	 	default:
        	 		break;
			}
        	 

        	 return j;
        	 
         }
         
         public void placerOuvrier(){
        	 imp.addMouseListener(new MouseListener() {
				public void mouseReleased(MouseEvent arg0) {}
				public void mousePressed(MouseEvent arg0) {}				
				public void mouseExited(MouseEvent arg0) {}			
				public void mouseEntered(MouseEvent arg0) {}
				public void mouseClicked(MouseEvent arg0) {
					
				}
			});
        	 
         }
         
         public void initBatiment(){
        	 jeu.getRevenu();
        	 Chateau chateau = new Chateau("chateau", 0, 1);
        	 jeu.getListeBatiment().put(0, chateau);
        	 BatimentSpeciaux porte = new BatimentSpeciaux("Porte", 1);
        	 jeu.getListeBatiment().put(1, porte);
        	 BatimentSpeciaux comptoir = new BatimentSpeciaux("Comptoir", 2);
        	 jeu.getListeBatiment().put(2, comptoir);
        	 BatimentSpeciaux guilde = new BatimentSpeciaux("Guilde", 3);
        	 jeu.getListeBatiment().put(3, guilde);
        	 BatimentSpeciaux champs = new BatimentSpeciaux("Champs", 4);
        	 jeu.getListeBatiment().put(4, champs);
        	 Ecurie ecurie = new Ecurie("Ecurie", 5);
        	 jeu.getListeBatiment().put(5, ecurie);
        	 Auberge auberge = new Auberge("Auberge", 6);
        	 jeu.getListeBatiment().put(6, auberge);
         }        
	 }
	public static void main(String[] args){
		
		IHM affichage = new IHM();
	
	}

}

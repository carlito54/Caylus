package Vue;

import Modele.*;
import Modele.Batiments.Auberge;
import Modele.Batiments.BatimentSpeciaux;
import Modele.Batiments.Chateau;
import Modele.Batiments.Pont;
import java.awt.BorderLayout;
import java.awt.Color;
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
	private HashMap<Integer,ImagePanel> jtab;
	private int place;
	private boolean stop;
	private int ordreTour;
	private Jeu jeu;
	private ImageList imageList;
	private boolean aDroit;
	
	
	public IHM(){
		jf = new JFrame();
		jp = new JPanel();
		ordreTour = 0;
		HashMap<String, Image> ouvrierList = new HashMap<String, Image>();
		ouvrierList.put("Joueur1", Toolkit.getDefaultToolkit().getImage("Images/ouvrierrouge.jpg"));
		ouvrierList.put("Joueur2", Toolkit.getDefaultToolkit().getImage("Images/ouvrierbleu.jpg"));
		ouvrierList.put("Joueur3", Toolkit.getDefaultToolkit().getImage("Images/ouvrierorange.jpg"));
		ouvrierList.put("Joueur4", Toolkit.getDefaultToolkit().getImage("Images/ouvriervert.jpg"));
		ouvrierList.put("Joueur5", Toolkit.getDefaultToolkit().getImage("Images/ouvriernoir.jpg"));
		HashMap<String, Image> maisonList = new HashMap<String, Image>();
		maisonList.put("Joueur1", Toolkit.getDefaultToolkit().getImage("Images/maisonrouge.jpg"));
		maisonList.put("Joueur2", Toolkit.getDefaultToolkit().getImage("Images/maisonbleu.jpg"));
		maisonList.put("Joueur3", Toolkit.getDefaultToolkit().getImage("Images/maisonorange.jpg"));
		maisonList.put("Joueur4", Toolkit.getDefaultToolkit().getImage("Images/maisonvert.jpg"));
		maisonList.put("Joueur5", Toolkit.getDefaultToolkit().getImage("Images/maisonnoir.jpg"));
		HashMap<String, Image> marqueurList = new HashMap<String, Image>();
		marqueurList.put("Joueur1", Toolkit.getDefaultToolkit().getImage("Images/marqueurrouge.jpg"));
		marqueurList.put("Joueur2", Toolkit.getDefaultToolkit().getImage("Images/marqueurbleu.jpg"));
		marqueurList.put("Joueur3", Toolkit.getDefaultToolkit().getImage("Images/marqueurorange.jpg"));
		marqueurList.put("Joueur4", Toolkit.getDefaultToolkit().getImage("Images/marqueurvert.jpg"));
		marqueurList.put("Joueur5", Toolkit.getDefaultToolkit().getImage("Images/marqueurnoir.jpg"));
		imageList = new ImageList(ouvrierList, maisonList, marqueurList);
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
		jt.requestFocus();
		jt.requestFocusInWindow();
		jp.add(jl);
		jp.add(jt);
		jp.add(jb);

		jf.add(jp);	
		
		
		jb.addActionListener(new BoutonListener());
	}
	 class BoutonListener  implements ActionListener{
		 
         /**
          * Red�finition de la m�thode actionPerformed
          */
         public void actionPerformed(ActionEvent arg0) {
        	 Coordonnee[] coord = jeu.getCoord();
        	 if(Integer.parseInt(jt.getText())>1 && Integer.parseInt(jt.getText())<6){
	    		Image image = Toolkit.getDefaultToolkit().getImage("Images/3070_1.jpg");
	    		imp = new ImagePanel(image,630,710);
	    		imp.setLayout(null);
	    		jf.remove(jp);
	    		jf.setSize(650,766);
	 			JPanel jp1 = new JPanel();
	 			jtab = new HashMap<Integer,ImagePanel>();
	 			for(int i = 14;i<36;i++){
	 				ImagePanel imp1 = new ImagePanel(Toolkit.getDefaultToolkit().getImage("Images/ini.png"),20,20);
	 				imp1.setLayout(null);
	 				imp1.setBounds(jeu.getCoord()[i].getX(), jeu.getCoord()[i].getY(), 15, 15);
	 				jtab.put(((i-4)*5+2), imp1);
	 				ImagePanel imp2 = new ImagePanel(Toolkit.getDefaultToolkit().getImage("Images/ini.png"),20,20);
	 				imp2.setPreferredSize(new Dimension(20, 20));
	 				imp2.setLayout(null);
	 				imp2.setBounds(jeu.getCoord()[i].getX()+55, jeu.getCoord()[i].getY(), 15, 15);
	 				jtab.put(((i-4)*5+3), imp2);
	 				ImagePanel imp3 = new ImagePanel(Toolkit.getDefaultToolkit().getImage("Images/ini.png"),20,20);
	 				imp3.setLayout(null);
	 				imp3.setBounds(jeu.getCoord()[i].getX(), jeu.getCoord()[i].getY()+35, 15, 15);
	 				jtab.put(((i-4)*5+4), imp3);
	 				ImagePanel imp4 = new ImagePanel(Toolkit.getDefaultToolkit().getImage("Images/ini.png"),20,20);
	 				imp4.setLayout(null);
	 				imp4.setBounds(jeu.getCoord()[i].getX()+55, jeu.getCoord()[i].getY()+35, 15, 15);
	 				jtab.put(((i-4)*5+5), imp4);
	 				ImagePanel imp5 = new ImagePanel(Toolkit.getDefaultToolkit().getImage("ini.png"),70,50);
	 				imp5.setLayout(null);
	 				imp5.setBounds(jeu.getCoord()[i].getX(), jeu.getCoord()[i].getY(), 70, 50);
	 				jtab.put(((i-4)*5+6), imp5);
	 				imp5.add(imp1);
 					imp5.add(imp2);
 					imp5.add(imp3);
 					imp5.add(imp4);
 					jp.add(imp5);
	 			}
				Image imagetest = Toolkit.getDefaultToolkit().getImage("Images/prevot.jpg");
				ImagePanel imptest = new ImagePanel(imagetest,20,20);
				imptest.setImage(imagetest);
				//imptest.setSize(new Dimension(160,150));
				
				imptest.setLayout(null);
				imptest.setBounds(123, 626, 70, 50);
				// imp.setSize(500,500);
				//jp1.add(imptest);
				 
				imp.add(imptest);
       			
       			jeu.setJoueur(initialisationJoueur(Integer.parseInt(jt.getText())));
       			jeu.setOrdreTour(initialisationJoueur(Integer.parseInt(jt.getText())));
       			initBatiment();
       			ArrayList<Integer> choixBatNeutre = jeu.batNeutreRamdom();
       			
       			initialisationPlateau(choixBatNeutre, 8, 0);
       			initialisationPlateau(choixBatNeutre, 9, 1);
       			initialisationPlateau(choixBatNeutre, 10, 2);
       			initialisationPlateau(choixBatNeutre, 11, 3);
       			initialisationPlateau(choixBatNeutre, 12, 4);
       			initialisationPlateau(choixBatNeutre, 13, 5);

       			jf.add(imp);
       			stop = false;
       			jf.addMouseListener(new MouseListener() {
					public void mouseReleased(MouseEvent e) {}
					public void mousePressed(MouseEvent e) {}
					public void mouseExited(MouseEvent e) {}
					public void mouseEntered(MouseEvent e) {}
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub
						switch (jeu.getPhase()) {
						case 2:
							Joueur j =jeu.getOrdreTour().get(ordreTour);
							int pos = jeu.retournePosition(e.getX(), e.getY());
							System.out.println("est ce que �a marche?" + pos);
							if(pos != -1){
								placerOuvrier(pos);
							}
							
							jf.repaint();
							break;

						default:
							break;
						}
					
					}
				});
        	 }else{
        		 JOptionPane.showMessageDialog(jp,"Le nombre de joueur est incorrect");
        	 }
         }

         public void initialisationPlateau(ArrayList<Integer> choixBatNeutre, int pos, int emplacement){
        	 	Coordonnee[] coord = jeu.getCoord();
        	 	Image imagetest = Toolkit.getDefaultToolkit().getImage(neutre[choixBatNeutre.get(emplacement)]);
				ImagePanel jp8 = new ImagePanel(imagetest,70,50);
				jp8.setPreferredSize(new Dimension(60,50));
				jp8.setImage(imagetest);
				jp8.setLayout(null);
				jp8.setBounds(coord[pos].getX(), coord[pos].getY(), 70, 50);
				jtab.put(((pos-4)*5)+3,jp8);
				
				ImagePanel imp1 = new ImagePanel(Toolkit.getDefaultToolkit().getImage("Images/ini.png"),15,15);
				imp1.setLayout(null);
				imp1.setBounds(jeu.getCoord()[pos].getX(), jeu.getCoord()[pos].getY(), 15, 15);
				jtab.put(((pos-4)*5)+3, imp1);
				imp.add(imp1);
				
				ImagePanel imp2 = new ImagePanel(Toolkit.getDefaultToolkit().getImage("Images/ini.png"),15,15);
				imp2.setLayout(null);
				imp2.setBounds(jeu.getCoord()[pos].getX()+55, jeu.getCoord()[pos].getY(), 15, 15);
				jtab.put(((pos-4)*5)+4, imp2);
				imp.add(imp2);
				
				ImagePanel imp3 = new ImagePanel(Toolkit.getDefaultToolkit().getImage("Images/ini.png"),15,15);
				imp3.setLayout(null);
				imp3.setBounds(jeu.getCoord()[pos].getX(), jeu.getCoord()[pos].getY()+35, 15, 15);
				jtab.put(((pos-4)*5)+5,imp3);
				imp.add(imp3);
				
 				ImagePanel imp4 = new ImagePanel(Toolkit.getDefaultToolkit().getImage("Images/ini.png"),15,15);
 				imp4.setLayout(null);
 				imp4.setBounds(jeu.getCoord()[pos].getX()+55, jeu.getCoord()[pos].getY()+35, 15, 15);
 				jtab.put(((pos-4)*5)+6, imp4);
 				imp.add(imp4);
 				imp.add(jp8);
				jeu.ajoutNeutre(choixBatNeutre.get(0),pos);
         }
         
         public ArrayList<Joueur> initialisationJoueur(int joueur){
        	 
        	 Joueur j1 = new Joueur("Joueur1", 0, 0, new Ressource());
        	 Joueur j2 = new Joueur("Joueur2", 0, 0, new Ressource());
        	 Joueur j3 = new Joueur("Joueur3", 0, 0, new Ressource());
        	 Joueur j4 = new Joueur("Joueur4", 0, 0, new Ressource());
        	 Joueur j5 = new Joueur("Joueur5", 0, 0, new Ressource());
        	 ArrayList<Joueur> j = new ArrayList<Joueur>();
        	 //j = jeu.getJoueur();
        	 switch (joueur) {
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
         
         public void placerOuvrier(int pos){
        	 
        	 System.out.println("positionnnnnnnnnnnnnnn"+(((pos-4)*5)+3));
        	 Joueur j = jeu.placerOuvrier(pos);
        	 System.out.println(j.getNom() + pos);
        	 if(jeu.isaDroit()){
        	
	        	 if(j.getNom() == "Joueur1"){
	        		 jtab.get(((pos-4)*5)+3).setImage(Toolkit.getDefaultToolkit().getImage("Images/ouvrierrouge.jpg"),20,20);
	        	 }else{
	        		 if(j.getNom() == "Joueur2"){
	            		 jtab.get(((pos-4)*5)+3).setImage(Toolkit.getDefaultToolkit().getImage("Images/ouvrierbleu.jpg"),20,20);
	            	 }else{
	            		 if(j.getNom() == "Joueur3"){
	                		 jtab.get(((pos-4)*5)+3).setImage(Toolkit.getDefaultToolkit().getImage("Images/ouvrierorange.jpg"),20,20);
	                	 }else{
	                		 if(j.getNom() == "Joueur4"){
	                    		 jtab.get(((pos-4)*5)+3).setImage(Toolkit.getDefaultToolkit().getImage("Images/ouvriervert.jpg"),20,20);
	                    	 }else{
	                    		 jtab.get(((pos-4)*5)+3).setImage(Toolkit.getDefaultToolkit().getImage("Images/ouvriernoir.jpg"),20,20);
	                    	 }
	                	 }
	            	 }
	        	 }
	        }
        	 jf.repaint();
        	 
        	 jf.repaint();
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
        	 Pont pont = new Pont("pont", 7);
        	 jeu.getListeBatiment().put(7, pont);
         }        
	 }
	 
	 
	public JFrame getJf() {
		return jf;
	}


	public void setJf(JFrame jf) {
		this.jf = jf;
	}


	public JPanel getJp() {
		return jp;
	}


	public void setJp(JPanel jp) {
		this.jp = jp;
	}


	public JFormattedTextField getJt() {
		return jt;
	}


	public void setJt(JFormattedTextField jt) {
		this.jt = jt;
	}


	public String[] getNeutre() {
		return neutre;
	}


	public void setNeutre(String[] neutre) {
		this.neutre = neutre;
	}


	public ImagePanel getImp() {
		return imp;
	}


	public void setImp(ImagePanel imp) {
		this.imp = imp;
	}


//	public ArrayList<ImagePanel> getJtab() {
//		return jtab;
//	}
//
//
//	public void setJtab(ArrayList<ImagePanel> jtab) {
//		this.jtab = jtab;
//	}


	HashMap<Integer, ImagePanel> getJtab() {
		return jtab;
	}


	void setJtab(HashMap<Integer, ImagePanel> jtab) {
		this.jtab = jtab;
	}


	int getPlace() {
		return place;
	}


	void setPlace(int place) {
		this.place = place;
	}


	boolean isStop() {
		return stop;
	}


	void setStop(boolean stop) {
		this.stop = stop;
	}


	int getOrdreTour() {
		return ordreTour;
	}


	void setOrdreTour(int ordreTour) {
		this.ordreTour = ordreTour;
	}


	ImageList getImageList() {
		return imageList;
	}


	void setImageList(ImageList imageList) {
		this.imageList = imageList;
	}


	boolean isaDroit() {
		return aDroit;
	}


	void setaDroit(boolean aDroit) {
		this.aDroit = aDroit;
	}


	public Jeu getJeu() {
		return jeu;
	}


	public void setJeu(Jeu jeu) {
		this.jeu = jeu;
	}


	public static void main(String[] args){
		
		IHM affichage = new IHM();
	
	}

}

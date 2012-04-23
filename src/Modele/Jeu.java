package Modele;

import java.awt.Container;
import java.util.ArrayList;
import java.util.Iterator;

public class Jeu {
	
	private ArrayList<Joueur> joueur;
	private ArrayList<Joueur> fileFinPose;
	private ArrayList<Joueur> ordreTour;
	private int prevot;
	private int baili;
	private Auberge auberge;
	private ArrayList<Batiment> listeBatiment;
	
	
	public Jeu(int prevot, int baili, ArrayList<Batiment> listeBatiment) {
		super();
		this.fileFinPose = new ArrayList<Joueur>();
		this.ordreTour = new ArrayList<Joueur>();
		this.prevot = prevot;
		this.baili = baili;
		this.listeBatiment = listeBatiment;
		this.auberge = new Auberge("Auberge", 7);
		
	}


	public Batiment getBatiment(int pos){
		int i = 0;
		boolean trouve = false;
		Batiment res = null;
		while(!trouve || i<listeBatiment.size()){
			if (listeBatiment.get(i).getPosition()==pos){
				trouve = true;
				res = listeBatiment.get(i);
			}else{
				i++;
			}
		}
		return res;
	}
	
	public Joueur batimentOccupe(int pos){
		Joueur res = null;
		Batiment bat = getBatiment(pos);
		if (bat != null){
			if(bat.isOccupe()){
				res = bat.getPresent();
			}
		}
		return res;
	}
	
	public void getRevenu(){
		Joueur j = null;
		Batiment bat = null;
		int i = 0;
		int k = 0;
		for(i = 0;i<joueur.size();i++){
			j = joueur.get(i);
			j.setNbDenier(2);
			for(k = 1; k <= baili;k++){
				j = batimentOccupe(k);
				bat = getBatiment(k);
				if(j != null){
					if(bat != null){
					if(bat.getNom() == "Residence" && j == bat.getProprio());
						j.setNbDenier(1);
					if(bat.getNom() == "Bibliotheque" && j == bat.getProprio());
						j.setNbDenier(1);
					if(bat.getNom() == "Hotel" && j == bat.getProprio());
						j.setNbDenier(2);	
					}
				}
			}
		}
	}
	
	public void payer(Joueur j){
		j.getOuvrier().setNombre(-1);
		if(j == auberge.getPlace2()){
			j.setNbDenier(-1);
		}else{
			j.setNbDenier(-(ordreTour.size()+1));	
		}
	}
	
	public void placerOuvrier(){	
		int fin = 0;
		int i = 0; 
		int pos = 0;
		Joueur j;
		Batiment bat;
		while (ordreTour.size() != 0){
			// il faudra recuperer le batiment grâce au clique 
			bat = getBatiment(pos);
			j = ordreTour.get(i);
			if(bat.getNom() == "pont"){
				fileFinPose.add(j); 
				fileFinPose.add(j);
				fin ++;
			}else{
				if(!bat.isOccupe()){
					if(bat.getProprio() == j){
						bat.setOccupe(true);
						payer(j);
						bat.setPresent(j);
					}else{
						if(bat.getProprio() != j && bat.getProprio() != null){
							bat.setOccupe(true);
							payer(j);
							bat.setPresent(j);
							bat.getProprio().setNbPrestige(1);
						}else{
							if( bat instanceof Auberge){
								((Auberge) bat).next(j);
								payer(j);
							}else{
								if(bat instanceof Ecurie){
									((Ecurie) bat).next(j);
									payer(j);
								}else{
									if(bat instanceof Chateau){
										if(!((Chateau) bat).getOrdreConst().contains(j)){
											((Chateau) bat).getOrdreConst().add(j);
											payer(j);
										}else{
											bat.setOccupe(true);
											bat.setPresent(j);
											payer(j);
										}
									}
								}
							}
						}
					}
				}
			}
			if(j.getOuvrier().getNombre() == 0){
				ordreTour.remove(j);
				fileFinPose.add(j);
			}
			if(i == ordreTour.size() - 1);
				i = 0;
		}
	}
	
	public void activationPorte(Joueur j){
		
	}

	public void activeComptoir(Joueur j){
		j.setNbDenier(3);
		j.getOuvrier().setNombre(1);
	}
	
	public void activeGuilde(Joueur j){
		//récupérer le clic et calculer la nouvelle position du baili en fonction de clic -3 a +3 places
		setPrevot(0);
		j.getOuvrier().setNombre(1);
	}
	
	public void activeJoute(Joueur j){
		j.setNbDenier(-1);
		Ressource ress = j.getRessource();
		if(ress.getTissu() > 2){
			ress.setTissu(-3);
		}
	}
	
	public ArrayList<Joueur> activeEcurie(Ecurie e){
		ArrayList<Joueur> ecurie = new ArrayList<Joueur>();
		ecurie.add(e.getPlace1());
		if(e.getPlace2() !=null){
			ecurie.add(e.getPlace2());
			if(e.getPlace3()!= null){
				ecurie.add(e.getPlace3());
			}
		}
		int i = 0;
		Joueur j;
		for(i=0;i<ordreTour.size();i++){
			j = ordreTour.get(i);
			if(!ecurie.contains(j));
				ecurie.add(j);
		}
		return ecurie;
	}
	/**
	 * 
	 * @param j
	 * 
	 * Il faudra mettre en place une boucle dans le main qui parcours le tableau des joueurs dans l'ordre de jeu et chacun son tour pourra déplacer le prevot.
	 */
	public void deplacementPrevot(Joueur j){
		int dep = 0;
		// on récupère par le biais du clic la nouvelle position du prévot et on calcule le nombre de case déplacé.
		setPrevot(dep);
		j.setNbDenier(dep);
		
		
	}
	
	
	
	
	
	public ArrayList<Joueur> getJoueur() {
		return joueur;
	}

	public void setJoueur(ArrayList<Joueur> joueur) {
		this.joueur = joueur;
	}
	public ArrayList<Joueur> getFileFinPose() {
		return fileFinPose;
	}
	public void setFileFinPose(ArrayList<Joueur> fileFinPose) {
		this.fileFinPose = fileFinPose;
	}
	public ArrayList<Joueur> getOrdreTour() {
		return ordreTour;
	}
	public void setOrdreTour(ArrayList<Joueur> ordreTour) {
		this.ordreTour = ordreTour;
	}
	public int getPrevot() {
		return prevot;
	}
	public void setPrevot(int prevot) {
		this.prevot = prevot;
	}
	public int getBaili() {
		return baili;
	}
	public void setBaili(int baili) {
		this.baili = baili;
	}


	
	
	

}

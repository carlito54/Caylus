package Modele;

import java.util.ArrayList;
import java.util.Iterator;

public class Jeu {
	
	private ArrayList<Joueur> joueur;
	private ArrayList<Joueur> fileFinPose;
	private ArrayList<Joueur> ordreTour;
	private int prevot;
	private int baili;
	private ArrayList<Batiment> listeBatiment;
	
	
	public Jeu(ArrayList<Joueur> fileFinPose, ArrayList<Joueur> ordreTour, int prevot, int baili, ArrayList<Batiment> listeBatiment) {
		super();
		this.fileFinPose = fileFinPose;
		this.ordreTour = ordreTour;
		this.prevot = prevot;
		this.baili = baili;
		this.listeBatiment = listeBatiment;
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
						j.getOuvrier().setNombre(-1);
						j.setNbDenier(-1);
					}else{
						if(bat.getProprio() != j && bat.getProprio() != null){
							bat.setOccupe(true);
							j.getOuvrier().setNombre(-1);
							j.setNbDenier(-(ordreTour.size()+1));
							bat.getProprio().setNbPrestige(1);
						}else{
							if( bat instanceof Auberge){
								((Auberge) bat).next(j);
							}else{
								if(bat instanceof Ecurie){
									((Ecurie) bat).next(j);
								}else{
									bat.setOccupe(true);
									j.getOuvrier().setNombre(-1);
									j.setNbDenier(-(ordreTour.size()+1));
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

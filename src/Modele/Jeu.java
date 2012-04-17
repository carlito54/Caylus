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
		for(i = 0;i<joueur.size();i++){
			joueur.get(i).setNbDenier(2);
		}
		i = 0;
		for(i = 1; i <= baili;i++){
			j = batimentOccupe(i);
			bat = getBatiment(i);
			if(j != null){
				if(bat != null){
				if(bat.getNom() == "Residence" && bat.getPresent() == bat.getProprio());
					j.setNbDenier(1);
				if(bat.getNom() == "Bibliotheque");
					j.setNbDenier(1);
				if(bat.getNom() == "Hotel");
				j.setNbDenier(2);	
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
		
		
		while (ordreTour.size() != fileFinPose.size()){
			// il faudra recuperer le batiment gr�ce au clique 
			bat = getBatiment(pos);
			j = ordreTour.get(i);
			if(bat.getNom() == "pont"){
				fileFinPose.add(j); 
				fin ++;
			}else{
				if(!bat.isOccupe()){
					bat.setOccupe(true);
					j.getOuvrier().setNombre(-1);
				}
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

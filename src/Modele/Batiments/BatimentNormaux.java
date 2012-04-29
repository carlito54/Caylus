package Modele.Batiments;

import Modele.Batiment;
import Modele.Joueur;
import Modele.Ressource;

public class BatimentNormaux extends Batiment{
	
	private Ressource cout;
	private int prestige;
	private int faveur;
	
	public BatimentNormaux(String nom,int pos, Ressource cout) {
		super(nom, pos);
		this.prestige = prestige;
		this.faveur=faveur;
	}
	
	public void appliquerEffet(Joueur j){
		
	}

	public int getPrestige() {
		return prestige;
	}

	public void setPrestige(int prestige) {
		this.prestige = prestige;
	}

	public int getFaveur() {
		return faveur;
	}

	public void setFaveur(int faveur) {
		this.faveur = faveur;
	}
	
	
	
	
	
	
}

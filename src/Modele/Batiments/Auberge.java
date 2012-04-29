package Modele.Batiments;

import Modele.Joueur;

public class Auberge extends BatimentSpeciaux{
	
	private Joueur place1;
	private Joueur place2;
	
	public Auberge(String nom, int pos) {
		super(nom, pos);
		this.place1 = null;
		this.place2 = null;
	}
	
	public void next(Joueur j){
		place2 = place1;
		place1 = j;
	}
	
	public void recuperer(Joueur j){
		if(place1 == j){
			place1 = null;
		}
	}

	public Joueur getPlace1() {
		return place1;
	}

	public void setPlace1(Joueur place1) {
		this.place1 = place1;
	}

	public Joueur getPlace2() {
		return place2;
	}

	public void setPlace2(Joueur place2) {
		this.place2 = place2;
	}
	
	
	
	

}

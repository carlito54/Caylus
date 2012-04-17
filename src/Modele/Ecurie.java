package Modele;

public class Ecurie extends BatimentSpeciaux{

	private Joueur place1;
	private Joueur place2;
	private Joueur place3;
	
	
	public Ecurie(Joueur place1, Joueur place2, Joueur place3) {
		super();
		this.place1 = place1;
		this.place2 = place2;
		this.place3 = place3;
	}
	
	public void next(Joueur j){
		place3 = place2;
		place2 = place1;
		place1 = j;
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

	public Joueur getPlace3() {
		return place3;
	}

	public void setPlace3(Joueur place3) {
		this.place3 = place3;
	}
	
	
	
}
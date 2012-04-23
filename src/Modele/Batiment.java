package Modele;

public class Batiment {

	private String nom;
	private Joueur proprio;
	private Joueur present;
	private boolean occupe;
	private int position;
	private Coordonnee[] coord;

	
	public Batiment(String nom, int position) {
		super();
		this.nom = nom;
		this.proprio = null;
		this.present = null;
		this.occupe = false;
		this.position = position;
		coord = new Coordonnee[36];
		coord[8] = new Coordonnee(140, 250);
		coord[9] = new Coordonnee(65, 275);
		coord[10] = new Coordonnee(42, 340);
		coord[11] = new Coordonnee(122, 355);
		coord[12] = new Coordonnee(205, 360);
		coord[13] = new Coordonnee(285, 365);
		coord[14] = new Coordonnee(365, 365);
		coord[15] = new Coordonnee(440, 370);
		coord[16] = new Coordonnee(512, 435);
		coord[17] = new Coordonnee(510, 435);
		coord[18] = new Coordonnee(435, 440);
		coord[19] = new Coordonnee(360, 443);
		coord[20] = new Coordonnee(285, 443);
		coord[21] = new Coordonnee(208, 445);
		coord[22] = new Coordonnee(130, 448);
		coord[23] = new Coordonnee(50, 457);
		coord[24] = new Coordonnee(60, 517);
		coord[25] = new Coordonnee(140, 527);
		coord[26] = new Coordonnee(220, 535);
		coord[27] = new Coordonnee(295, 540);
		coord[28] = new Coordonnee(371, 548);
		coord[29] = new Coordonnee(449, 542);
		coord[30] = new Coordonnee(526, 585);
		coord[31] = new Coordonnee(448, 624);
		coord[32] = new Coordonnee(370, 624);
		coord[33] = new Coordonnee(288, 625);
		coord[34] = new Coordonnee(205, 626);
		coord[35] = new Coordonnee(122, 626);
		



		
	}
	
	public String getNom() {
		return nom;
	}

	public Joueur getPresent() {
		return present;
	}

	public void setPresent(Joueur present) {
		this.present = present;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Joueur getProprio() {
		return proprio;
	}

	public void setProprio(Joueur proprio) {
		this.proprio = proprio;
	}

	public boolean isOccupe() {
		return occupe;
	}

	public void setOccupe(boolean occupe) {
		this.occupe = occupe;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}
	
	
	
	
}

package Modele;

public class Batiment {

	private String nom;
	private Joueur proprio;
	private boolean occupe;
	private String place;
	private int position;
	
	public Batiment(String nom, Joueur proprio, boolean occupe, int position) {
		super();
		this.nom = nom;
		this.proprio = proprio;
		this.occupe = occupe;
		this.position = position;
	}
	
	
	
	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getNom() {
		return nom;
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

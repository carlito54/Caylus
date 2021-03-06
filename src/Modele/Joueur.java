package Modele;

public class Joueur {

	private String nom;
	private int nbDenier;
	private int nbPrestige;
	private Ressource ressource;
	private Ouvrier ouvrier;
	
	public Joueur(String nom, int nbDenier, int nbPrestige, Ressource ressource) {
		super();
		this.nom = nom;
		this.nbDenier = nbDenier;
		this.nbPrestige = nbPrestige;
		this.ressource = ressource;
		this.ouvrier = new Ouvrier(6);
	}

	public Ouvrier getOuvrier() {
		return ouvrier;
	}

	public void setOuvrier(int i) {
		this.ouvrier.setNombre(i);
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getNbDenier() {
		return nbDenier;
	}

	public void setNbDenier(int nbDenier) {
		this.nbDenier += nbDenier;
	}

	public int getNbPrestige() {
		return nbPrestige;
	}

	public void setNbPrestige(int nbPrestige) {
		this.nbPrestige += nbPrestige;
	}

	public Ressource getRessource() {
		return ressource;
	}

	public void setRessource(Ressource ressource) {
		this.ressource = ressource;
	}
	
	
	
	
	
}

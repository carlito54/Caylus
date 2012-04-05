package Modele;

public class Joueur {

	private String nom;
	private int nbDenier;
	private int nbPrestige;
	private Ressource ressource;
	
	public Joueur(String nom, int nbDenier, int nbPrestige, Ressource ressource) {
		super();
		this.nom = nom;
		this.nbDenier = nbDenier;
		this.nbPrestige = nbPrestige;
		this.ressource = ressource;
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
		this.nbDenier = nbDenier;
	}

	public int getNbPrestige() {
		return nbPrestige;
	}

	public void setNbPrestige(int nbPrestige) {
		this.nbPrestige = nbPrestige;
	}

	public Ressource getRessource() {
		return ressource;
	}

	public void setRessource(Ressource ressource) {
		this.ressource = ressource;
	}
	
	
	
	
	
}

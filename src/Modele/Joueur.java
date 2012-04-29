package Modele;

public class Joueur {

	private String nom;
	private int nbDeniers;
	private int nbPrestige;
	private Ressource ressource;
	private Ouvrier ouvrier;
	
	public Joueur(String nom, int nbDeniers, int nbPrestige, Ressource ressource) {
		this.nom = nom;
		this.nbDeniers = nbDeniers;
		this.nbPrestige = nbPrestige;
		this.ressource = ressource;
		this.ouvrier = new Ouvrier(6);
	}

	public Ouvrier getOuvrier() {
		return ouvrier;
	}

	public void setOuvrier(Ouvrier ouvrier) {
		this.ouvrier = ouvrier;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getNbDenier() {
		return nbDeniers;
	}

	public void setNbDenier(int nbDenier) {
		this.nbDeniers += nbDenier;
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

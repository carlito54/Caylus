package Modele;

public class BatimentNormaux extends Batiment{
	
	private Ressource cout;
	private int prestige;
	private int coutD;
	private int faveur;
	
	public BatimentNormaux(String nom, Joueur prop, boolean occupe,int pos, int pre, Ressource cout,int coutD, int faveur) {
		super(nom, prop, occupe, pos);
		this.cout = cout;
		this.prestige = prestige;
		this.coutD = coutD;
		this.faveur=faveur;
	}
	
	public void appliquerEffet(Joueur j){
		
	}

	public Ressource getCout() {
		return cout;
	}

	public void setCout(Ressource cout) {
		this.cout = cout;
	}

	public int getPrestige() {
		return prestige;
	}

	public void setPrestige(int prestige) {
		this.prestige = prestige;
	}

	public int getCoutD() {
		return coutD;
	}

	public void setCoutD(int coutD) {
		this.coutD = coutD;
	}

	public int getFaveur() {
		return faveur;
	}

	public void setFaveur(int faveur) {
		this.faveur = faveur;
	}
	
	
	
	
	
	
}

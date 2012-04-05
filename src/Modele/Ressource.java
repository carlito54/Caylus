package Modele;

public class Ressource {

	private int bois;
	private int nourriture;
	private int pierre;
	private int tissu;
	private int or;
	
	public Ressource(int bois, int nourriture, int pierre, int tissu, int or) {
		super();
		this.bois = bois;
		this.nourriture = nourriture;
		this.pierre = pierre;
		this.tissu = tissu;
		this.or = or;
	}

	public int getBois() {
		return bois;
	}

	public void setBois(int bois) {
		this.bois = bois;
	}

	public int getNourriture() {
		return nourriture;
	}

	public void setNourriture(int nourriture) {
		this.nourriture = nourriture;
	}

	public int getPierre() {
		return pierre;
	}

	public void setPierre(int pierre) {
		this.pierre = pierre;
	}

	public int getTissu() {
		return tissu;
	}

	public void setTissu(int tissu) {
		this.tissu = tissu;
	}

	public int getOr() {
		return or;
	}

	public void setOr(int or) {
		this.or = or;
	}
	
	
	
	
}

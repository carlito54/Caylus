package Modele;

import Vue.ImagePanel;
import java.awt.Image;

public class Batiment extends ImagePanel {

	private String nom;
	private Joueur proprio;
	private Joueur present;
	private boolean occupe;
	private String place;
	private int position;
	

    public Batiment(Image image,String nom, int position) {
		super(image);
		this.nom = nom;
		this.proprio = null;
		this.present = null;
		this.occupe = false;
		this.position = position;
    }
    
    public Batiment(Image image, int w, int h) {
        super(image);
		this.nom = nom;
		this.proprio = null;
		this.present = null;
		this.occupe = false;
		this.position = position;

    }
	public Batiment(String nom, int position) {
		super("Images/ini.png");
		this.nom = nom;
		this.proprio = null;
		this.present = null;
		this.occupe = false;
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

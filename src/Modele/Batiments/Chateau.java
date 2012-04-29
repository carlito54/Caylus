package Modele.Batiments;

import Modele.Batiment;
import Modele.Joueur;
import java.util.ArrayList;
import java.util.HashMap;

public class Chateau extends Batiment{

	private ArrayList<Joueur> ordreConst;
	private int decompte;
	private HashMap<String, Joueur[]> construire;
	
	public Chateau(String nom, int position, int decom) {
		super(nom, position);
		this.decompte = decom;
		this.ordreConst = new ArrayList<Joueur>();
	}

	public ArrayList<Joueur> getOrdreConst() {
		return ordreConst;
	}

	public void setOrdreConst(ArrayList<Joueur> ordreConst) {
		this.ordreConst = ordreConst;
	}

	public int getDecompte() {
		return decompte;
	}

	public void setDecompte(int decompte) {
		this.decompte = decompte;
	}
	
	
	
	

}

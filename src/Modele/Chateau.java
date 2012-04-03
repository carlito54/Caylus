package Modele;

public class Chateau extends Batiment{

	private Joueur[] ordreConst;
	private int decompte;
	
	public Chateau(String nom, Joueur proprio, boolean occupe, int position, int decom, Joueur[] ordre) {
		super(nom, proprio, occupe, position);
		this.decompte = decom;
		this.ordreConst = ordre;
	}

	public Joueur[] getOrdreConst() {
		return ordreConst;
	}

	public void setOrdreConst(Joueur[] ordreConst) {
		this.ordreConst = ordreConst;
	}

	public int getDecompte() {
		return decompte;
	}

	public void setDecompte(int decompte) {
		this.decompte = decompte;
	}
	
	
	
	

}

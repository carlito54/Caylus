package Modele;

public class BatimentProduction extends BatimentNormaux{
	
	private Ressource gain;
	
	public BatimentProduction(String nom, int pos, Ressource cout) {
		super(nom, pos, cout);
		gain = gain();
		// TODO Auto-generated constructor stub
	}
	
	public Ressource gain(){
		Ressource gain;
		
		if(this.getNom() == "Bois1"){
			gain = new Ressource(1, 0, 0, 0, 0);
		}else{
			if(this.getNom() == "BoisNourriure1"){
				gain = new Ressource(1,1,0,0,0);
			}else{
				if(this.getNom() == "Pierre1"){
					gain = new Ressource(0,0,1,0,0);
				}else{
					if(this.getNom() == "Nourriture1"){
						gain = new Ressource(0,1,0,1,0);
					}else{
						gain = null;
					}
				}
			}
		}
		return gain;
		
	}

}

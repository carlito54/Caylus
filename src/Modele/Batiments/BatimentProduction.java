package Modele.Batiments;

import Modele.Ressource;

public class BatimentProduction extends BatimentNormaux {

    private Ressource gain;

    public BatimentProduction(String nom, int pos, Ressource cout) {
        super(nom, pos, cout);
        gain = gain();
    }

    public Ressource gain() {
        Ressource gain = new Ressource();

        if (this.getNom() == "Bois1") {
            gain.setRessource("Bois", 1);
        } else {
            if (this.getNom() == "BoisNourriure1") {
                gain.setRessource("Bois", 1);
                gain.setRessource("Nourriture", 1);
            } else {
                if (this.getNom() == "Pierre1") {
                    gain.setRessource("Pierre", 1);
                } else {
                    if (this.getNom() == "Nourriture1") {
                        gain.setRessource("Nourriture", 1);
                        gain.setRessource("Tissu", 1);
                    } else {
                        gain = null;
                    }
                }
            }
        }
        return gain;

    }
}

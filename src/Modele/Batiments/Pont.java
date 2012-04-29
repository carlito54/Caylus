package Modele.Batiments;

import Modele.Joueur;
import java.util.ArrayList;
import java.util.List;

public class Pont extends BatimentSpeciaux {

    private List<Joueur> places;

    public Pont(String nom, int position) {
        super(nom, position);
        places = new ArrayList<>();
    }
}

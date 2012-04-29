package Modele;

import java.util.HashMap;
import java.util.Map;

public class Ressource {

    private Map<String, Integer> ressources;
    private final String[] nomRessources = {"Bois", "Nourriture", "Pierre", "Tissu", "Or"};
    
    /**
     * Crée les ressources avec une quantité à 0
     */
    public Ressource() {
        ressources = new HashMap<>();
        for (String nom : nomRessources) {
            ressources.put(nom, 0);
        }
    }
    
    /**
     * Crée les ressources avec une quantité à 0
     */
    public Ressource(int[] qte) {
        ressources = new HashMap<>();
        for (int i = 0; i < qte.length; i++) {
            ressources.put(nomRessources[i], qte[i]);
        }
    }
    
    /**
     * Renvoie la quatité de la ressource dont le nom est en paramètre
     * 
     * @param nom nom de la ressource
     * @return quantité de la ressource nom
     */
    public int getRessource(String nom) {
        return ressources.get(nom);
    }
    
    /**
     * Modifie la quatité de la ressource nom
     * 
     * @param nom, nom de la ressource à modifier
     * @param qte, nouvelle quantité
     */
    public void setRessource(String nom, int qte) {
        ressources.put(nom, qte);
    }
}

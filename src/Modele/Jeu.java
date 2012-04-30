package Modele;

import Modele.Batiments.Auberge;
import Modele.Batiments.BatimentProduction;
import Modele.Batiments.Chateau;
import Modele.Batiments.Ecurie;
import Vue.ImagePanel;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.HashMap;

public class Jeu {

    private ArrayList<Joueur> joueurs;
    private ArrayList<Joueur> fileFinPose;
    private ArrayList<Joueur> ordreTour;
    private int prevot;
    private int baili;
    private Coordonnee[] coord;
    private Joueur j;
    private Auberge auberge;
    private HashMap<Integer, Batiment> listeBatiment;
    private ArrayList<ImagePanel> jtab;
    private boolean positionner = false;
    private int place;
    private int phase;
    private int tour;
    private boolean aDroit;

    public Jeu(int prevot, int baili, HashMap<Integer, Batiment> listeBatiment) {
        super();
        this.fileFinPose = new ArrayList<>();
        this.ordreTour = new ArrayList<>();
        this.prevot = prevot;
        this.baili = baili;
        this.listeBatiment = listeBatiment;
        this.auberge = new Auberge("Auberge", 7);
        this.tour = 0;
        coord = new Coordonnee[36];
        coord[8] = new Coordonnee(140, 250);
        coord[9] = new Coordonnee(65, 275);
        coord[10] = new Coordonnee(42, 340);
        coord[11] = new Coordonnee(122, 355);
        coord[12] = new Coordonnee(205, 360);
        coord[13] = new Coordonnee(285, 365);
        coord[14] = new Coordonnee(365, 365);
        coord[15] = new Coordonnee(440, 370);
        coord[16] = new Coordonnee(512, 435);
        coord[17] = new Coordonnee(510, 435);
        coord[18] = new Coordonnee(435, 440);
        coord[19] = new Coordonnee(360, 443);
        coord[20] = new Coordonnee(285, 443);
        coord[21] = new Coordonnee(208, 445);
        coord[22] = new Coordonnee(130, 448);
        coord[23] = new Coordonnee(50, 457);
        coord[24] = new Coordonnee(60, 517);
        coord[25] = new Coordonnee(140, 527);
        coord[26] = new Coordonnee(220, 535);
        coord[27] = new Coordonnee(295, 540);
        coord[28] = new Coordonnee(371, 548);
        coord[29] = new Coordonnee(449, 542);
        coord[30] = new Coordonnee(526, 585);
        coord[31] = new Coordonnee(448, 624);
        coord[32] = new Coordonnee(370, 624);
        coord[33] = new Coordonnee(288, 625);
        coord[34] = new Coordonnee(205, 626);
        coord[35] = new Coordonnee(122, 626);
    }

    public Batiment getBatiment(int pos) {
        int i = 0;
        boolean trouve = false;
        Batiment res = null;
        while (!trouve) {
            System.out.println(listeBatiment.get(i).getPosition());
            if (listeBatiment.get(i).getPosition() == pos || (i == listeBatiment.size())) {
                trouve = true;
                res = listeBatiment.get(i);
                System.out.println("ffffffff");
            } else {
                i++;
            }
        }
        return res;
    }

    public Joueur batimentOccupe(int pos) {
        Joueur res = null;
        Batiment bat = getBatiment(pos);
        System.out.println("lllllll");
        if (bat != null) {
            if (bat.isOccupe()) {
                res = bat.getPresent();
            }
        }
        return res;
    }

    public void getRevenu() {
        Joueur j = null;
        Batiment bat = null;
        int i = 0;
        int k = 0;
        for (i = 0; i < joueurs.size(); i++) {
            j = joueurs.get(i);
            j.setNbDenier(2);
            for (k = 1; k <= baili; k++) {
                //j = batimentOccupe(k);
                bat = listeBatiment.get(k);
                if (bat != null) {
                    if (bat != null) {
                        if (bat.getNom() == "Residence" && j == bat.getProprio());
                        j.setNbDenier(1);
                        if (bat.getNom() == "Bibliotheque" && j == bat.getProprio());
                        j.setNbDenier(1);
                        if (bat.getNom() == "Hotel" && j == bat.getProprio());
                        j.setNbDenier(2);
                    }
                }
            }
        }
        phase = 2;
    }

    public void payer(Joueur j) {
        j.getOuvrier().setNombre(-1);
        if (j == auberge.getPlace2()) {
            j.setNbDenier(-1);
        } else {
            j.setNbDenier(-(ordreTour.size() + 1));
        }
    }

    public int retournePosition(int x, int y) {
        int res = -1;
        for (int i = 8; i < 36; i++) {
            System.out.println("test de la fonction retourne posisition : ");
            System.out.println("i : " + i);
            System.out.println("x :" + x);
            System.out.println("y : " + y);
            System.out.println(coord[i].getX() + 10);
            System.out.println(coord[i].getX() + 80);
            System.out.println(coord[i].getY() + 80);
            System.out.println(coord[i].getY() + 30);
            if ((x <= coord[i].getX() + 80) && (x >= coord[i].getX() + 10) && (y <= coord[i].getY() + 80) && (y >= coord[i].getY() + 30)) {


                System.out.println("voil� le resusltat" + i);
                res = i;
                break;

            }
        }
        return res;
    }

    public Joueur placerOuvrier(int place) {
        int fin = 0;
        int pos = 0;
        boolean stop = false;
        Batiment bat;

        System.out.println("test2");
        bat = getBatiment(place);
        System.out.println(bat.getNom());
        System.out.println("-----------" + tour);
        j = ordreTour.get(tour);

        if (bat.getNom() == "pont") {
            System.out.println("test4");
            fileFinPose.add(j);
            if (fileFinPose.size() == ordreTour.size()) {
                phase++;
            }
            fin++;
        } else {
            if (!bat.isOccupe()) {
                aDroit = true;
                System.out.println("test555555");
                tour++;
                if (bat.getProprio() == j) {
                    System.out.println("test6");
                    bat.setOccupe(true);
                    payer(j);
                    bat.setPresent(j);
                } else {
                    if (bat.getProprio() != j && bat.getProprio() != null) {
                        System.out.println("test7");
                        bat.setOccupe(true);
                        j.setNbDenier(-1);
                        payer(j);
                        bat.setPresent(j);
                        bat.getProprio().setNbPrestige(1);
                    } else {
                        if (bat.getProprio() == null) {
                            System.out.println("test00000");
                            bat.setOccupe(true);
                            payer(j);
                            bat.setPresent(j);
                            //bat.getProprio().setNbPrestige(1);
                        } else {
                            if (bat instanceof Auberge) {
                                System.out.println("test8");
                                ((Auberge) bat).next(j);
                                payer(j);
                            } else {
                                if (bat instanceof Ecurie) {
                                    System.out.println("test9");
                                    ((Ecurie) bat).next(j);
                                    payer(j);
                                } else {
                                    if (bat instanceof Chateau) {
                                        System.out.println("test99");
                                        if (!((Chateau) bat).getOrdreConst().contains(j)) {
                                            ((Chateau) bat).getOrdreConst().add(j);
                                            payer(j);
                                        } else {
                                            System.out.println("test999");
                                            bat.setOccupe(true);
                                            bat.setPresent(j);
                                            payer(j);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                System.out.println("test3");
                if (j.getOuvrier().getNombre() == 0) {
                    //ordreTour.remove(j);
                    fileFinPose.add(j);
                    if (fileFinPose.size() == ordreTour.size()) {
                        phase = 3;
                    }
                }
                System.out.println(tour);
                System.out.println(ordreTour.size());
                System.out.println("test tour");
                if (tour == ordreTour.size()) {

                    tour = 0;
                }
            } else {
                aDroit = false;
            }
        }


        return j;
    }

    public void setOuvrier(int place, Joueur j, ArrayList<ImagePanel> jtab) {
        Image imagetest;
        ImagePanel ip = jtab.get(place);
        Coordonnee[] coord = getCoord();
        if (j.getNom() == "Joueur 1") {
            imagetest = Toolkit.getDefaultToolkit().getImage("ouvrierrouge.jpg");
        } else {
            if (j.getNom() == "Joueur 2") {
                imagetest = Toolkit.getDefaultToolkit().getImage("ouvrierbleu.jpg");
            } else {
                if (j.getNom() == "Joueur 3") {
                    imagetest = Toolkit.getDefaultToolkit().getImage("ouvrierorange.jpg");
                } else {
                    if (j.getNom() == "Joueur 4") {
                        imagetest = Toolkit.getDefaultToolkit().getImage("ouvriervert.jpg");
                    } else {
                        imagetest = Toolkit.getDefaultToolkit().getImage("ouvriernoir.jpg");
                    }
                }
            }
        }

        switch (place) {
            case 1:
                ip.setImage(imagetest, 15, 15);
                ip.setPreferredSize(new Dimension(60, 50));
                ip.setImage(imagetest);
                ip.setLayout(null);
                ip.setBounds(coord[1].getX(), coord[1].getY(), 70, 50);

                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            case 5:

                break;
            case 6:

                break;
            case 7:

                break;
            case 8:

                break;
            case 9:

                break;
            case 10:

                break;

            default:
                break;
        }
    }

    public void activationPorte(Joueur j) {
    }

    public void activeComptoir(Joueur j) {
        j.setNbDenier(3);
        j.getOuvrier().setNombre(1);
    }

    public void activeGuilde(Joueur j) {
        //r�cup�rer le clic et calculer la nouvelle position du baili en fonction de clic -3 a +3 places
        setPrevot(0);
        j.getOuvrier().setNombre(1);
    }

    public void activeJoute(Joueur j) {
        j.setNbDenier(-1);
        Ressource ress = j.getRessource();
        if (ress.getRessource("Tissu") > 2) {
            ress.setRessource("Tissu", -3);
        }
    }

    public ArrayList<Joueur> activeEcurie(Ecurie e) {
        ArrayList<Joueur> ecurie = new ArrayList<>();
        ecurie.add(e.getPlace1());
        if (e.getPlace2() != null) {
            ecurie.add(e.getPlace2());
            if (e.getPlace3() != null) {
                ecurie.add(e.getPlace3());
            }
        }
        Joueur j;
        for (int i = 0; i < ordreTour.size(); i++) {
            j = ordreTour.get(i);
            if (!ecurie.contains(j)); 
            ecurie.add(j);
        }
        return ecurie;
    }

    /**
     *
     * @param j
     *
     * Il faudra mettre en place une boucle dans le main qui parcours le tableau
     * des joueurs dans l'ordre de jeu et chacun son tour pourra d�placer le
     * prevot.
     */
    public void deplacementPrevot(Joueur j) {
        int dep = 0;
        // on r�cup�re par le biais du clic la nouvelle position du pr�vot et on calcule le nombre de case d�plac�.
        setPrevot(dep);
        j.setNbDenier(dep);


    }

    public ArrayList<Integer> batNeutreRamdom() {
        ArrayList<Integer> res = new ArrayList<Integer>();
        while (res.size() != 6) {
            int val = (int) (Math.random() * 6);
            if (!res.contains(val)) {
                res.add(val);
            }
        }
        return res;
    }

    public void ajoutNeutre(int i, int place) {
        switch (i) {
            case 0:
                listeBatiment.put(place, new BatimentProduction("Bois1", place, new Ressource()));
                break;
            case 1:
                listeBatiment.put(place, new BatimentProduction("Pierre1", place, new Ressource()));
                break;
            case 2:
                listeBatiment.put(place, new BatimentProduction("BoisNourriture1", place, new Ressource()));
                break;
            case 3:
                listeBatiment.put(place, new BatimentProduction("CharpentierNeutre", place, new Ressource()));
                break;
            case 4:
                listeBatiment.put(place, new BatimentProduction("Marche1", place, new Ressource()));
                break;
            case 5:
                listeBatiment.put(place, new BatimentProduction("Nourriture1", place, new Ressource()));

                break;
            default:
                break;
        }


    }

    public Coordonnee[] getCoord() {
        return coord;
    }

    public void setCoord(Coordonnee[] coord) {
        this.coord = coord;
    }

    public HashMap<Integer, Batiment> getListeBatiment() {
        return listeBatiment;
    }

    public void setListeBatiment(HashMap<Integer, Batiment> listeBatiment) {
        this.listeBatiment = listeBatiment;
    }

    public ArrayList<Joueur> getJoueur() {
        return joueurs;
    }

    public void setJoueur(ArrayList<Joueur> joueur) {
        this.joueurs = joueur;
    }

    public ArrayList<Joueur> getFileFinPose() {
        return fileFinPose;
    }

    public void setFileFinPose(ArrayList<Joueur> fileFinPose) {
        this.fileFinPose = fileFinPose;
    }

    public ArrayList<Joueur> getOrdreTour() {
        return ordreTour;
    }

    public void setOrdreTour(ArrayList<Joueur> ordreTour) {
        this.ordreTour = ordreTour;
    }

    public int getPrevot() {
        return prevot;
    }

    public void setPrevot(int prevot) {
        this.prevot = prevot;
    }

    public int getBaili() {
        return baili;
    }

    public void setBaili(int baili) {
        this.baili = baili;
    }

    public Joueur getJ() {
        return j;
    }

    public int getTour() {
        return tour;
    }

    public void setTour(int tour) {
        this.tour = tour;
    }

    public boolean isaDroit() {
        return aDroit;
    }

    public void setaDroit(boolean aDroit) {
        this.aDroit = aDroit;
    }

    public void setJ(Joueur j) {
        this.j = j;
    }

    public Auberge getAuberge() {
        return auberge;
    }

    public void setAuberge(Auberge auberge) {
        this.auberge = auberge;
    }

    public ArrayList<ImagePanel> getJtab() {
        return jtab;
    }

    public void setJtab(ArrayList<ImagePanel> jtab) {
        this.jtab = jtab;
    }

    boolean isPositionner() {
        return positionner;
    }

    public void setPositionner(boolean positionner) {
        this.positionner = positionner;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public int getPhase() {
        return phase;
    }

    public void setPhase(int phase) {
        this.phase = phase;
    }
}

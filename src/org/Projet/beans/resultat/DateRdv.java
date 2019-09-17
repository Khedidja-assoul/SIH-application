package org.Projet.beans.resultat;

import java.util.ArrayList;

public class DateRdv {
    private int id;
    private String date;
    private boolean etat;
    private ArrayList<HeureRdv> heures;

    public DateRdv(String date) {
        this.date = date;
        this.etat= true;
        this.heures = new ArrayList<>();
    }

    public DateRdv(String date, boolean etat) {
        this.date = date;
        this.etat = etat;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ArrayList<HeureRdv> getHeures() {
        return heures;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isEtat() {
        return etat;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }

    public void setHeures(ArrayList<HeureRdv> heures) {
        this.heures = heures;
    }

    public boolean estHeureBloquer(String heure)
    {
        for (int i = 0; i<heures.size();i++){
            if (heure.equals(heures.get(i).getHeure())) return true;
        }
        return false;
    }
}

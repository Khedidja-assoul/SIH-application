package org.Projet.beans.resultat;

import java.util.ArrayList;

public class Rdv {
    private int id ;
    private int idMedecin;
    private ArrayList<DateRdv> joursDisponibles;
    private ArrayList<DateRdv> joursPleins;
    private ArrayList<String> joursTravail;

    public Rdv(int idMedecin) {
        this.idMedecin = idMedecin;
        this.joursDisponibles = new ArrayList<>();
        this.joursPleins = new ArrayList<>();
        this.joursTravail = new ArrayList<>();
    }

    public ArrayList<DateRdv> calculJoursDispo(int idMedecin ){
        ArrayList<DateRdv> joursDisponible = new ArrayList<>();

        return joursDisponible;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdMedecin() {
        return idMedecin;
    }

    public void setIdMedecin(int idMedecin) {
        this.idMedecin = idMedecin;
    }

    public ArrayList<DateRdv> getJoursDisponibles() {
        return joursDisponibles;
    }

    public void setJoursDisponibles(ArrayList<DateRdv> joursDisponibles) {
        this.joursDisponibles = joursDisponibles;
    }

    public ArrayList<DateRdv> getJoursPleins() {
        return joursPleins;
    }

    public void setJoursPleins(ArrayList<DateRdv> joursPleins) {
        this.joursPleins = joursPleins;
    }

    public ArrayList<String> getJoursTravail() {
        return joursTravail;
    }

    public void setJoursTravail(ArrayList<String> joursTravail) {
        this.joursTravail = joursTravail;
    }


    public boolean estJourDisponible(String jour)
    {
        for (int i = 0; i<joursDisponibles.size();i++){
            if (jour.equals(joursDisponibles.get(i).getDate())) return true;
        }
        return false;
    }

    public boolean estJourPlein(String jour)
    {
        for (int i = 0; i<joursPleins.size();i++){
            if (jour.equals(joursPleins.get(i).getDate())) return true;
        }
        return false;
    }

    public DateRdv getJourDisponible(String jour)
    {
        for (int i = 0; i<joursDisponibles.size();i++){
            if (jour.equals(joursDisponibles.get(i).getDate())) return joursDisponibles.get(i);
        }
        return null;

    }



}

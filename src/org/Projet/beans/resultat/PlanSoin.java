package org.Projet.beans.resultat;

import java.util.ArrayList;

public class PlanSoin {
    private int id ;
    private int idConsultation ;
    private ArrayList <String> listeDesSoins ;

    public PlanSoin(int idConsultation) {
        this.idConsultation = idConsultation;
        listeDesSoins = new ArrayList<String>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdConsultation() {
        return idConsultation;
    }

    public void setIdConsultation(int idConsultation) {
        this.idConsultation = idConsultation;
    }

    public ArrayList<String> getListeDesSoins() {
        return listeDesSoins;
    }

    public void setListeDesSoins(ArrayList<String> listeDesSoins) {
        this.listeDesSoins = listeDesSoins;
    }

    public void ajoterSoin(String soin){
        this.listeDesSoins.add(soin);
    }
}

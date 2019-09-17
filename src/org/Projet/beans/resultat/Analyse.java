package org.Projet.beans.resultat;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

public class Analyse {
    private int id;
    private String nomOfficiel;
    private String abreviation;
    private String detailles;

    public Analyse(String nomOfficiel, String abreviation, String detailles) {
        this.nomOfficiel = nomOfficiel;
        this.abreviation = abreviation;
        this.detailles = detailles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomOfficiel() {
        return nomOfficiel;
    }

    public void setNomOfficiel(String nomOfficile) {
        this.nomOfficiel = nomOfficile;
    }

    public String getAbreviation() {
        return abreviation;
    }

    public void setAbreviation(String abreviation) {
        this.abreviation = abreviation;
    }

    public String getDetailles() {
        return detailles;
    }

    public void setDetailes(String detailes) {
        this.detailles = detailes;
    }
}


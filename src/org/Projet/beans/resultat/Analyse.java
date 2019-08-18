package org.Projet.beans.resultat;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

public class Analyse {
    private int id;
    private String nomOfficile;
    private String abreviation;
    private String detailles;

    public Analyse(String nomOfficile, String abreviation, String detailles) {
        this.nomOfficile = nomOfficile;
        this.abreviation = abreviation;
        this.detailles = detailles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomOfficile() {
        return nomOfficile;
    }

    public void setNomOfficile(String nomOfficile) {
        this.nomOfficile = nomOfficile;
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


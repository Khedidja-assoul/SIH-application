package org.Projet.beans.resultat;

public class Analyse {
    private int id ;
    private String nomOfficile;
    private String abreviation;
    private String detailes;

    public Analyse(String nomOfficile, String abreviation, String detailes) {
        this.nomOfficile = nomOfficile;
        this.abreviation = abreviation;
        this.detailes = detailes;
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

    public String getDetailes() {
        return detailes;
    }

    public void setDetailes(String detailes) {
        this.detailes = detailes;
    }
}


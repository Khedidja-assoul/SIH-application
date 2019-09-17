package org.Projet.beans.etablisement;

import org.Projet.beans.personnel.personnelDeSante.uniteSoins.Medecin;

import java.util.ArrayList;

public class Service {
    private int id;
    private String nom;
    private int etage;
    private String aile;
    private int idChefService;
    private ArrayList<Integer> listeMedecin;

    public Service(String nom, int etage, String aile, int idChefService) {
        this.nom = nom;
        this.etage = etage;
        this.aile = aile;
        this.idChefService = idChefService;
        this.listeMedecin = new ArrayList<>();
    }

    public Service(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getIdChefService() {
        return idChefService;
    }

    public void setIdChefService(int idChefService) {
        this.idChefService = idChefService;
    }

    public ArrayList<Integer> getListeMedecin() {
        return listeMedecin;
    }

    public void setListeMedecin(ArrayList<Integer> listeMedecin) {
        this.listeMedecin = listeMedecin;
    }

    public int getEtage() {
        return etage;
    }

    public void setEtage(int etage) {
        this.etage = etage;
    }

    public String getAile() {
        return aile;
    }

    public void setAile(String aile) {
        this.aile = aile;
    }

    @Override
    public String toString() {
        return id +" "+ nom;
    }
}

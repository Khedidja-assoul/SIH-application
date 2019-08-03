package org.Projet.beans;

public class Utilisateur {
    private String  nomUtilisateur;
    private String motPasse;
    private String typeUtilisateur;
    private int id;

    public Utilisateur(String nomUtilisateur, String motPasse, String typeUtilisateur, int id) {
        this.nomUtilisateur = nomUtilisateur;
        this.motPasse = motPasse;
        this.typeUtilisateur = typeUtilisateur;
        this.id = id;
    }

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }

    public String getMotPasse() {
        return motPasse;
    }

    public void setMotPasse(String motPasse) {
        this.motPasse = motPasse;
    }

    public String getTypeUtilisateur() {
        return typeUtilisateur;
    }

    public void setTypeUtilisateur(String typeUtilisateur) {
        this.typeUtilisateur = typeUtilisateur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return nomUtilisateur+" "+motPasse+" "+typeUtilisateur+" "+id;
    }
}

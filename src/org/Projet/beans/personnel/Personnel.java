package org.Projet.beans.personnel;

import org.Projet.beans.Authentifiable;

public abstract class Personnel extends Authentifiable implements Comparable<Personnel> {
    private int matricule ;
    private String nom ;
    private String prenom ;
    private int nbHeures;
    private String dateNaissance;
    private String email ;
    private String tel ;


    public Personnel( String nom, String prenom, int nbHeures, String dateNaissance, String email, String tel) {
        this.nom = nom;
        this.prenom = prenom;
        this.nbHeures = nbHeures;
        this.dateNaissance = dateNaissance;
        this.email = email;
        this.tel = tel;
    }

    public int getNbHeures() {
        return nbHeures;
    }

    public void setNbHeures(int nbHeures) {
        this.nbHeures = nbHeures;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public void setMatricule(int matricule) {
        this.matricule = matricule;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getMatricule() {
        return matricule;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public String getTel() {
        return tel;
    }

    public int compareTo(Personnel o) {
        return (nom+prenom+tel).compareTo(o.getNom()+getPrenom()+getTel());
    }

    @Override
    public String toString() {
        return matricule+" "+ nom + " " + prenom;
    }
}

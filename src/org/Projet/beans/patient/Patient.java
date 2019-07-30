package org.Projet.beans.patient;

import org.Projet.beans.etablisement.Chambre;

public class Patient {
    private int matricule;
    private String nom;
    private String prenom;
    private String dateNaissance;
    private String adresse;
    private String tel;
    private String email;

    public Patient(String nom, String prenom, String dateNaissance, String adresse, String tel, String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.adresse = adresse;
        this.tel = tel;
        this.email = email;
    }

    public int getMatricule() {
        return matricule;
    }

    public void setMatricule(int matricule) {
        this.matricule = matricule;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void demanderRdv(){};//demander un rdv la fonction retourne les dates libres
    public void consulterDossierPatient(){};



}

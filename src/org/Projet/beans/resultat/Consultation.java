package org.Projet.beans.resultat;

public class Consultation {
    private int id;
    private int idMedecin;
    private int idPatient;
    private String date;
    private String heure;
    private String motif;

    public Consultation(int idMedecin, int idPatient, String date, String heure, String motif) {
        this.idMedecin = idMedecin;
        this.idPatient = idPatient;
        this.date = date;
        this.heure = heure;
        this.motif = motif;
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

    public int getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(int idPatient) {
        this.idPatient = idPatient;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }
}

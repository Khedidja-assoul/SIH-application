package org.Projet.beans.resultat;

public class HeureRdv {
    private int id;
    private String heure;
    private int idPatient;
    private int idAgent;
    private int idDate;

    public HeureRdv(int idPatient,int idAgent, String heure) {
        this.idPatient = idPatient;
        this.idAgent= idAgent;
        this.heure = heure;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdAgent() {
        return idAgent;
    }

    public void setIdAgent(int idAgent) {
        this.idAgent = idAgent;
    }

    public int getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(int idPatient) {
        this.idPatient = idPatient;
    }

    public int getIdDate() {
        return idDate;
    }

    public void setIdDate(int idDate) {
        this.idDate = idDate;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }
}

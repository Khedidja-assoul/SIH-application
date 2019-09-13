package org.Projet.beans.resultat;


import java.util.ArrayList;

public class ResultatBiologique {
    private int id;
    private int idActe;
    private int idAgentLaboratoire;
    private String date;
    private String heure;
    private ArrayList<ResultatAnalyse> resultatAnalyses;

    public ResultatBiologique(int idActe, int idAgentLaboratoire, String date, String heure) {
        this.idActe = idActe;
        this.idAgentLaboratoire = idAgentLaboratoire;
        this.date = date;
        this.heure = heure;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdActe() {
        return idActe;
    }

    public void setIdActe(int idActe) {
        this.idActe = idActe;
    }

    public int getIdAgentLaboratoire() {
        return idAgentLaboratoire;
    }

    public void setIdAgentLaboratoire(int idAgentLaboratoire) {
        this.idAgentLaboratoire = idAgentLaboratoire;
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

    public ArrayList<ResultatAnalyse> getResultatAnalyses() {
        return resultatAnalyses;
    }

    public void setResultatAnalyses(ArrayList<ResultatAnalyse> resultatAnalyses) {
        this.resultatAnalyses = resultatAnalyses;
    }
}

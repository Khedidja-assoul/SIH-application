package org.Projet.beans.resultat;

public class ResultatAnalyse {

    private int id;
    private int idAnalyse;
    private String detaille;

    public ResultatAnalyse(int idAnalyse, String detaille) {
        this.idAnalyse = idAnalyse;
        this.detaille = detaille;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdAnalyse() {
        return idAnalyse;
    }

    public void setIdAnalyse(int idAnalyse) {
        this.idAnalyse = idAnalyse;
    }

    public String getDetaille() {
        return detaille;
    }

    public void setDetaille(String detaille) {
        this.detaille = detaille;
    }
}

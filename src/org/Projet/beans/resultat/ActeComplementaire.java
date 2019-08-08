package org.Projet.beans.resultat;

public class ActeComplementaire {
    private int idDemande;
    private int idMedecin;
    private int idPatient;
    private String dateDemande;
    private int idResultat;

    public ActeComplementaire(int idMedecin, int idPatient,String dateDemande) {
        this.idMedecin = idMedecin;
        this.idPatient = idPatient;
        this.dateDemande = dateDemande;
    }

    public int getIdDemande() {
        return idDemande;
    }

    public void setIdDemande(int idDemande) {
        this.idDemande = idDemande;
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


    public String getDateDemande() {
        return dateDemande;
    }

    public void setDateDemande(String dateDemande) {
        this.dateDemande = dateDemande;
    }

    public int getIdResultat() {
        return idResultat;
    }

    public void setIdResultat(int idResultat) {
        this.idResultat = idResultat;
    }
}

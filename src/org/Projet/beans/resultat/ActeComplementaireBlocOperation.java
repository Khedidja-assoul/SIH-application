package org.Projet.beans.resultat;

public class ActeComplementaireBlocOperation extends ActeComplementaire {

    private String datePrevue ;

    public ActeComplementaireBlocOperation(int idMedecin, int idPatient, String dateDemande,String datePrevue ) {
        super(idMedecin, idPatient, dateDemande);
        this.datePrevue = datePrevue;
    }

    public String getDatePrevue() {
        return datePrevue;
    }

    public void setDatePrevue(String datePrevue) {
        this.datePrevue = datePrevue;
    }
}

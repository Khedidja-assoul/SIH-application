package org.Projet.beans.resultat;

public class ActeComplementaireBlocOperation extends ActeComplementaire {

    private String datePrevue ;

    public ActeComplementaireBlocOperation(int idConsultation,String datePrevue ) {
        super(idConsultation);
        this.datePrevue = datePrevue;
    }

    public String getDatePrevue() {
        return datePrevue;
    }

    public void setDatePrevue(String datePrevue) {
        this.datePrevue = datePrevue;
    }
}

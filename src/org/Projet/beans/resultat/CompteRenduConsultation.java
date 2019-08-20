package org.Projet.beans.resultat;

public class CompteRenduConsultation extends CompteRendu {

    private int idConsultation;

    public CompteRenduConsultation(String detaille, int idConsultation) {
        super(detaille);
        this.idConsultation = idConsultation;
    }

    public int getIdConsultation() {
        return idConsultation;
    }

    public void setIdConsultation(int idConsultation) {
        this.idConsultation = idConsultation;
    }
}

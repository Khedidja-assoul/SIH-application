package org.Projet.beans.resultat;

public  abstract class ActeComplementaire {
    private int id;
    private int idConsultation;
    private int idResultat;

    public ActeComplementaire(int idConsultation) {
        this.idConsultation = idConsultation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdConsultation() {
        return idConsultation;
    }

    public void setIdConsultation(int idConsultation) {
        this.idConsultation = idConsultation;
    }

    public int getIdResultat() {
        return idResultat;
    }

    public void setIdResultat(int idResultat) {
        this.idResultat = idResultat;
    }
}

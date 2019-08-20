package org.Projet.beans.resultat;

import org.Projet.beans.personnel.personnelDeSante.uniteSoins.Medecin;

public class Presecription {
    private int id ;
    private int idConsultation;
    private String typePrescription;
    private String deatille;

    public Presecription(int idConsultation, String typePrescription, String deatille) {
        this.idConsultation = idConsultation;
        this.typePrescription = typePrescription;
        this.deatille = deatille;
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

    public String getTypePrescription() {
        return typePrescription;
    }

    public void setTypePrescription(String typePrescription) {
        this.typePrescription = typePrescription;
    }

    public String getDeatille() {
        return deatille;
    }

    public void setDeatille(String deatille) {
        this.deatille = deatille;
    }
}

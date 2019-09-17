package org.Projet.beans.resultat;

import java.util.ArrayList;
import java.util.HashSet;

public class ActeComplementaireLaboratoire extends ActeComplementaire {
    private int idAnalyse;


    public ActeComplementaireLaboratoire(int idConsultation, int idAnalyse) {
        super(idConsultation);
        this.idAnalyse = idAnalyse;
    }

    public int getIdAnalyse() {
        return idAnalyse;
    }

    public void setIdAnalyse(int idAnalyse) {
        this.idAnalyse = idAnalyse;
    }
}

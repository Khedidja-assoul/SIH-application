package org.Projet.beans.resultat;

import java.util.ArrayList;
import java.util.HashSet;

public class ActeComplementaireLaboratoire extends ActeComplementaire {
    private ArrayList<Integer> listeTypeAnalyse;

    public ActeComplementaireLaboratoire(int idConsultation){
        super(idConsultation);
        listeTypeAnalyse = new ArrayList<>();
    }

    public ArrayList<Integer> getListeTypeAnalyse() {
        return listeTypeAnalyse;
    }

    public void setListeTypeAnalyse(ArrayList<Integer> listeTypeAnalyse) {
        this.listeTypeAnalyse = listeTypeAnalyse;
    }

    public void ajouterAnalyse(int id){
        listeTypeAnalyse.add(id);
    }


}

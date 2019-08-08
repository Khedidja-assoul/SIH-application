package org.Projet.beans.resultat;

import java.util.HashSet;

public class ActeComplementaireLaboratoire extends ActeComplementaire {
    private HashSet<Analyse> listeTypeAnalyse;

    public ActeComplementaireLaboratoire(int idMedecin, int idPatient,String dateDemande){
        super(idMedecin,idPatient,dateDemande);
        listeTypeAnalyse = new HashSet<>();

    }
}

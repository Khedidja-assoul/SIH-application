package org.Projet.beans.resultat;

import org.Projet.beans.personnel.personnelDeSante.medicoTechenique.AgentLaboratoire;
import org.Projet.beans.personnel.personnelDeSante.uniteSoins.Medecin;

public class ResultatBiologique {
    private int id;
    private String text;
    private String date;
    private Medecin medecinDemandeur;
    private AgentLaboratoire agentLaboratoire;
}

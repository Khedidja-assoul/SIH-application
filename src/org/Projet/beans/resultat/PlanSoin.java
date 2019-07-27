package org.Projet.beans.resultat;

import org.Projet.beans.personnel.personnelDeSante.uniteSoins.Infirmier;
import org.Projet.beans.personnel.personnelDeSante.uniteSoins.Medecin;

public class PlanSoin {
    private int id ;
    private String protocole;
    private String date;
    private Medecin medecinDemandeur;
    private Infirmier infermierAssigne;
}

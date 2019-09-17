package org.Projet.consumer.InterfaceDao;

import org.Projet.beans.personnel.personnelDeSante.uniteSoins.Medecin;
import org.Projet.beans.resultat.Consultation;
import org.Projet.beans.resultat.PlanSoin;

import java.util.ArrayList;

public interface InfirmierDao {

    ArrayList<PlanSoin> getPlansSoins(int idConsultation);
    ArrayList<Consultation> afficherPlansDeSoin(int idPatient);
    Medecin getMedecin(int id);
}

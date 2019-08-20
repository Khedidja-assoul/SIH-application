package org.Projet.consumer.InterfaceDao;

import org.Projet.beans.patient.Patient;
import org.Projet.beans.resultat.*;

import java.util.ArrayList;

public interface MedecinDao {

    Analyse getAnalyse(String nom);
    Patient getPatient(String nom, String prenom);
    int ajouter(Consultation consultation);
    void ajouter(ActeComplementaireLaboratoire acteLAbo);
    void ajouter(Presecription presecription);
    void ajouter(CompteRenduConsultation compteRendu);
    void ajouter(PlanSoin planSoin);
    ArrayList<Consultation> afficher(int idMedecin);
    Patient getPatient(int id);
    Consultation getConsutation(int id);
    ArrayList<Presecription> getPrescription(int idConsultation);
    ArrayList<PlanSoin> getPlanSoin(int idConsultation);
    ArrayList<CompteRenduConsultation> getCompteRendu(int idConsultation);
    ArrayList<ActeComplementaireLaboratoire> getActeComplementaireLaboratoire(int idConsultation);
}

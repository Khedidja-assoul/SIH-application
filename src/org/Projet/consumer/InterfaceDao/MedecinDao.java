package org.Projet.consumer.InterfaceDao;

import org.Projet.beans.patient.Patient;
import org.Projet.beans.resultat.ActeComplementaireLaboratoire;
import org.Projet.beans.resultat.Analyse;
import org.Projet.beans.resultat.Consultation;

public interface MedecinDao {

    Analyse getAnalyse(String nom);
    Patient getPatient(String nom, String prenom);
    int ajouter(Consultation consultation);
    void ajouter(ActeComplementaireLaboratoire acteLAbo);
}

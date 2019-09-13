package org.Projet.consumer.InterfaceDao;

import org.Projet.beans.patient.Patient;
import org.Projet.beans.personnel.personnelDeSante.uniteSoins.Medecin;
import org.Projet.beans.resultat.ActeComplementaireLaboratoire;
import org.Projet.beans.resultat.Analyse;
import org.Projet.beans.resultat.Consultation;
import org.Projet.beans.resultat.ResultatBiologique;

import java.util.ArrayList;

public interface AgentLaboratoireDao {
     ArrayList<Analyse> afficherAnalyse();
     ArrayList<ActeComplementaireLaboratoire> afficherDemandeActe();
     Consultation getConsultation(int id);
     Patient getPatient(int id);
     Medecin getMedecin(int id);
    Analyse getAnalyse(int idAnalyse);
    ActeComplementaireLaboratoire getDemandeActe(int idActe);
    void validerActe(ResultatBiologique resultatBiologique);

}

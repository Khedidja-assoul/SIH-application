package org.Projet.consumer.InterfaceDao;

import org.Projet.beans.patient.Patient;
import org.Projet.beans.personnel.personnelDeSante.uniteSoins.Medecin;
import org.Projet.beans.resultat.*;

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
     ResultatBiologique getResultatBiologique(int idActe);
     ArrayList<ActeComplementaireLaboratoire> afficherActeLaboEtablis();

}

package org.Projet.consumer.InterfaceDao;

import org.Projet.beans.Utilisateur;
import org.Projet.beans.etablisement.Service;
import org.Projet.beans.patient.Patient;
import org.Projet.beans.personnel.personnelDeSante.uniteSoins.Medecin;
import org.Projet.beans.resultat.DateRdv;
import org.Projet.beans.resultat.HeureRdv;
import org.Projet.beans.resultat.Rdv;
import org.Projet.exceptions.InformationDupliquerExeption;

import java.util.ArrayList;

public interface AgentParamedicalDao {

    int ajouter(Patient patient);
    void ajouter(Utilisateur compte);
    Rdv getRendezVous(int idMedecin);
    void ajouterDate(DateRdv dateRdv , int idRdv);
    void ajouterHeureDateDispo(HeureRdv heureRdv) throws InformationDupliquerExeption;
    Patient getPatient(int id);
    Patient getPatient(String nom, String prenom);
    Patient getPatient(int id, String nom, String prenom);
    ArrayList<Service> getServices();
    ArrayList<Medecin> getMedecinsService(int idService);

}

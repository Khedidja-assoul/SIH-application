package org.Projet.consumer.InterfaceDao;

import org.Projet.beans.Utilisateur;
import org.Projet.beans.patient.Patient;

public interface AgentParamedicalDao {

    int ajouter(Patient patient);
    void ajouter(Utilisateur compte);
}

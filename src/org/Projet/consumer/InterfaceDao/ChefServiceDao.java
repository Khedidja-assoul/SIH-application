package org.Projet.consumer.InterfaceDao;

import org.Projet.beans.etablisement.Service;
import org.Projet.beans.personnel.personnelDeSante.uniteSoins.Medecin;
import org.Projet.beans.resultat.Rdv;

import java.util.ArrayList;

public interface ChefServiceDao {

    Medecin getMedecin(int id);
    Service getService(int idService);
    void ajouter(int idService, Rdv rdv);
    ArrayList<Medecin> listeMedecinsService(int idService);
    void definirJoursTravailMedecin(ArrayList<String> joursTravail, int idMedecin);
}

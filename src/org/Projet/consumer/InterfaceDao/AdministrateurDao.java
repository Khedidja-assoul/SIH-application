package org.Projet.consumer.InterfaceDao;


import org.Projet.beans.Utilisateur;
import org.Projet.beans.etablisement.Chambre;
import org.Projet.beans.personnel.Personnel;
import org.Projet.beans.personnel.personnelDeSante.uniteSoins.Infirmier;
import org.Projet.beans.personnel.personnelDeSante.uniteSoins.Medecin;

import java.util.ArrayList;

public interface AdministrateurDao {

    ArrayList<Personnel> affichierPersonnels(String typePersonnel);
    int ajouter(Personnel personnel, String typePersonnel);
    void ajouter(Utilisateur compte);
    void ajouter(Chambre chambre);

}

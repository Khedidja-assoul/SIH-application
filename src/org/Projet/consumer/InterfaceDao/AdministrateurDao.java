package org.Projet.consumer.InterfaceDao;


import org.Projet.beans.personnel.Personnel;
import org.Projet.beans.personnel.personnelDeSante.uniteSoins.Infirmier;
import org.Projet.beans.personnel.personnelDeSante.uniteSoins.Medecin;

import java.util.ArrayList;

public interface AdministrateurDao {

    ArrayList<Personnel> affichierPersonnels(String typePersonnel);
    void ajouter(Personnel personnel, String typePersonnel);

}

package org.Projet.consumer.InterfaceDao;


import org.Projet.beans.Administrateur;
import org.Projet.beans.Utilisateur;
import org.Projet.beans.etablisement.Chambre;
import org.Projet.beans.etablisement.Service;
import org.Projet.beans.personnel.Personnel;
import org.Projet.beans.personnel.personnelDeSante.uniteSoins.Infirmier;
import org.Projet.beans.personnel.personnelDeSante.uniteSoins.Medecin;
import org.Projet.exceptions.InformationsErroneeException;

import java.util.ArrayList;

public interface AdministrateurDao {

    ArrayList<Personnel> affichierPersonnels(String typePersonnel);
    int ajouter(Personnel personnel, String typePersonnel);
    void ajouter(Utilisateur compte);
    void ajouter(Chambre chambre);
    void ajouter(Administrateur administrateur);
    Administrateur getCompte(String nomUtilisateur, String motPasse) throws InformationsErroneeException;
    void supprimer(String typePersonnel, int idPersonnel);
    void supprimer(int idUtilisateur);
    void modifier(String typePersonnel,Personnel personnel);
    Medecin getMedecin(int id);
    void ajouter(Service service);

}

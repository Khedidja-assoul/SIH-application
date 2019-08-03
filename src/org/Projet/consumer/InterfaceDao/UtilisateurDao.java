package org.Projet.consumer.InterfaceDao;

import org.Projet.beans.Authentifiable;
import org.Projet.beans.personnel.Personnel;
import org.Projet.exceptions.InformationsErroneeException;

public interface UtilisateurDao {

    int connexion(String id, String motPasse, String typeUtilisateur) throws InformationsErroneeException;
    Authentifiable getCompte(String nomUtilisateur, String motPasse, String typeUtilisateur) throws InformationsErroneeException ;
}

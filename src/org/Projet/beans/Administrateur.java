package org.Projet.beans;

import org.Projet.beans.etablisement.Service;
import org.Projet.beans.personnel.agentParamedicale.AgentParamedicale;
import org.Projet.beans.personnel.personnelDeSante.medicoTechenique.AgentBlocOperatoire;
import org.Projet.beans.personnel.personnelDeSante.medicoTechenique.AgentLaboratoire;
import org.Projet.beans.personnel.personnelDeSante.uniteSoins.Infirmier;
import org.Projet.beans.personnel.personnelDeSante.uniteSoins.Medecin;

public class Administrateur {
    private int id;
    private String motDePasse;
    private String nom;
    private String prenom;



    public void ajouterChefService(Medecin medecin, Service service){
        medecin.setEstChefService(true);
        medecin.setService(service);
        //TODO : travailler avec le matricule du medecin est le nom du service au lieu des objets
    }


}

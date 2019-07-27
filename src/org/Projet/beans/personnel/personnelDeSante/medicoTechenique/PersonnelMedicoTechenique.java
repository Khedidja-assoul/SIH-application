package org.Projet.beans.personnel.personnelDeSante.medicoTechenique;

import org.Projet.beans.personnel.Personnel;

public abstract class PersonnelMedicoTechenique extends Personnel {

    public PersonnelMedicoTechenique(String nom, String prenom,int nbHeures, String dateNaissance, String email, String tel) {
       super(nom,prenom,nbHeures, dateNaissance, email, tel);
    }

    public void consulterListeActes(){};//visualiser les actes deja etablis
    public void consulterListeDemandeActes(){};//visualiser les actes en demande
}

package org.Projet.beans.personnel.personnelDeSante.uniteSoins;

import org.Projet.beans.personnel.Personnel;

public abstract class UniteSoins extends Personnel {
    public UniteSoins( String nom, String prenom, int nbHeures, String dateNaissance,String email, String tel) {
        super(nom,prenom,nbHeures, dateNaissance, email, tel);
    }
}

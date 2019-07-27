package org.Projet.beans.personnel.personnelDeSante.uniteSoins;

import org.Projet.beans.personnel.Personnel;

public class Infirmier extends UniteSoins {

    public Infirmier(String nom, String prenom,int nbHeures, String dateNaissance, String email, String tel) {
        super(nom,prenom,nbHeures, dateNaissance, email, tel);
      }

    public void consulterListePlanSoins(){};//visualiser la liste des plans de soins a etablir
    public void consulterPlanSoins(){};// visualiser la liste des plans de soins deja etablis
    public void validerPlanSoins(){};// remplire et valider un plan de soins

}

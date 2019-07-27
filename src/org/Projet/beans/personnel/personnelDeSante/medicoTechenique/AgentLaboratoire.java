package org.Projet.beans.personnel.personnelDeSante.medicoTechenique;

public class AgentLaboratoire extends PersonnelMedicoTechenique {

   public AgentLaboratoire(String nom, String prenom,int nbHeures, String dateNaissance, String email, String tel) {
    super(nom,prenom,nbHeures, dateNaissance, email, tel);
  }

  public void etablireActeRdv(){}; //permet d'etablire un rendez a un Patient vous des analyses medicale
  public void validerActe(){}; //permet d'etablir un acte (saisie des resultat de l'acte)
                               // et de le valider (pour qu'il soit transmis au demandeur )

}

package org.Projet.beans.personnel.agentParamedicale;

import org.Projet.beans.personnel.Personnel;

public class AgentParamedicale extends Personnel {


    public AgentParamedicale(String nom, String prenom,int nbHeures, String dateNaissance, String email, String tel) {
        super( nom, prenom,nbHeures,dateNaissance, email, tel);
    }

    public void creeDossierPatient(){}; //permet d'inscrire un patient
    public void supprimerDossierPatient(){};//permet de retirer un patient
    public void etablirRdv(){};//permet d'etablir un rdv pour un patient chez un Medecin
    public void consulterListeRdv(){};//visualiser la liste des rdv
    public void validerFacture(){}; // permet de valider une facture d'un patient donne (dire que la facture est reglee)


}

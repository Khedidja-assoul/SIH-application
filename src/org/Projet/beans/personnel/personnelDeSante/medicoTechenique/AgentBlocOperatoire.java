package org.Projet.beans.personnel.personnelDeSante.medicoTechenique;

import org.Projet.beans.personnel.Personnel;

public class AgentBlocOperatoire extends PersonnelMedicoTechenique {

    public AgentBlocOperatoire(String nom, String prenom,int nbHeures, String dateNaissance, String email, String tel) {
        super(nom,prenom,nbHeures, dateNaissance, email, tel);
    }

    public void consulterEtatBlocOperatoire(){};//pour voir l'etat des bloc
    private void allouerPersonnelMedicale(){};//fonction utiliser dans reserver bloc
    private void allouerPatient(){};//fonction utiliser dans reserver bloc
    public void reserverBloc(){};//fonction qui nous permet de reserver un bloc
                                    // pour une intervention d'un patient donne avec du Personnel medicale assigne
    public void libererBloc(){};//liberer un bloc apres la fin de l'intervention
}

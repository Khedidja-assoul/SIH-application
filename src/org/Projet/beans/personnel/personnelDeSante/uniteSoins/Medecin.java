package org.Projet.beans.personnel.personnelDeSante.uniteSoins;

import org.Projet.beans.etablisement.Service;
import org.Projet.beans.personnel.Personnel;

import java.util.ArrayList;


public class Medecin extends UniteSoins {

    private String grade;
    private String specialite; //TODO: declarer enumeration de specialite
    private boolean estChefService = false;
    private Service service = null;



    public Medecin(String nom, String prenom,int nbHeures, String dateNaissance, String email, String tel, String grade,String specialite) {
        super(nom,prenom,nbHeures, dateNaissance, email, tel);
        this.grade = grade;
        this.specialite = specialite;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public boolean isEstChefService() {
        return estChefService;
    }

    public void setEstChefService(boolean estChefService) {
        this.estChefService = estChefService;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public void consulterListeActesDemander(){};// voir la liste des demande d'acte du Medecin
    public  void consulterListeActesEtablis(){};//voir les actes etablis
    public void consulterActeDiagnositic(){};//voir la liste des actes diagnostic
    public void consulterListeRdv(){};//voir la liste des rdv du Medecin
    public void etablirCompteRendu(){};//rediger un compte rendu
    public void etablirPrescription(){};//rediger une prescription
    public void etablirDemandeActeComp(){};//rediger une demande d'acte complementaire
    public void affecterPlanSoins(){};// affecter un plan de soins a un Infirmier
    public void consulterActeComp(){};// consulter la liste des actes comp pour un patient donne
    public void consulterPlanSoins(){};// consulter la liste des plans  de soins pour un patient donne
    public void consulterPrescription(){};// consulter la liste des prescription pour un patient donne

}

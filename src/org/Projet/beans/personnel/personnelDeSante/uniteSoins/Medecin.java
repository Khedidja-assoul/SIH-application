package org.Projet.beans.personnel.personnelDeSante.uniteSoins;

import org.Projet.beans.etablisement.Service;
import org.Projet.beans.personnel.Personnel;
import org.Projet.beans.resultat.Rdv;

import java.util.ArrayList;


public class Medecin extends UniteSoins {

    private String grade;
    private String specialite;
    private int idService;
    private Rdv rdv;

    public Medecin(String nom, String prenom,int nbHeures, String dateNaissance, String email, String tel, String grade,String specialite) {
        super(nom,prenom,nbHeures, dateNaissance, email, tel);
        this.grade = grade;
        this.specialite = specialite;

    }

    public Medecin( int matricule ,String nom, String prenom) {
        super(matricule,nom,prenom);
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

    public int getIdService() {
        return idService;
    }

    public void setIdService(int idService) {
        this.idService = idService;
    }

    public Rdv getRdv() {
        return rdv;
    }

    public void setRdv(Rdv rdv) {
        this.rdv = rdv;
    }
}

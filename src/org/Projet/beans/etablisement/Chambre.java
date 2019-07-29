package org.Projet.beans.etablisement;

import org.Projet.beans.patient.Patient;

import java.util.ArrayList;

public class Chambre {
    private int num;
    private int etage;
    private int nbLits; // chambre double triple ...etc
    private boolean estReserver;
    private ArrayList<Patient> listePatient;

    public Chambre(int num, int etage, int nbLits) {
        this.num = num;
        this.etage = etage;
        this.nbLits = nbLits;
        this.estReserver = false;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getEtage() {
        return etage;
    }

    public void setEtage(int etage) {
        this.etage = etage;
    }

    public int getNbLits() {
        return nbLits;
    }

    public void setNbLits(int nbLits) {
        this.nbLits = nbLits;
    }

    public boolean isEstReserver() {
        return estReserver;
    }

    public void setEstReserver(boolean estReserver) {
        this.estReserver = estReserver;
    }

    @Override
    public String toString() {
        return Integer.toString(num) +" " +Integer.toString(etage)+ " "+Integer.toString(nbLits);
    }
}

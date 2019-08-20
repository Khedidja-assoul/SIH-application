package org.Projet.beans.resultat;

import org.Projet.beans.personnel.personnelDeSante.uniteSoins.Medecin;

public class CompteRendu {
    private int id;
    private String detaille;

    public CompteRendu(String detaille) {
        this.detaille = detaille;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDetaille() {
        return detaille;
    }

    public void setDetaille(String detaille) {
        this.detaille = detaille;
    }
}

package org.Projet.consumer.ImplemantationInterfaceDao;

import com.sun.xml.internal.bind.v2.TODO;
import org.Projet.beans.Authentifiable;
import org.Projet.beans.patient.Patient;
import org.Projet.beans.personnel.Personnel;
import org.Projet.beans.personnel.agentParamedicale.AgentParamedicale;
import org.Projet.beans.personnel.personnelDeSante.medicoTechenique.AgentBlocOperatoire;
import org.Projet.beans.personnel.personnelDeSante.medicoTechenique.AgentLaboratoire;
import org.Projet.beans.personnel.personnelDeSante.uniteSoins.Infirmier;
import org.Projet.beans.personnel.personnelDeSante.uniteSoins.Medecin;
import org.Projet.consumer.DaoFactory;
import org.Projet.consumer.InterfaceDao.UtilisateurDao;
import org.Projet.exceptions.InformationsErroneeException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UtilisateurDaoImpl implements UtilisateurDao {
    private DaoFactory daoFactory;

    public UtilisateurDaoImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;

    }

    @Override
    public int connexion(String nomUtilisateur, String motPasse, String typeUtilisateur) throws InformationsErroneeException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultat = null;
        try {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("SELECT * FROM utilisateur where typeUtilisateur = ?" +
                    "and nomUtilisateur = ? and motPasse = ? ;");
            System.out.println(nomUtilisateur + " " + motPasse + " " + typeUtilisateur);
            preparedStatement.setString(1, typeUtilisateur);
            preparedStatement.setString(2, nomUtilisateur);
            preparedStatement.setString(3, motPasse);
            System.out.println(preparedStatement.toString());
            preparedStatement.executeQuery();
            resultat = preparedStatement.getResultSet();
            while (resultat.next()) {
                System.out.println(resultat.getInt("id"));
                return resultat.getInt("id");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new InformationsErroneeException("Informations Erronee");
    }

    public Authentifiable getCompte(String nomUtilisateur, String motPasse, String typeUtilisateur) throws InformationsErroneeException {
            int id = connexion(nomUtilisateur, motPasse, typeUtilisateur);
                Connection connexion = null;
                PreparedStatement preparedStatement = null;
                ResultSet resultat = null;
                try {
                    connexion = daoFactory.getConnection();
                    preparedStatement = connexion.prepareStatement("SELECT * FROM " + typeUtilisateur + " where id = ?;");
                    preparedStatement.setInt(1, id);
                    System.out.println(preparedStatement.toString());
                    preparedStatement.executeQuery();
                    resultat = preparedStatement.getResultSet();
                    while (resultat.next()) {
                        switch (typeUtilisateur) {
                            case "medecin":
                                Medecin medecin = new Medecin(resultat.getString("nom"), resultat.getString("prenom"),
                                        resultat.getInt("nbHeures"), resultat.getString("dateNaissance"),
                                        resultat.getString("email"), resultat.getString("tel"), resultat.getString("grade"),
                                        resultat.getString("specialite"));
                                medecin.setMatricule(resultat.getInt("id"));
                                return medecin;
                            case "infirmier":
                                Infirmier infirmier = new Infirmier(resultat.getString("nom"), resultat.getString("prenom"),
                                        resultat.getInt("nbHeures"), resultat.getString("dateNaissance"),
                                        resultat.getString("email"), resultat.getString("tel"));
                                infirmier.setMatricule(resultat.getInt("id"));
                                return infirmier;

                            case "agentblocoperatoire":
                                AgentBlocOperatoire agentBlocOperatoire = new AgentBlocOperatoire(resultat.getString("nom"), resultat.getString("prenom"),
                                        resultat.getInt("nbHeures"), resultat.getString("dateNaissance"),
                                        resultat.getString("email"), resultat.getString("tel"));
                                agentBlocOperatoire.setMatricule(resultat.getInt("id"));
                                return agentBlocOperatoire;

                            case "agentlaboratoire":
                                AgentLaboratoire agentLaboratoire = new AgentLaboratoire(resultat.getString("nom"), resultat.getString("prenom"),
                                        resultat.getInt("nbHeures"), resultat.getString("dateNaissance"),
                                        resultat.getString("email"), resultat.getString("tel"));
                                agentLaboratoire.setMatricule(resultat.getInt("id"));
                                return agentLaboratoire;

                            case "agentparamedicale":

                                AgentParamedicale agentParamedicale = new AgentParamedicale(resultat.getString("nom"), resultat.getString("prenom"),
                                        resultat.getInt("nbHeures"), resultat.getString("dateNaissance"),
                                        resultat.getString("email"), resultat.getString("tel"));
                                agentParamedicale.setMatricule(resultat.getInt("id"));
                                return agentParamedicale;
                            case "patient":
                                Patient patient = new Patient(resultat.getString("nom"), resultat.getString("prenom"),
                                        resultat.getString("dateNaissance"), resultat.getString("adresse"),
                                        resultat.getString("tel"), resultat.getString("email"));
                                patient.setMatricule(resultat.getInt("id"));
                                return patient;
                        }
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }


        return null;

    }
}

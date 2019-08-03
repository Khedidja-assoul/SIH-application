package org.Projet.consumer.ImplemantationInterfaceDao;

import org.Projet.beans.Utilisateur;
import org.Projet.beans.patient.Patient;
import org.Projet.consumer.DaoFactory;
import org.Projet.consumer.InterfaceDao.AgentParamedicalDao;

import java.sql.*;

public class AgentParamedicalDaoImpl implements AgentParamedicalDao {
    private DaoFactory daoFactory;

    public AgentParamedicalDaoImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

   /****Fonction liee au patient ****/
    @Override
    public int ajouter(Patient patient) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try{
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("INSERT INTO patient(nom,prenom,dateNaissance,adresse," +
                    "tel,email) values (?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1,patient.getNom());
            preparedStatement.setString(2,patient.getPrenom());
            preparedStatement.setString(3,patient.getDateNaissance());
            preparedStatement.setString(4,patient.getAdresse());
            preparedStatement.setString(5,patient.getTel());
            preparedStatement.setString(6,patient.getEmail());
            preparedStatement.executeUpdate();

            Statement statement = null;
            ResultSet resultat = null;
            statement = connexion.createStatement();
            resultat = statement.executeQuery("SELECT max(id) from patient");
            while (resultat.next()){
                return resultat.getInt("max(id)");
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }
    public void ajouter(Utilisateur compte){
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("INSERT INTO  utilisateur (nomUtilisateur,motPasse" +
                    ",typeUtilisateur,id) VALUES(?,?,?,?)");
            preparedStatement.setString(1,compte.getNomUtilisateur());
            preparedStatement.setString(2,compte.getMotPasse());
            preparedStatement.setString(3,compte.getTypeUtilisateur());
            preparedStatement.setInt(4,compte.getId());
            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }




}

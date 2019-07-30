package org.Projet.consumer.ImplemantationInterfaceDao;

import org.Projet.beans.patient.Patient;
import org.Projet.consumer.DaoFactory;
import org.Projet.consumer.InterfaceDao.AgentParamedicalDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AgentParamedicalDaoImpl implements AgentParamedicalDao {
    private DaoFactory daoFactory;

    public AgentParamedicalDaoImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

   /****Fonction liee au patient ****/
    @Override
    public void ajouter(Patient patient) {
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
        }
        catch (SQLException e){
            e.printStackTrace();
        }

    }




}

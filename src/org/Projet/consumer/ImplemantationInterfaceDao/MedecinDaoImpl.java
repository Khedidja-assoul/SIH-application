package org.Projet.consumer.ImplemantationInterfaceDao;

import org.Projet.beans.patient.Patient;
import org.Projet.beans.resultat.ActeComplementaireLaboratoire;
import org.Projet.beans.resultat.Analyse;
import org.Projet.beans.resultat.Consultation;
import org.Projet.consumer.DaoFactory;
import org.Projet.consumer.InterfaceDao.MedecinDao;

import java.sql.*;
import java.util.ArrayList;

public class MedecinDaoImpl implements MedecinDao {
    private DaoFactory daoFactory;

    public MedecinDaoImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;

    }


    public Patient getPatient(String nom, String prenom){
        Patient patient = null;
        Connection connexion = null;
        PreparedStatement statement = null;
        ResultSet resultat = null;
        try {
            connexion = daoFactory.getConnection();
            statement= connexion.prepareStatement("SELECT * FROM patient where nom = ? and prenom =  ? ;");
            statement.setString(1,nom);
            statement.setString(2,prenom);
            resultat = statement.executeQuery();
            while (resultat.next()) {
                patient = new Patient(resultat.getString("nom"),resultat.getString("prenom"),
                        resultat.getString("datenaissance"),resultat.getString("adresse"),
                        resultat.getString("tel"),resultat.getString("email"));
                patient.setMatricule(resultat.getInt("id"));
                System.out.println(patient);
                return patient;
            }
        }

        catch (SQLException e) {
            e.printStackTrace();
        }
        return patient;
    }

    public int ajouter(Consultation consultation){
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        int id = -1;
        try{
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("insert into consultation(idMedecin, idPatient, date, heure, motif) values (?,?,?,?,?) ;");
            preparedStatement.setInt(1,consultation.getIdMedecin());
            preparedStatement.setInt(2,consultation.getIdPatient());
            preparedStatement.setString(3,consultation.getDate());
            preparedStatement.setString(4,consultation.getHeure());
            preparedStatement.setString(5,consultation.getMotif());
            preparedStatement.toString();
            preparedStatement.executeUpdate();
            Statement statement = null;
            ResultSet resultat = null;
            statement = connexion.createStatement();
            resultat = statement.executeQuery("select max(id) from consultation where idMedecin = " +consultation.getIdMedecin()+
                    " and idPatient =  "+consultation.getIdPatient()+" ;");

            while (resultat.next()){
                id = resultat.getInt("max(id)");
                return id;
            }
        }
        catch(SQLException e){ e.printStackTrace();}
        return id;
    }

    public Analyse getAnalyse(String nom){
        Analyse analyse = null;
        Connection connexion = null;
        PreparedStatement statement = null;
        ResultSet resultat = null;
        try {
            connexion = daoFactory.getConnection();
            statement= connexion.prepareStatement("SELECT * FROM analyse where nomOfficiel = ? ;");
            statement.setString(1,nom);
            resultat = statement.executeQuery();
            while (resultat.next()) {
                analyse = new Analyse(resultat.getString("nomOfficiel"),resultat.getString("abreviation"),
                        resultat.getString("detailles"));
                analyse.setId(resultat.getInt("id"));
                return analyse;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return analyse;


    }

    public  void ajouter(ActeComplementaireLaboratoire acteLAbo){
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        try{
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("insert into acteComplementaireLaboratoire(idConsultation)" +
                    " values (?) ;");
            preparedStatement.setInt(1,acteLAbo.getIdConsultation());
            System.out.println(preparedStatement.toString());
            preparedStatement.executeUpdate();

            Statement statement = null;
            ResultSet resultat = null;
            statement = connexion.createStatement();
            resultat = statement.executeQuery("select max(actecomplementairelaboratoire.id) from" +
                    " actecomplementairelaboratoire,consultation where actecomplementairelaboratoire.idConsultation = " +
                    acteLAbo.getIdConsultation() + " and actecomplementairelaboratoire.idConsultation = consultation.id ;");

            int id = -1;
            while (resultat.next()){
                 id = resultat.getInt("max(actecomplementairelaboratoire.id)");
                break;
            }
            if (id != -1) {
                ArrayList<Integer> list = acteLAbo.getListeTypeAnalyse();
                for (int i = 0; i < list.size(); i++) {
                    preparedStatement = connexion.prepareStatement("insert  into acteCompostition(idActe,idAnalyse) values  (?,?)");
                    preparedStatement.setInt(1, id);
                    preparedStatement.setInt(2, list.get(i));
                    preparedStatement.executeUpdate();
                }
            }
            System.out.println("ajout dans composition acte");
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
}

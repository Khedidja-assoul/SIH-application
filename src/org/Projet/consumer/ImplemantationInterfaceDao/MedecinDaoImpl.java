package org.Projet.consumer.ImplemantationInterfaceDao;

import org.Projet.beans.patient.Patient;
import org.Projet.beans.resultat.*;
import org.Projet.consumer.DaoFactory;
import org.Projet.consumer.InterfaceDao.MedecinDao;
import org.Projet.exceptions.InformationDupliquerExeption;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

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

    public Patient getPatient(int id){
        Patient patient = null;
        Connection connexion = null;
        PreparedStatement statement = null;
        ResultSet resultat = null;
        try {
            connexion = daoFactory.getConnection();
            statement= connexion.prepareStatement("SELECT * FROM patient where id = ? ;");
            statement.setInt(1,id);
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

    public  void ajouter(ActeComplementaireLaboratoire acteLAbo) throws InformationDupliquerExeption{
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        try{
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("insert into acteComplementaireLaboratoire(idConsultation,idAnalyse)" +
                    " values (?,?) ;");
            preparedStatement.setInt(1,acteLAbo.getIdConsultation());
            preparedStatement.setInt(2,acteLAbo.getIdAnalyse());
            System.out.println(preparedStatement.toString());
                preparedStatement.executeUpdate();

        }
        catch (SQLIntegrityConstraintViolationException e){
            throw new InformationDupliquerExeption("Ce type d'analyse et deja ajouter a cette consultation");

        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void ajouter(Presecription presecription){
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        try{
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("insert into prescription(idConsultation,typePrescription," +
                    "detaille) values (?,?,?) ;");
            preparedStatement.setInt(1,presecription.getIdConsultation());
            preparedStatement.setString(2,presecription.getTypePrescription());
            preparedStatement.setString(3,presecription.getDeatille());
            preparedStatement.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }

    }
    public void ajouter(CompteRenduConsultation compteRendu){
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        try{
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("insert into compterenduconsultation(detaille,idConsultation) " +
                    "values (?,?) ;");
            preparedStatement.setString(1,compteRendu.getDetaille());
            preparedStatement.setInt(2,compteRendu.getIdConsultation());
            preparedStatement.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void ajouter(PlanSoin planSoin){
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        try{
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("insert into planSoin(idConsultation,soins) " +
                    "values (?,?) ;");
            preparedStatement.setInt(1,planSoin.getIdConsultation());
            preparedStatement.setString(2,planSoin.getListeDesSoins().toString());
            preparedStatement.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public ArrayList<Consultation> afficher(int idMedecin){

        ArrayList<Consultation> consultations= new ArrayList();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultat = null;
        try {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("SELECT * FROM consultation where idMedecin = ? ;");
            preparedStatement.setInt(1,idMedecin);
            resultat = preparedStatement.executeQuery();
            while (resultat.next()){
                Consultation consultation= new Consultation(idMedecin,resultat.getInt("idPatient"),
                        resultat.getString("date"),resultat.getString("heure"),
                        resultat.getString("motif"));
                consultation.setId(resultat.getInt("id"));
                consultations.add(consultation);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return consultations;

    }

    public Consultation getConsutation(int id){
        Consultation consultation = null;
        Connection connexion = null;
        PreparedStatement statement = null;
        ResultSet resultat = null;
        try {
            connexion = daoFactory.getConnection();
            statement= connexion.prepareStatement("SELECT * FROM consultation where id  = ? ;");
            statement.setInt(1,id);
            resultat = statement.executeQuery();
            while (resultat.next()) {
                consultation = new Consultation(resultat.getInt("idMedecin"),resultat.getInt("idPatient"),
                        resultat.getString("date"),resultat.getString("heure"),
                        resultat.getString("motif"));
                consultation.setId(resultat.getInt("id"));
                return consultation;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return consultation;
    }
    public ArrayList<Presecription> getPrescription(int idConsultation){
        ArrayList<Presecription> list = new ArrayList<>();
        Connection connexion = null;
        PreparedStatement statement = null;
        ResultSet resultat = null;
        try {
            connexion = daoFactory.getConnection();
            statement= connexion.prepareStatement("SELECT * FROM prescription where idConsultation  = ? ;");
            statement.setInt(1,idConsultation);
            resultat = statement.executeQuery();
            while (resultat.next()) {
                Presecription presecription = new Presecription(resultat.getInt("idConsultation"),
                        resultat.getString("typePrescription"),
                        resultat.getString("detaille"));
                presecription.setId(resultat.getInt("id"));
                list.add(presecription);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<PlanSoin> getPlanSoin(int idConsultation){
        ArrayList<PlanSoin> list = new ArrayList<>();
        Connection connexion = null;
        PreparedStatement statement = null;
        ResultSet resultat = null;
        try {
            connexion = daoFactory.getConnection();
            statement= connexion.prepareStatement("SELECT * FROM plansoin where idConsultation  = ? ;");
            statement.setInt(1,idConsultation);
            resultat = statement.executeQuery();
            while (resultat.next()) {
                PlanSoin planSoin= new PlanSoin(resultat.getInt("idConsultation"));
                planSoin.setId(resultat.getInt("id"));
                ArrayList<String> soins = new ArrayList<>(Arrays.asList(resultat.getString("soins").split(",")));
                planSoin.setListeDesSoins(soins);
                list.add(planSoin);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public ArrayList<CompteRenduConsultation> getCompteRendu(int idConsultation){
        ArrayList<CompteRenduConsultation> list = new ArrayList<>();
        Connection connexion = null;
        PreparedStatement statement = null;
        ResultSet resultat = null;
        try {
            connexion = daoFactory.getConnection();
            statement= connexion.prepareStatement("SELECT * FROM compterenduconsultation where idConsultation  = ? ;");
            statement.setInt(1,idConsultation);
            resultat = statement.executeQuery();
            while (resultat.next()) {
                CompteRenduConsultation compteRendu = new CompteRenduConsultation(resultat.getString("detaille"),
                        resultat.getInt("idConsultation"));
                compteRendu.setId(resultat.getInt("id"));
                list.add(compteRendu);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public ArrayList<ActeComplementaireLaboratoire> getActeComplementaireLaboratoire(int idConsultation){
        ArrayList<ActeComplementaireLaboratoire> list = new ArrayList<>();
        Connection connexion = null;
        PreparedStatement statement = null;
        ResultSet resultat = null;
        try {
            connexion = daoFactory.getConnection();
            statement= connexion.prepareStatement("SELECT * FROM actecomplementairelaboratoire where idConsultation  = ? ;");
            statement.setInt(1,idConsultation);
            resultat = statement.executeQuery();
            while (resultat.next()) {
                ResultSet resultat2 ;
                ActeComplementaireLaboratoire acteCompleLabo
                        = new ActeComplementaireLaboratoire(resultat.getInt("idConsultation"),resultat.getInt("idAnalyse"));
                acteCompleLabo.setId(resultat.getInt("id"));
                list.add(acteCompleLabo);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}

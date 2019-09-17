package org.Projet.consumer.ImplemantationInterfaceDao;

import org.Projet.beans.patient.Patient;
import org.Projet.beans.personnel.personnelDeSante.uniteSoins.Medecin;
import org.Projet.beans.resultat.*;
import org.Projet.consumer.DaoFactory;
import org.Projet.consumer.InterfaceDao.AgentLaboratoireDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

public class AgentLaboratoireDaoImpl implements AgentLaboratoireDao {
    private DaoFactory daoFactory;

    public AgentLaboratoireDaoImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;

    }

    public ArrayList<Analyse> afficherAnalyse(){
        ArrayList<Analyse> actes = new ArrayList();
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;
        try{
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery("select * from analyse ;");
            while (resultat.next()){
                Analyse analyse = new Analyse(resultat.getString("nomOfficiel"),
                        resultat.getString("abreviation"),resultat.getString("detailles"));
                analyse.setId(resultat.getInt("id"));
                actes.add(analyse);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return actes;
    }

    public ArrayList<ActeComplementaireLaboratoire> afficherDemandeActe(){
        ArrayList<ActeComplementaireLaboratoire> listDemandesActes = new  ArrayList<>();
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;

        try{
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery("select * from actecomplementairelaboratoire" +
                    " where id not in (select idActe from resultatBiologique) ; ");
            while (resultat.next()){
                ActeComplementaireLaboratoire acteLabo= new ActeComplementaireLaboratoire(resultat.getInt("idConsultation"),
                        resultat.getInt("idAnalyse"));
                acteLabo.setId(resultat.getInt("id"));
                listDemandesActes.add(acteLabo);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }

        return listDemandesActes;

    }

    public Consultation getConsultation(int id) {
        Consultation consultation = null;
        Connection connexion = null;
        PreparedStatement statement = null;
        ResultSet resultat = null;
        try {
            connexion = daoFactory.getConnection();
            statement = connexion.prepareStatement("SELECT * FROM consultation where id  = ? ;");
            statement.setInt(1, id);
            resultat = statement.executeQuery();
            while (resultat.next()) {
                consultation = new Consultation(resultat.getInt("idMedecin"), resultat.getInt("idPatient"),
                        resultat.getString("date"), resultat.getString("heure"),
                        resultat.getString("motif"));
                consultation.setId(resultat.getInt("id"));
                return consultation;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return consultation;
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

    public Medecin getMedecin(int id){
        Medecin medecin= null;
        Connection connexion = null;
        PreparedStatement statement = null;
        ResultSet resultat = null;
        try {
            connexion = daoFactory.getConnection();
            statement= connexion.prepareStatement("SELECT * FROM medecin where id = ? ;");
            statement.setInt(1,id);
            resultat = statement.executeQuery();
            while (resultat.next()) {
                medecin = new Medecin(resultat.getString("nom"),resultat.getString("prenom"),
                        resultat.getInt("nbHeures"),
                        resultat.getString("datenaissance"),
                        resultat.getString("email"),resultat.getString("tel"),
                        resultat.getString("grade"),resultat.getString("specialite"));
                medecin.setMatricule(resultat.getInt("id"));

                return medecin;
            }
        }

        catch (SQLException e) {
            e.printStackTrace();
        }
        return medecin;
    }
    public  ActeComplementaireLaboratoire getDemandeActe(int idActe){
        ActeComplementaireLaboratoire acteLabo = null;
        Connection connexion = null;
        PreparedStatement statement = null;
        ResultSet resultat = null;

        try{
            connexion = daoFactory.getConnection();
            statement = connexion.prepareStatement("select * from actecomplementairelaboratoire where id = ?");
            statement.setInt(1,idActe);
            resultat = statement.executeQuery();
            while (resultat.next()){
                acteLabo= new ActeComplementaireLaboratoire(resultat.getInt("idConsultation"),
                        resultat.getInt("idAnalyse"));
                acteLabo.setId(resultat.getInt("id"));
                return  acteLabo;
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return acteLabo;
    }
    public Analyse getAnalyse(int idAnalyse){
        Analyse analyse = null;
        Connection connexion = null;
        PreparedStatement statement = null;
        ResultSet resultat = null;
        try{
            connexion = daoFactory.getConnection();
            statement = connexion.prepareStatement("select * from analyse where id = ? ;");
            statement.setInt(1,idAnalyse);
            resultat = statement.executeQuery();
            while (resultat.next()){
                analyse = new Analyse(resultat.getString("nomOfficiel"),
                        resultat.getString("abreviation"),resultat.getString("detailles"));
                analyse.setId(resultat.getInt("id"));
               return analyse;
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return analyse;
    }

    public void validerActe(ResultatBiologique resultatBiologique){
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try{
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("insert into resultatBiologique" +
                    "(idActe, idAgentLaboratoire, date, heure,resultat) values (?,?,?,?,?) ;");
            preparedStatement.setInt(1,resultatBiologique.getIdActe());
            preparedStatement.setInt(2,resultatBiologique.getIdAgentLaboratoire());
            preparedStatement.setString(3,resultatBiologique.getDate());
            preparedStatement.setString(4,resultatBiologique.getHeure());
            preparedStatement.setString(5,resultatBiologique.getResultat().toString());
            System.out.println(preparedStatement.toString());
            preparedStatement.executeUpdate();

        }
        catch(SQLException e){ e.printStackTrace();}

    }

    public ArrayList<ActeComplementaireLaboratoire> afficherActeLaboEtablis()
    {
        ArrayList<ActeComplementaireLaboratoire> listeActEtabis = new ArrayList<>();
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;

        try{
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery("select * from actecomplementairelaboratoire" +
                    " where id  in (select idActe from resultatBiologique) ; ");
            while (resultat.next()){
                ActeComplementaireLaboratoire acteLabo= new ActeComplementaireLaboratoire(resultat.getInt("idConsultation"),
                        resultat.getInt("idAnalyse"));
                acteLabo.setId(resultat.getInt("id"));
                listeActEtabis.add(acteLabo);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }

        return listeActEtabis;
    }



    public ResultatBiologique getResultatBiologique(int idActe)
    {
        ResultatBiologique resultatBiologique = null;
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;

        try{
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery("select * from resultatBiologique ;");
            while (resultat.next()){
                resultatBiologique = new ResultatBiologique(resultat.getInt("idActe"),
                        resultat.getInt("idAgentLaboratoire"),resultat.getString("date"),
                        resultat.getString("heure"));
                ArrayList<String> resultats = new ArrayList<>(Arrays.asList(resultat.getString("resultat").split(",")));
                resultats.set(0, resultats.get(0).substring(1));
                String s = resultats.get(resultats.size() - 1);
                resultats.set(resultats.size() - 1, s.substring(0, s.length() - 1));
                ArrayList<Float> resultatAnalyse = new ArrayList<>();
                for (int i = 0 ;i< resultats.size();i++)
                {
                    resultatAnalyse.add(Float.parseFloat(resultats.get(i)));
                }
                resultatBiologique.setResultat(resultatAnalyse);
                resultatBiologique.setId(resultat.getInt("id"));
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }

        return resultatBiologique;
    }
}

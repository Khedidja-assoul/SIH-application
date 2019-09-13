package org.Projet.consumer.ImplemantationInterfaceDao;

import org.Projet.beans.patient.Patient;
import org.Projet.beans.personnel.personnelDeSante.uniteSoins.Medecin;
import org.Projet.beans.resultat.*;
import org.Projet.consumer.DaoFactory;
import org.Projet.consumer.InterfaceDao.AgentLaboratoireDao;

import java.sql.*;
import java.util.ArrayList;

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

                ActeComplementaireLaboratoire acteLabo= new ActeComplementaireLaboratoire(resultat.getInt("idConsultation"));
                acteLabo.setId(resultat.getInt("id"));

                PreparedStatement satatement2;
                ResultSet resultat2;
                satatement2 = connexion.prepareStatement("SELECT * FROM actecompostition where idActe  = ? ;");
                satatement2.setInt(1,resultat.getInt("id"));
                resultat2 = satatement2.executeQuery();

                while (resultat2.next()){
                    acteLabo.ajouterAnalyse(resultat2.getInt("idAnalyse"));
                }

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
                acteLabo= new ActeComplementaireLaboratoire(resultat.getInt("idConsultation"));
                acteLabo.setId(resultat.getInt("id"));
                PreparedStatement satatement2;
                ResultSet resultat2;
                satatement2 = connexion.prepareStatement("SELECT * FROM actecompostition where idActe  = ? ;");
                satatement2.setInt(1,resultat.getInt("id"));
                resultat2 = satatement2.executeQuery();

                while (resultat2.next()){
                    acteLabo.ajouterAnalyse(resultat2.getInt("idAnalyse"));
                }
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
                    "(idActe, idAgentLaboratoire, date, heure) values (?,?,?,?) ;");
            preparedStatement.setInt(1,resultatBiologique.getIdActe());
            preparedStatement.setInt(2,resultatBiologique.getIdAgentLaboratoire());
            preparedStatement.setString(3,resultatBiologique.getDate());
            preparedStatement.setString(4,resultatBiologique.getHeure());
            preparedStatement.executeUpdate();
            Statement statement = null;
            ResultSet resultat = null;
            int idResultatBiologique = -1  ;
            statement = connexion.createStatement();
            resultat = statement.executeQuery("select max(id) from resultatBiologique where idAgentLaboratoire = "
                    +resultatBiologique.getIdAgentLaboratoire()+ " ;");
            while (resultat.next()){
                 idResultatBiologique = resultat.getInt("max(id)");
                break;
            }
            if (idResultatBiologique!=-1) {
                for (int i = 0; i < resultatBiologique.getResultatAnalyses().size(); i++) {
                    preparedStatement = connexion.prepareStatement("insert into resultatAnalyse(idResultatBiologique," +
                            "idAnalyse, detailles) values  (?,?,?)");
                    preparedStatement.setInt(1, idResultatBiologique);
                    preparedStatement.setInt(2,resultatBiologique.getResultatAnalyses().get(i).getIdAnalyse());
                    preparedStatement.setString(3,resultatBiologique.getResultatAnalyses().get(i).getDetaille());
                }
            }


        }
        catch(SQLException e){ e.printStackTrace();}

    }
}

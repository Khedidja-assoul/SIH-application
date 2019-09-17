package org.Projet.consumer.ImplemantationInterfaceDao;

import org.Projet.beans.personnel.personnelDeSante.uniteSoins.Medecin;
import org.Projet.beans.resultat.Consultation;
import org.Projet.beans.resultat.PlanSoin;
import org.Projet.consumer.DaoFactory;
import org.Projet.consumer.InterfaceDao.InfirmierDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class InfirmierDaoImpl implements InfirmierDao {

    private DaoFactory daoFactory;

    public InfirmierDaoImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;

    }

     public ArrayList<Consultation> afficherPlansDeSoin(int idPatient)
     {
         ArrayList<Consultation> consultations= new ArrayList<>();
         Connection connexion = null;
         PreparedStatement preparedStatement = null;
         ResultSet result = null;
         try {
             connexion = daoFactory.getConnection();
             preparedStatement = connexion.prepareStatement("select * from consultation where idPatient = ? " +
                     "and id in (select idConsultation from plansoin) ;");
             preparedStatement.setInt(1,idPatient);
             System.out.println(preparedStatement.toString());
             result = preparedStatement.executeQuery();
             while(result.next())
             {
                 Consultation consultation = new Consultation(result.getInt("idMedecin"),
                         result.getInt("idPatient"),result.getString("date"),
                         result.getString("heure"),result.getString("motif"));
                 consultation.setId(result.getInt("id"));
                 consultations.add(consultation);
             }

         }
         catch (SQLException e){
             e.printStackTrace();
         }
         return consultations;

     }

     public ArrayList<PlanSoin> getPlansSoins(int idConsultation)
     {
         ArrayList<PlanSoin> planSoins = new ArrayList<>();
         Connection connexion = null;
         PreparedStatement preparedStatement = null;
         ResultSet result = null;
         try {
             connexion = daoFactory.getConnection();
             preparedStatement = connexion.prepareStatement("select * from plansoin where idConsultation = ?;");
             preparedStatement.setInt(1,idConsultation);
             result = preparedStatement.executeQuery();
             while(result.next())
             {
                 PlanSoin planSoin= new PlanSoin(idConsultation);
                 planSoin.setId(result.getInt("id"));
                 ArrayList<String> resultats = new ArrayList<>(Arrays.asList(result.getString("soins").split(",")));
                 resultats.set(0, resultats.get(0).substring(1));
                 String s = resultats.get(resultats.size() - 1);
                 resultats.set(resultats.size() - 1, s.substring(0, s.length() - 1));
                 planSoin.setListeDesSoins(resultats);
                 planSoins.add(planSoin);
             }
         }
         catch (SQLException e){
             e.printStackTrace();
         }
         return planSoins;
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
                medecin = new Medecin(id,resultat.getString("nom"),resultat.getString("prenom"));
                medecin.setMatricule(resultat.getInt("id"));
                return medecin;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return medecin;
    }
}

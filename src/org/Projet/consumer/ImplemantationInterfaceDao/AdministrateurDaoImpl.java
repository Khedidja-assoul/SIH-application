package org.Projet.consumer.ImplemantationInterfaceDao;

import org.Projet.beans.personnel.Personnel;
import org.Projet.beans.personnel.agentParamedicale.AgentParamedicale;
import org.Projet.beans.personnel.personnelDeSante.medicoTechenique.AgentBlocOperatoire;
import org.Projet.beans.personnel.personnelDeSante.medicoTechenique.AgentLaboratoire;
import org.Projet.beans.personnel.personnelDeSante.uniteSoins.Infirmier;
import org.Projet.consumer.DaoFactory;
import org.Projet.consumer.InterfaceDao.AdministrateurDao;
import org.Projet.beans.personnel.personnelDeSante.uniteSoins.Medecin;

import java.sql.*;
import java.util.ArrayList;

public class AdministrateurDaoImpl implements AdministrateurDao {

    private DaoFactory daoFactory;

    public AdministrateurDaoImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;

    }

    public ArrayList<Personnel> affichierPersonnels(String typePersonnel){

        ArrayList<Personnel> personnels= new ArrayList();
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;
        try {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            System.out.println("heyyyyyyyyyyyyyyyyyy : "+typePersonnel);
            switch (typePersonnel) {
                case "Medecin" :
                    resultat = statement.executeQuery("SELECT * FROM medecin;");
                    while (resultat.next()){
                        Medecin medecin = new Medecin(resultat.getString("nom"), resultat.getString("prenom"),
                                resultat.getInt("nbHeures"), resultat.getString("dateNaissance"),
                                resultat.getString("email"), resultat.getString("tel"),resultat.getString("grade"),
                                resultat.getString("specialite"));
                        medecin.setMatricule(resultat.getInt("id"));
                        personnels.add(medecin);
                    }

                    break;

                case "Infirmier":
                    resultat = statement.executeQuery("SELECT * FROM infirmier;");
                    while (resultat.next()) {
                        Infirmier infirmier = new Infirmier(resultat.getString("nom"), resultat.getString("prenom"),
                                resultat.getInt("nbHeures"), resultat.getString("dateNaissance"),
                                resultat.getString("email"), resultat.getString("tel"));
                        infirmier.setMatricule(resultat.getInt("id"));
                        personnels.add(infirmier);
                    }

                    break;

                case "Agent bloc operatoire":
                    resultat = statement.executeQuery("SELECT * FROM AgentBlocOperatoire;");
                    AgentBlocOperatoire agentBlocOperatoire = new AgentBlocOperatoire(resultat.getString("nom"), resultat.getString("prenom"),
                            resultat.getInt("nbHeures"), resultat.getString("dateNaissance"),
                            resultat.getString("email"), resultat.getString("tel"));
                    agentBlocOperatoire.setMatricule(resultat.getInt("id"));
                    personnels.add(agentBlocOperatoire);
                    break;

                case "Agent laboratoire":
                    resultat = statement.executeQuery("SELECT * FROM AgentLaboratoire;");
                    while (resultat.next()) {
                        AgentLaboratoire agentLaboratoire = new AgentLaboratoire(resultat.getString("nom"), resultat.getString("prenom"),
                                resultat.getInt("nbHeures"), resultat.getString("dateNaissance"),
                                resultat.getString("email"), resultat.getString("tel"));
                        agentLaboratoire.setMatricule(resultat.getInt("id"));
                        personnels.add(agentLaboratoire);
                    }

                    break;

                case "Agent paramedicale":
                    resultat = statement.executeQuery("SELECT * FROM AgentParamedicale;");
                    while (resultat.next()) {
                        AgentParamedicale agentParamedicale= new AgentParamedicale(resultat.getString("nom"), resultat.getString("prenom"),
                                resultat.getInt("nbHeures"), resultat.getString("dateNaissance"),
                                resultat.getString("email"), resultat.getString("tel"));
                        agentParamedicale.setMatricule(resultat.getInt("id"));
                        personnels.add(agentParamedicale);
                    }

                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personnels;
    }
    public void ajouter(Personnel personnel,String typePersonnel){
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            switch (typePersonnel) {
                case "Medecin" :
                    preparedStatement = connexion.prepareStatement
                        ("INSERT INTO medecin(nom, prenom,nbHeures,dateNaissance, email, tel, grade, specialite) " +
                                "VALUES(?,?, ?, ?, ?, ?, ?, ?);");
                    preparedStatement.setString(7, ((Medecin)personnel).getGrade());
                    preparedStatement.setString(8, ((Medecin)personnel).getSpecialite());
                    break;
                case "Infirmier":
                    preparedStatement = connexion.prepareStatement
                            ("INSERT INTO infirmier(nom, prenom,nbHeures,dateNaissance, email, tel) VALUES( ?, ?, ?, ?, ?, ?);");
                    break;
                case "Agent bloc operatoire":
                    preparedStatement = connexion.prepareStatement
                            ("INSERT INTO AgentBlocOperatoire(nom, prenom,nbHeures,dateNaissance, email, tel) VALUES(?, ?, ?, ?, ?, ?);");
                    break;

                case "Agent laboratoire":
                    preparedStatement = connexion.prepareStatement
                            ("INSERT INTO AgentLaboratoire(nom, prenom,nbHeures,dateNaissance, email, tel) VALUES(?, ?, ?, ?, ?, ?);");
                    break;
                case "Agent paramedicale":
                    preparedStatement = connexion.prepareStatement
                            ("INSERT INTO AgentParamedicale(nom, prenom,nbHeures,dateNaissance, email, tel) VALUES(?, ?, ?, ?, ?, ?);");
                    break;

            }
            preparedStatement.setString(1, personnel.getNom());
            preparedStatement.setString(2, personnel.getPrenom());
            preparedStatement.setInt(3, personnel.getNbHeures());
            preparedStatement.setString(4, personnel.getDateNaissance());
            preparedStatement.setString(5, personnel.getEmail());
            preparedStatement.setString(6, personnel.getTel());
            System.out.println(preparedStatement.toString());
            preparedStatement.executeUpdate();
        }
         catch (SQLException e) {
            e.printStackTrace();
        }
    }


}




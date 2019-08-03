package org.Projet.consumer.ImplemantationInterfaceDao;

import org.Projet.beans.Utilisateur;
import org.Projet.beans.etablisement.Chambre;
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
import java.util.HashMap;
import java.util.Map;

public class AdministrateurDaoImpl implements AdministrateurDao {

    private DaoFactory daoFactory;

    public AdministrateurDaoImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;

    }

    /**** Fonction liee a la gestion du personnel****/
    public ArrayList<Personnel> affichierPersonnels(String typePersonnel){

        ArrayList<Personnel> personnels= new ArrayList();
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;
        try {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            switch (typePersonnel) {
                case "medecin" :
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

                case "infirmier":
                    resultat = statement.executeQuery("SELECT * FROM infirmier;");
                    while (resultat.next()) {
                        Infirmier infirmier = new Infirmier(resultat.getString("nom"), resultat.getString("prenom"),
                                resultat.getInt("nbHeures"), resultat.getString("dateNaissance"),
                                resultat.getString("email"), resultat.getString("tel"));
                        infirmier.setMatricule(resultat.getInt("id"));
                        personnels.add(infirmier);
                    }

                    break;

                case "agentblocoperatoire":
                    resultat = statement.executeQuery("SELECT * FROM AgentBlocOperatoire;");
                    AgentBlocOperatoire agentBlocOperatoire = new AgentBlocOperatoire(resultat.getString("nom"), resultat.getString("prenom"),
                            resultat.getInt("nbHeures"), resultat.getString("dateNaissance"),
                            resultat.getString("email"), resultat.getString("tel"));
                    agentBlocOperatoire.setMatricule(resultat.getInt("id"));
                    personnels.add(agentBlocOperatoire);
                    break;

                case "agentlaboratoire":
                    resultat = statement.executeQuery("SELECT * FROM AgentLaboratoire;");
                    while (resultat.next()) {
                        AgentLaboratoire agentLaboratoire = new AgentLaboratoire(resultat.getString("nom"), resultat.getString("prenom"),
                                resultat.getInt("nbHeures"), resultat.getString("dateNaissance"),
                                resultat.getString("email"), resultat.getString("tel"));
                        agentLaboratoire.setMatricule(resultat.getInt("id"));
                        personnels.add(agentLaboratoire);
                    }

                    break;

                case "agentparamedicale":
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

  /*  public Personnel afficher(String typePersonnel,HashMap<String,String> critere ){
        Personnel personnel =null;
        if (typePersonnel!=null) {
            String query = "Select ? from " + typePersonnel;
            if(!critere.isEmpty()){
                query = query+" where";
                boolean premier = true;
                for (Map.Entry<String, String> entry : critere.entrySet())
                {
                    String champ= entry.getKey();
                    String valeur = entry.getValue();
                    if (premier){
                        query = query + champ +" = ? ";
                        premier = false;
                    }

                }
            }
        }
        return personnel;
    }*/
    public int ajouter(Personnel personnel,String typePersonnel){
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            switch (typePersonnel) {
                case "medecin" :
                    preparedStatement = connexion.prepareStatement
                        ("INSERT INTO medecin(nom, prenom,nbHeures,dateNaissance, email, tel, grade, specialite) " +
                                "VALUES(?,?, ?, ?, ?, ?, ?, ?);");
                    preparedStatement.setString(7, ((Medecin)personnel).getGrade());
                    preparedStatement.setString(8, ((Medecin)personnel).getSpecialite());
                    break;
                case "infirmier":
                    preparedStatement = connexion.prepareStatement
                            ("INSERT INTO infirmier(nom, prenom,nbHeures,dateNaissance, email, tel) VALUES( ?, ?, ?, ?, ?, ?);");
                    break;
                case "agentblocoperatoire":
                    preparedStatement = connexion.prepareStatement
                            ("INSERT INTO AgentBlocOperatoire(nom, prenom,nbHeures,dateNaissance, email, tel) VALUES(?, ?, ?, ?, ?, ?);");
                    break;

                case "agentlaboratoire":
                    preparedStatement = connexion.prepareStatement
                            ("INSERT INTO AgentLaboratoire(nom, prenom,nbHeures,dateNaissance, email, tel) VALUES(?, ?, ?, ?, ?, ?);");
                    break;
                case "agentparamedicale":
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
            preparedStatement.executeUpdate();
            Statement statement = null;
            ResultSet resultat = null;
            statement = connexion.createStatement();
            resultat =statement.executeQuery("SELECT max(id) from "+typePersonnel);
            while (resultat.next()){
                return resultat.getInt("max(id)");
            }
        }
         catch (SQLException e) {
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
    /**** Fonction liee a la gestion des chambre ****/
    public void ajouter(Chambre chambre){
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("INSERT INTO  Chambre (num,etage,nbLits,estReserver) VALUES(?,?,?,?)");
            preparedStatement.setInt(1,chambre.getNum());
            preparedStatement.setInt(2,chambre.getEtage());
            preparedStatement.setInt(3,chambre.getNbLits());
            preparedStatement.setBoolean(4,chambre.isEstReserver());
            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();

        }

    }


}




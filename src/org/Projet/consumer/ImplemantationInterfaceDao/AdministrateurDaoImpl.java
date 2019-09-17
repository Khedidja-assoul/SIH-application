package org.Projet.consumer.ImplemantationInterfaceDao;

import org.Projet.beans.Administrateur;
import org.Projet.beans.Utilisateur;
import org.Projet.beans.etablisement.Chambre;
import org.Projet.beans.etablisement.Service;
import org.Projet.beans.personnel.Personnel;
import org.Projet.beans.personnel.agentParamedicale.AgentParamedicale;
import org.Projet.beans.personnel.personnelDeSante.medicoTechenique.AgentBlocOperatoire;
import org.Projet.beans.personnel.personnelDeSante.medicoTechenique.AgentLaboratoire;
import org.Projet.beans.personnel.personnelDeSante.uniteSoins.Infirmier;
import org.Projet.consumer.DaoFactory;
import org.Projet.consumer.InterfaceDao.AdministrateurDao;
import org.Projet.beans.personnel.personnelDeSante.uniteSoins.Medecin;
import org.Projet.exceptions.InformationsErroneeException;

import java.sql.*;
import java.util.ArrayList;

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
                case "medecin":
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
                    while (resultat.next()) {
                        AgentBlocOperatoire agentBlocOperatoire = new AgentBlocOperatoire(resultat.getString("nom"), resultat.getString("prenom"),
                                resultat.getInt("nbHeures"), resultat.getString("dateNaissance"),
                                resultat.getString("email"), resultat.getString("tel"));
                        agentBlocOperatoire.setMatricule(resultat.getInt("id"));
                        personnels.add(agentBlocOperatoire);
                    }
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
                case "medecin":
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
            preparedStatement = connexion.prepareStatement("INSERT INTO  Chambre (num,etage,nbLits,estReserver) VALUES(?,?,?,?);");
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

    public void ajouter(Administrateur administrateur){
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("INSERT INTO  Administrateur (nomUtilisateur," +
                    "motDePasse,nom,prenom) VALUES(?,?,?,?);");
            preparedStatement.setString(1,administrateur.getNomUtilisateur());
            preparedStatement.setString(2,administrateur.getMotDePasse());
            preparedStatement.setString(3,administrateur.getNom());
            preparedStatement.setString(4,administrateur.getPrenom());
            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();

        }

    }


    public int connexion(String nomUtilisateur, String motPasse) throws InformationsErroneeException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultat = null;
        try {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("SELECT * FROM administrateur where nomUtilisateur = ? and motDePasse = ? ;");
            preparedStatement.setString(1, nomUtilisateur);
            preparedStatement.setString(2, motPasse);
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

    public Administrateur getCompte(String nomUtilisateur, String motPasse) throws InformationsErroneeException {
        int id = connexion(nomUtilisateur, motPasse);
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultat = null;
        try {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("SELECT * FROM administrateur where id = ?;");
            preparedStatement.setInt(1, id);
            preparedStatement.executeQuery();
            resultat = preparedStatement.getResultSet();
            while (resultat.next()) {
                Administrateur administrateur = new Administrateur(resultat.getString("nomUtilisateur"),
                        resultat.getString("motDePasse"),resultat.getString("nom"),
                        resultat.getString("prenom"));
                administrateur.setId(id);
                return administrateur;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;

    }
    public Personnel getPersonnel(String typePersonnel, int idPersonnel){
        Personnel personnel= null;
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;
        try {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            switch (typePersonnel) {
                case "Medecin":
                    resultat = statement.executeQuery("SELECT * FROM medecin where id = "+idPersonnel+ " ;");
                    while (resultat.next()){
                        Medecin medecin = new Medecin(resultat.getString("nom"), resultat.getString("prenom"),
                                resultat.getInt("nbHeures"), resultat.getString("dateNaissance"),
                                resultat.getString("email"), resultat.getString("tel"),resultat.getString("grade"),
                                resultat.getString("specialite"));
                        medecin.setMatricule(resultat.getInt("id"));
                        return medecin;
                    }

                case "Infirmier":
                    resultat = statement.executeQuery("SELECT * FROM infirmier where id = "+idPersonnel+ " ;");
                    while (resultat.next()) {
                        Infirmier infirmier = new Infirmier(resultat.getString("nom"), resultat.getString("prenom"),
                                resultat.getInt("nbHeures"), resultat.getString("dateNaissance"),
                                resultat.getString("email"), resultat.getString("tel"));
                        infirmier.setMatricule(resultat.getInt("id"));
                        return infirmier;
                    }

                case "agentblocoperatoire":
                    resultat = statement.executeQuery("SELECT * FROM AgentBlocOperatoire where id = "+idPersonnel+ " ;");
                    while (resultat.next()) {
                        AgentBlocOperatoire agentBlocOperatoire = new AgentBlocOperatoire(resultat.getString("nom"), resultat.getString("prenom"),
                                resultat.getInt("nbHeures"), resultat.getString("dateNaissance"),
                                resultat.getString("email"), resultat.getString("tel"));
                        agentBlocOperatoire.setMatricule(resultat.getInt("id"));
                        return agentBlocOperatoire;
                    }

                case "agentlaboratoire":
                    resultat = statement.executeQuery("SELECT * FROM AgentLaboratoire where id = "+idPersonnel+ " ;");
                    while (resultat.next()) {
                        AgentLaboratoire agentLaboratoire = new AgentLaboratoire(resultat.getString("nom"), resultat.getString("prenom"),
                                resultat.getInt("nbHeures"), resultat.getString("dateNaissance"),
                                resultat.getString("email"), resultat.getString("tel"));
                        agentLaboratoire.setMatricule(resultat.getInt("id"));
                        return agentLaboratoire;
                    }

                case "agentparamedicale":
                    resultat = statement.executeQuery("SELECT * FROM AgentParamedicale where id = "+idPersonnel+ " ;");
                    while (resultat.next()) {
                        AgentParamedicale agentParamedicale= new AgentParamedicale(resultat.getString("nom"), resultat.getString("prenom"),
                                resultat.getInt("nbHeures"), resultat.getString("dateNaissance"),
                                resultat.getString("email"), resultat.getString("tel"));
                        agentParamedicale.setMatricule(resultat.getInt("id"));
                        return agentParamedicale;
                    }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return personnel;
    }

    public void supprimer(String typePersonnel, int idPersonnel){
        Connection connection =null;
        PreparedStatement preparedStatement = null;
        try{
            connection = daoFactory.getConnection();
                    preparedStatement = connection.prepareStatement("delete from " +typePersonnel+" where id = ? ;");
            preparedStatement.setInt(1,idPersonnel);
            System.out.println(preparedStatement.toString());
            preparedStatement.executeUpdate();
            supprimer(idPersonnel);
        }
        catch(SQLException e){
            e.printStackTrace();
        }

    }

    public void supprimer(int idUtilisateur){
        Connection connection =null;
        PreparedStatement preparedStatement = null;
        try{
            connection = daoFactory.getConnection();
            preparedStatement = connection.prepareStatement("delete from utilisateur where id = ? ;");
            preparedStatement.setInt(1,idUtilisateur);
            preparedStatement.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }

    }

    public void modifier(String typePersonnel,Personnel personnel){
        Connection connection =null;
        PreparedStatement preparedStatement = null;
        try{
            connection = daoFactory.getConnection();
            if(typePersonnel.equals("Medecin")){
                preparedStatement = connection.prepareStatement("update " + typePersonnel + " SET nom = ? prenom = ?" +
                        "nbHeures = ? dateNaissance = ? email = ? tel = ? grade = ?  specialite = ? where id = ? ;");
                preparedStatement.setString(7,((Medecin)personnel).getGrade());
                preparedStatement.setString(8,((Medecin)personnel).getSpecialite());
                preparedStatement.setInt(9,personnel.getMatricule());
            }
            else {
                preparedStatement = connection.prepareStatement("update " + typePersonnel + " SET nom = ? prenom = ?" +
                        "nbHeures = ? dateNaissance = ? email = ? tel = ? where id = ? ;");
                preparedStatement.setInt(7,personnel.getMatricule());
            }

            preparedStatement.setString(1,personnel.getNom());
            preparedStatement.setString(2,personnel.getPrenom());
            preparedStatement.setInt(3,personnel.getNbHeures());
            preparedStatement.setString(4,personnel.getDateNaissance());
            preparedStatement.setString(5,personnel.getEmail());
            preparedStatement.setString(6,personnel.getTel());
            preparedStatement.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }

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

    public void ajouter(Service service)
    {
        Connection connection =null;
        PreparedStatement preparedStatement = null;
        try{
            connection = daoFactory.getConnection();
            preparedStatement = connection.prepareStatement("insert into service(nom,etage,aile) values (?, ?, ?);");
            preparedStatement.setString(1,service.getNom());
            preparedStatement.setInt(2,service.getEtage());
            preparedStatement.setString(3,service.getAile());
            preparedStatement.executeUpdate();
            Statement statement = null;
            ResultSet resultat = null;
            statement = connection.createStatement();
            resultat =statement.executeQuery("SELECT max(id) from service");
            int id =0;
            while (resultat.next()){
                id = resultat.getInt("max(id)");
                break;
            }
            if (id != 0){ //TODO:exeption service non ajouter
            preparedStatement = connection.prepareStatement("insert into chefservice(idMedecin, idService) values (?, ?);");
            preparedStatement.setInt(1,service.getIdChefService());
            preparedStatement.setInt(2,id);
            preparedStatement.executeUpdate();
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }


}




package org.Projet.consumer.ImplemantationInterfaceDao;

import org.Projet.beans.etablisement.Service;
import org.Projet.beans.personnel.personnelDeSante.uniteSoins.Medecin;
import org.Projet.beans.resultat.Rdv;
import org.Projet.consumer.DaoFactory;
import org.Projet.consumer.InterfaceDao.ChefServiceDao;

import java.sql.*;
import java.util.ArrayList;

public class ChefServiceDaoImpl implements ChefServiceDao {
    private DaoFactory daoFactory;

    public ChefServiceDaoImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;

    }

    public void ajouter(int idService, Rdv rdv){
        Connection connection =null;
        PreparedStatement preparedStatement = null;
        try {
            connection = daoFactory.getConnection();
            preparedStatement = connection.prepareStatement("update  medecin set idService = ? where id = ?;");
            preparedStatement.setInt(1,idService);
            preparedStatement.setInt(2,rdv.getIdMedecin());
            preparedStatement.executeUpdate();
            preparedStatement = connection.prepareStatement("insert into rdv(idMedecin,joursTravail) values  (?,?) ;");
            preparedStatement.setInt(1,rdv.getIdMedecin());
            preparedStatement.setString(2,rdv.getJoursTravail().toString());
            preparedStatement.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }

    }

    public Service getService(int idService){
        Service service = null;

        Connection connection =null;
        PreparedStatement preparedStatement = null;
        ResultSet result;
        try {
            connection = daoFactory.getConnection();
            preparedStatement = connection.prepareStatement("select * from service where id = ? ;");
            preparedStatement.setInt(1,idService);
            result =  preparedStatement.executeQuery();
            while (result.next()){
                PreparedStatement preparedStatement2 = connection.prepareStatement("select idMedecin from chefService where " +
                        "idService = ? ;");
                preparedStatement2.setInt(1,idService);
                ResultSet result2 = preparedStatement2.executeQuery();
                int idChefService = 0; //TODO: traiter le cas ou il n'ya pas de chef service
                while (result2.next()){
                    idChefService = result2.getInt("idMedecin");
                    break;
                }
              service = new Service(result.getString("nom"),result.getInt("etage"),
                    result.getString("aile"),idChefService);
                service.setId(idService);
                preparedStatement2 = connection.prepareStatement("select id from medecin where idService = ? ;");
                preparedStatement2.setInt(1,idService);
                result2 = preparedStatement2.executeQuery();
                while (result2.next()){
                    service.getListeMedecin().add(result2.getInt("id"));
                }

            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        //TODO: exeption service non existant

        return service;
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

    public ArrayList<Medecin> listeMedecinsService(int idService)
    {
        ArrayList<Medecin> list = new ArrayList<>();
        Connection connection =null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            connection = daoFactory.getConnection();
            preparedStatement = connection.prepareStatement("select id from medecin where idService = ? ;");
            preparedStatement.setInt(1, idService);
            result = preparedStatement.executeQuery();
            while (result.next()) {
                list.add(getMedecin(result.getInt("id")));
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    public void definirJoursTravailMedecin(ArrayList<String> joursTravail, int idMedecin)
    {
        Connection connection =null;
        PreparedStatement preparedStatement = null;
        try {
            connection = daoFactory.getConnection();
            preparedStatement = connection.prepareStatement("update  rdv set joursTravail = ? where idMedecin = ? ;");
            preparedStatement.setString(1,joursTravail.toString());
            preparedStatement.setInt(2,idMedecin);
            preparedStatement.executeUpdate();

        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }




}

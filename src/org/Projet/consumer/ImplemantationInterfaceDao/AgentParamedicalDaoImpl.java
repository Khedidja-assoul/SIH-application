package org.Projet.consumer.ImplemantationInterfaceDao;

import org.Projet.beans.Utilisateur;
import org.Projet.beans.etablisement.Service;
import org.Projet.beans.patient.Patient;
import org.Projet.beans.personnel.personnelDeSante.uniteSoins.Medecin;
import org.Projet.beans.resultat.DateRdv;
import org.Projet.beans.resultat.HeureRdv;
import org.Projet.beans.resultat.Rdv;
import org.Projet.consumer.DaoFactory;
import org.Projet.consumer.InterfaceDao.AgentParamedicalDao;
import org.Projet.exceptions.InformationDupliquerExeption;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

public class AgentParamedicalDaoImpl implements AgentParamedicalDao {
    private DaoFactory daoFactory;
    final static int nbHeureMax = 5;

    public AgentParamedicalDaoImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

   /****Fonction liee au patient ****/
    @Override
    public int ajouter(Patient patient) {
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

            Statement statement = null;
            ResultSet resultat = null;
            statement = connexion.createStatement();
            resultat = statement.executeQuery("SELECT max(id) from patient");
            while (resultat.next()){
                return resultat.getInt("max(id)");
            }
        }
        catch (SQLException e){
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


    public Rdv getRendezVous(int idMedecin){

        Rdv rdv = null;
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("select * from rdv where idMedecin = ? ;");
            preparedStatement.setInt(1, idMedecin);
            System.out.println(preparedStatement.toString());
            result = preparedStatement.executeQuery();
            while (result.next()) {
                rdv = new Rdv(idMedecin);
                ArrayList<String> joursTravail = new
                        ArrayList<>(Arrays.asList(result.getString("joursTravail").split(",")));
                joursTravail.set(0, joursTravail.get(0).substring(1));
                String s = joursTravail.get(joursTravail.size() - 1);
                joursTravail.set(joursTravail.size() - 1, s.substring(0, s.length() - 1));
                rdv.setJoursTravail(joursTravail);
                int idRdv = result.getInt("id");
                System.out.println("idRdv : "+idRdv);
                rdv.setId(idRdv);
                PreparedStatement preparedStatement2 = connexion.prepareStatement("select * from dateRdv where idRdv = ? ;");

                preparedStatement2.setInt(1, idRdv);
                System.out.println(preparedStatement2.toString());
                ResultSet result2 = preparedStatement2.executeQuery();

                while (result2.next()) {
                    DateRdv dateRdv = new DateRdv(result2.getString("date"), result2.getBoolean("etat"));
                    int idDateRdv = result2.getInt("id");
                    dateRdv.setId(idDateRdv);
                    PreparedStatement preparedStatement3 = connexion.prepareStatement("select * from heureRdv where idDate = ? ;");
                    preparedStatement3.setInt(1, idDateRdv);
                    System.out.println(preparedStatement3.toString());
                    ResultSet result3 = preparedStatement3.executeQuery();
                    int idHeure = 0;
                    ArrayList<HeureRdv> heureRdvs = new ArrayList<>();
                    while (result3.next()) {
                        HeureRdv heureRdv = new HeureRdv(result3.getInt("idPatient"), result3.getInt("idAgent"),
                                result3.getString("heure"));
                        heureRdv.setId(result3.getInt("id"));
                        heureRdv.setIdDate(idDateRdv);
                        heureRdvs.add(heureRdv);
                    }
                    dateRdv.setHeures(heureRdvs);
                    if (result2.getBoolean("etat") == true) rdv.getJoursDisponibles().add(dateRdv);
                    else rdv.getJoursPleins().add(dateRdv);
                }
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return rdv;
    }

    public void ajouterHeureDateDispo(HeureRdv heureRdv) throws InformationDupliquerExeption
    {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;

        try {

            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("select count(heurerdv.id)from heurerdv,daterdv, rdv where  " +
                    "heurerdv.idDate = daterdv.id and daterdv.idRdv = rdv.id and heurerdv.idPatient = ? and daterdv.id = ?;");
            preparedStatement.setInt(1,heureRdv.getIdPatient());
            preparedStatement.setInt(2,heureRdv.getIdDate());
            result = preparedStatement.executeQuery();
            int nbRdv = 0;
            while (result.next()) {
                nbRdv = result.getInt("count(heurerdv.id)");
            }
            if (nbRdv == 0) {
                preparedStatement = connexion.prepareStatement("insert into heureRdv(heure,idDate,idPatient,idAgent) values " +
                        "(?,?,?,?) ;");
                preparedStatement.setString(1, heureRdv.getHeure());
                preparedStatement.setInt(2, heureRdv.getIdDate());
                preparedStatement.setInt(3, heureRdv.getIdPatient());
                preparedStatement.setInt(4, heureRdv.getIdAgent());
                System.out.println(preparedStatement.toString());
                preparedStatement.executeUpdate();
                preparedStatement = connexion.prepareStatement("select count(heure) from heurerdv,daterdv where " +
                        "heurerdv.idDate = daterdv.id and daterdv.id = ?; ");
                preparedStatement.setInt(1, heureRdv.getIdDate());
                result = preparedStatement.executeQuery();
                while (result.next()) {
                    int nbHeures = result.getInt("count(heure)");
                    if (nbHeures >= nbHeureMax) {
                        PreparedStatement preparedStatement1 = connexion.prepareStatement("update dateRdv set etat " +
                                "= false  where id = ? ;");
                        preparedStatement1.setInt(1, heureRdv.getIdDate());
                        preparedStatement1.executeUpdate();
                    }
                    break;

                }
            }
            else throw new InformationDupliquerExeption("Patient a déjà un rendez-vous avec ce médecin, ce jour-là");
        }
        catch (SQLException e){
            e.printStackTrace();
        }

    }

    public void ajouterDate(DateRdv dateRdv ,int idRdv)
    {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("insert into dateRdv(date,idRdv,etat) values " +
                    "(?,?,?) ;");
            preparedStatement.setString(1,dateRdv.getDate());
            preparedStatement.setInt(2,idRdv);
            preparedStatement.setBoolean(3,true);
            preparedStatement.executeUpdate();
            preparedStatement = connexion.prepareStatement("select max(id) from daterdv where " +
                    " date = ? ; ");
            preparedStatement.setString(1,dateRdv.getDate());
            result = preparedStatement.executeQuery();
            while (result.next())
            {
                int idDateRdv = result.getInt("max(id)");

                PreparedStatement preparedStatement1 = connexion.prepareStatement("insert into heureRdv(heure," +
                        "idDate,idPatient,idAgent) values (?,?,?,?) ;");
                    HeureRdv heureRdv = dateRdv.getHeures().get(0);
                    preparedStatement1.setString(1,heureRdv.getHeure());
                    preparedStatement1.setInt(2,idDateRdv );
                    preparedStatement1.setInt(3,heureRdv.getIdPatient());
                    preparedStatement1.setInt(4,heureRdv.getIdAgent());
                    System.out.println(preparedStatement1.toString());
                    preparedStatement1.executeUpdate();

                break;

            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }

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
                return patient;
            }
        }

        catch (SQLException e) {
            e.printStackTrace();
        }
        return patient;
    }


    public Patient getPatient(int id, String nom, String prenom){
        Patient patient = null;
        Connection connexion = null;
        PreparedStatement statement = null;
        ResultSet resultat = null;
        try {
            connexion = daoFactory.getConnection();
            statement= connexion.prepareStatement("SELECT * FROM patient where id = ? and nom = ?and prenom = ?;");
            statement.setInt(1,id);
            statement.setString(2,nom);
            statement.setString(3,prenom);
            resultat = statement.executeQuery();
            while (resultat.next()) {
                patient = new Patient(resultat.getString("nom"),resultat.getString("prenom"),
                        resultat.getString("datenaissance"),resultat.getString("adresse"),
                        resultat.getString("tel"),resultat.getString("email"));
                patient.setMatricule(resultat.getInt("id"));
                return patient;
            }
        }

        catch (SQLException e) {
            e.printStackTrace();
        }
        return patient;
    }
    public ArrayList<Service>  getServices()
    {
        ArrayList<Service> listesService = new ArrayList<>();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("select * from service;");
            System.out.println(preparedStatement);

            result = preparedStatement.executeQuery();
            while (result.next()){
                Service service = new Service(result.getInt("id"),result.getString("nom"));
                System.out.println(service);
                listesService.add(service);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return listesService;
    }

    public ArrayList<Medecin> getMedecinsService(int idService)
        {

            ArrayList<Medecin> listeMedecinsService= new ArrayList<>();
            Connection connexion = null;
            PreparedStatement preparedStatement = null;
            ResultSet result = null;
            try {
                connexion = daoFactory.getConnection();
                preparedStatement = connexion.prepareStatement("select medecin.id,medecin.nom,medecin.prenom " +
                        "from medecin, service where medecin.idService = service.id and service.id = ?;");
                preparedStatement.setInt(1,idService);
                System.out.println(preparedStatement.toString());
                result =  preparedStatement.executeQuery();
                while (result.next()){
                    Medecin medecin= new Medecin(result.getInt("medecin.id"),result.getString("medecin.nom"),
                            result.getString("medecin.prenom"));
                    System.out.println(medecin);
                    listeMedecinsService.add(medecin);
                }
            }
            catch (SQLException e){
                e.printStackTrace();
            }
            return listeMedecinsService;

        }





}

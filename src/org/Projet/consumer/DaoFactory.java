package org.Projet.consumer;


import org.Projet.consumer.ImplemantationInterfaceDao.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoFactory {
    private String url;
    private String username;
    private String password;

    DaoFactory(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public static DaoFactory getInstance() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
        }

        DaoFactory instance = new DaoFactory(
                "jdbc:mysql://localhost:3306/sih_bdd?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                "root", "abdenour1997");
        return instance;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    // Récupération du Dao

    public Object getUtilisateurDao(String typeUtilisateur) {
        switch (typeUtilisateur){
            case "administrateur": return new AdministrateurDaoImpl(this);
            case "agentParamedicale": return new AgentParamedicalDaoImpl(this);
            case "utilisateur" :return new UtilisateurDaoImpl(this);
            case "patient" : return new PatientDaoImpl(this);
            case "medecin": return new MedecinDaoImpl(this);
            case "infirmier": return new InfirmierDaoImpl(this);
            case "agentBlocOperatoire" :return new AgentBlocOperatoireDaoImpl(this);
            case "agentLaboratoire" : return new AgentLaboratoireDaoImpl(this);
        }

        return null;

    }
}
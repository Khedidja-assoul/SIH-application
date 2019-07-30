package org.Projet.consumer;


import org.Projet.consumer.ImplemantationInterfaceDao.AgentParamedicalDaoImpl;
import org.Projet.consumer.InterfaceDao.AdministrateurDao;
import org.Projet.consumer.ImplemantationInterfaceDao.AdministrateurDaoImpl;
import org.Projet.consumer.InterfaceDao.AgentParamedicalDao;

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

        }

        return null;

    }
}
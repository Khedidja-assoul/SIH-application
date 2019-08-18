package org.Projet.consumer.ImplemantationInterfaceDao;

import org.Projet.beans.resultat.ActeComplementaireLaboratoire;
import org.Projet.beans.resultat.Analyse;
import org.Projet.consumer.DaoFactory;
import org.Projet.consumer.InterfaceDao.AgentLaboratoireDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

}

package org.Projet.consumer.ImplemantationInterfaceDao;

import org.Projet.consumer.DaoFactory;
import org.Projet.consumer.InterfaceDao.AgentLaboratoireDao;

public class AgentLaboratoireDaoImpl implements AgentLaboratoireDao {
    private DaoFactory daoFactory;

    public AgentLaboratoireDaoImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;

    }
}

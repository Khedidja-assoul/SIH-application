package org.Projet.consumer.ImplemantationInterfaceDao;

import org.Projet.consumer.DaoFactory;
import org.Projet.consumer.InterfaceDao.AgentBlocOperatoireDao;

public class AgentBlocOperatoireDaoImpl implements AgentBlocOperatoireDao {
    private DaoFactory daoFactory;

    public AgentBlocOperatoireDaoImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;

    }
}

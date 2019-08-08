package org.Projet.consumer.ImplemantationInterfaceDao;

import org.Projet.consumer.DaoFactory;
import org.Projet.consumer.InterfaceDao.InfirmierDao;

public class InfirmierDaoImpl implements InfirmierDao {

    private DaoFactory daoFactory;

    public InfirmierDaoImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;

    }
}

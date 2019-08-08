package org.Projet.consumer.ImplemantationInterfaceDao;

import org.Projet.consumer.DaoFactory;
import org.Projet.consumer.InterfaceDao.MedecinDao;

public class MedecinDaoImpl implements MedecinDao {
    private DaoFactory daoFactory;

    public MedecinDaoImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;

    }
}

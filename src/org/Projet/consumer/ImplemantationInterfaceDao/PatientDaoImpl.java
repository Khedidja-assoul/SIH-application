package org.Projet.consumer.ImplemantationInterfaceDao;

import org.Projet.consumer.DaoFactory;
import org.Projet.consumer.InterfaceDao.PatientDao;

public class PatientDaoImpl implements PatientDao {
    private DaoFactory daoFactory;

    public PatientDaoImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;

    }
}

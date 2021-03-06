package org.Projet.servletes.patient;

import org.Projet.consumer.DaoFactory;
import org.Projet.consumer.ImplemantationInterfaceDao.PatientDaoImpl;
import org.Projet.consumer.InterfaceDao.PatientDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ServletAccueilPatient")
public class ServletAccueilPatient extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private PatientDao patientDao;

    public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.patientDao = (PatientDaoImpl)daoFactory.getUtilisateurDao("patient");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/Patient/Accueil.jsp").forward(request, response);
    }
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {


    }
}

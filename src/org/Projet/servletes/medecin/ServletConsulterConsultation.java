package org.Projet.servletes.medecin;

import org.Projet.beans.patient.Patient;
import org.Projet.beans.resultat.Consultation;
import org.Projet.consumer.DaoFactory;
import org.Projet.consumer.ImplemantationInterfaceDao.MedecinDaoImpl;
import org.Projet.consumer.InterfaceDao.MedecinDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ServletConsulterConsultation")
public class ServletConsulterConsultation extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private MedecinDao medecinDao;

    public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.medecinDao= (MedecinDaoImpl)daoFactory.getUtilisateurDao("medecin");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Consultation consultation = medecinDao.getConsutation(Integer.parseInt(request.getParameter("consulter")));
        Patient patient = medecinDao.getPatient(consultation.getIdPatient());
        request.setAttribute("consultation",consultation);
        request.setAttribute("patient",patient);

    this.getServletContext().getRequestDispatcher("/WEB-INF/Medecin/Consultation.jsp").forward(request, response);
    }
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {


    }
}

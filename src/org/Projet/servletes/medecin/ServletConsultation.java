package org.Projet.servletes.medecin;

import org.Projet.beans.patient.Patient;
import org.Projet.beans.personnel.personnelDeSante.uniteSoins.Medecin;
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
import java.util.ArrayList;

@WebServlet("/ServletConsultation")
public class ServletConsultation extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private MedecinDao medecinDao;

    public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.medecinDao= (MedecinDaoImpl)daoFactory.getUtilisateurDao("medecin");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Medecin medecin = (Medecin) request.getSession().getAttribute("utilisateur");
        int idMedecin = medecin.getMatricule();
        ArrayList<Consultation> listConsultation = medecinDao.afficher(idMedecin);
        ArrayList<Patient> listPatient = new ArrayList<>();
        for (int i = 0; i<listConsultation.size();i++)
        {
           listPatient.add(medecinDao.getPatient(listConsultation.get(i).getIdPatient()));
        }
        request.setAttribute("consultations",listConsultation);
        request.setAttribute("patiens",listPatient);
        this.getServletContext().getRequestDispatcher("/WEB-INF/Medecin/Consultations.jsp").forward(request, response);
    }
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {


    }
}

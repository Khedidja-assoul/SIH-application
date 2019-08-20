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
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/ServletAjouterConsultation")
public class ServletAjouterConsultation extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private MedecinDao medecinDao;

    public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.medecinDao= (MedecinDaoImpl)daoFactory.getUtilisateurDao("medecin");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("nomPatient") !=null) {
            String nomPatient = request.getParameter("nomPatient");
            String prenomPatient = request.getParameter("prenomPatient");
            Patient patient = medecinDao.getPatient(nomPatient, prenomPatient);
            Medecin medecin = (Medecin) request.getSession().getAttribute("utilisateur");
            int idMedecin = medecin.getMatricule();

            Consultation consultation = new Consultation(idMedecin, patient.getMatricule(),
                    request.getParameter("date"), request.getParameter("heure"), request.getParameter("motif"));
            int idConsultation = medecinDao.ajouter(consultation);
            consultation.setId(idConsultation);

            HttpSession session = request.getSession();
            session.setAttribute("consultation",consultation);
            response.sendRedirect("ComposantConsultation");
        }
        else {
            this.getServletContext().getRequestDispatcher("/WEB-INF/Medecin/AjouterConsultation.jsp").forward(request, response);
        }
    }
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {


    }
}

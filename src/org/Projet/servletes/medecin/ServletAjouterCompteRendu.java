package org.Projet.servletes.medecin;

import org.Projet.beans.resultat.CompteRendu;
import org.Projet.beans.resultat.CompteRenduConsultation;
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

@WebServlet("/ServletAjouterCompteRendu")
public class ServletAjouterCompteRendu extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private MedecinDao medecinDao;

    public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.medecinDao= (MedecinDaoImpl)daoFactory.getUtilisateurDao("medecin");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("detaille")!=null){
            Consultation consultation = (Consultation) request.getSession().getAttribute("consultation");
            String detaille = request.getParameter("detaille");
            CompteRenduConsultation compteRenduConsultation = new CompteRenduConsultation(detaille,consultation.getId());

            medecinDao.ajouter(compteRenduConsultation);

            this.getServletContext().getRequestDispatcher("/WEB-INF/Medecin/ComposantConsultation.jsp").forward(request, response);
        }
        else {
            this.getServletContext().getRequestDispatcher("/WEB-INF/Medecin/AjouterCompteRendu.jsp").forward(request, response);
        }
    }
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

    }
}

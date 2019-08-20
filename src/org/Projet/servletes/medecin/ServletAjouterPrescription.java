package org.Projet.servletes.medecin;


import org.Projet.beans.resultat.Consultation;
import org.Projet.beans.resultat.Presecription;
import org.Projet.consumer.DaoFactory;
import org.Projet.consumer.ImplemantationInterfaceDao.MedecinDaoImpl;
import org.Projet.consumer.InterfaceDao.MedecinDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ServletAjouterPrescription")
public class ServletAjouterPrescription extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private MedecinDao medecinDao;

    public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.medecinDao= (MedecinDaoImpl)daoFactory.getUtilisateurDao("medecin");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("detaille")!=null){
                Consultation consultation = (Consultation) request.getSession().getAttribute("consultation");
                System.out.println("l 'id de la consultation est : " + consultation.getId());
                String typePrescription = request.getParameter("typePrescription");
                String detaille = request.getParameter("detaille");
                Presecription presecription= new Presecription(consultation.getId(),typePrescription,detaille);

                medecinDao.ajouter(presecription);

                this.getServletContext().getRequestDispatcher("/WEB-INF/Medecin/ComposantConsultation.jsp").forward(request, response);
        }
        else {
            this.getServletContext().getRequestDispatcher("/WEB-INF/Medecin/AjouterPrescription.jsp").forward(request, response);
        }
    }
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

    }
}

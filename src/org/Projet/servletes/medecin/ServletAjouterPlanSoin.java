package org.Projet.servletes.medecin;

import org.Projet.beans.resultat.Consultation;
import org.Projet.beans.resultat.PlanSoin;
import org.Projet.consumer.DaoFactory;
import org.Projet.consumer.ImplemantationInterfaceDao.MedecinDaoImpl;
import org.Projet.consumer.InterfaceDao.MedecinDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ServletAjouterPlanSoin")
public class ServletAjouterPlanSoin extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private MedecinDao medecinDao;

    public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.medecinDao= (MedecinDaoImpl)daoFactory.getUtilisateurDao("medecin");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameterValues("soins")!=null){
                Consultation consultation = (Consultation) request.getSession().getAttribute("consultation");

                PlanSoin planSoin = new PlanSoin(consultation.getId());
                String liste [] = request.getParameterValues("soins");
                for (int i = 0 ; i < liste.length; i++){
                    planSoin.ajoterSoin(liste[i]);
                }
                medecinDao.ajouter(planSoin);
                this.getServletContext().getRequestDispatcher("/WEB-INF/Medecin/ComposantConsultation.jsp").forward(request, response);
        }
        else {
            this.getServletContext().getRequestDispatcher("/WEB-INF/Medecin/AjouterPlanSoin.jsp").forward(request, response);
        }
    }
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

    }
}

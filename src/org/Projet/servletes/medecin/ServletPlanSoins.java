package org.Projet.servletes.medecin;

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
import java.util.ArrayList;

@WebServlet("/ServletPlanSoins")
public class ServletPlanSoins extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private MedecinDao medecinDao;

    public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.medecinDao= (MedecinDaoImpl)daoFactory.getUtilisateurDao("medecin");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        ArrayList<PlanSoin> liste = medecinDao.getPlanSoin(Integer.parseInt(request.getParameter("idConsultation")));

        request.setAttribute("plansoins",liste);
        this.getServletContext().getRequestDispatcher("/WEB-INF/Medecin/AfficherPlanSoins.jsp").forward(request, response);

    }
}

package org.Projet.servletes.infirmier;

import org.Projet.beans.resultat.PlanSoin;
import org.Projet.consumer.DaoFactory;
import org.Projet.consumer.ImplemantationInterfaceDao.InfirmierDaoImpl;
import org.Projet.consumer.InterfaceDao.InfirmierDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/ServletAfficherPlanSoins")
public class ServletAfficherPlanSoins extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private InfirmierDao infirmierDao;

    public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.infirmierDao= (InfirmierDaoImpl)daoFactory.getUtilisateurDao("infirmier");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("heyy im in th get ");
        int idConsultation = Integer.parseInt(request.getParameter("idConsultation"));
        int idPatient = Integer.parseInt(request.getParameter("idPatient"));
        int idMedecin = Integer.parseInt(request.getParameter("idMedecin"));
        ArrayList<PlanSoin> planSoins = infirmierDao.getPlansSoins(idConsultation);
        request.setAttribute("planSoins",planSoins);
        this.getServletContext().getRequestDispatcher("/WEB-INF/Infirmier/AfficherPlanSoins.jsp").forward(request, response);
    }
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
    }
}

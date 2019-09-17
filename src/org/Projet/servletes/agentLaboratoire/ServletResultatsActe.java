package org.Projet.servletes.agentLaboratoire;

import org.Projet.beans.resultat.ActeComplementaireLaboratoire;
import org.Projet.beans.resultat.Analyse;
import org.Projet.beans.resultat.ResultatBiologique;
import org.Projet.consumer.DaoFactory;
import org.Projet.consumer.ImplemantationInterfaceDao.AgentLaboratoireDaoImpl;
import org.Projet.consumer.InterfaceDao.AgentLaboratoireDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/ServletResultatsActe")
public class ServletResultatsActe extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private AgentLaboratoireDao agentLaboratoireDao;

    public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.agentLaboratoireDao= (AgentLaboratoireDaoImpl)daoFactory.getUtilisateurDao("agentLaboratoire");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idActe = Integer.parseInt(request.getParameter("idActe"));
        int idConsultation = Integer.parseInt(request.getParameter("idConsultation"));
        int idPatient = Integer.parseInt(request.getParameter("idPatient"));
        int idMedecin = Integer.parseInt(request.getParameter("idMedecin"));
        int idAnalyse = Integer.parseInt(request.getParameter("idAnalyse"));
        ResultatBiologique resultatBiologique = agentLaboratoireDao.getResultatBiologique(idActe);
        Analyse analyse = agentLaboratoireDao.getAnalyse(idAnalyse);
        request.setAttribute("resulatats",resultatBiologique);
        request.setAttribute("analyse",analyse);
        this.getServletContext().getRequestDispatcher
                ("/WEB-INF/AgentLaboratoire/ResultatsActe.jsp").forward(request, response);
    }
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {


    }
}

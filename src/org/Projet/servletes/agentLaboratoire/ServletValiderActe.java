package org.Projet.servletes.agentLaboratoire;

import org.Projet.beans.Utilisateur;
import org.Projet.beans.personnel.personnelDeSante.medicoTechenique.AgentLaboratoire;
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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/ServletValiderActe")
public class ServletValiderActe extends HttpServlet {

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
        ActeComplementaireLaboratoire acteComplementaireLaboratoire = agentLaboratoireDao.getDemandeActe(idActe);
        Analyse analyse = agentLaboratoireDao.getAnalyse(acteComplementaireLaboratoire.getIdAnalyse());
        request.setAttribute("idActe",idActe);
        request.setAttribute("analyse",analyse);
        this.getServletContext().getRequestDispatcher
                ("/WEB-INF/AgentLaboratoire/ValiderActeLabo.jsp").forward(request, response);
    }
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        HttpSession session = request.getSession();
        int idActe = Integer.parseInt(request.getParameter("idActe"));
        int idAgentAgentLabo = ((AgentLaboratoire)session.getAttribute("utilisateur")).getMatricule();
        String heure = request.getParameter("heure");
        String date = request.getParameter("date");
        ArrayList<Float> listeValeur = new ArrayList<>();
        for (int i = 0 ; i < request.getParameterValues("valeur").length;i++)
        {
            System.out.println(Float.parseFloat(request.getParameterValues("valeur")[i]));
            listeValeur.add(Float.parseFloat(request.getParameterValues("valeur")[i]));
        }
        ResultatBiologique resultatBiologique = new ResultatBiologique(idActe,idAgentAgentLabo,date,heure);
        resultatBiologique.setResultat(listeValeur);
        agentLaboratoireDao.validerActe(resultatBiologique);

    }
}

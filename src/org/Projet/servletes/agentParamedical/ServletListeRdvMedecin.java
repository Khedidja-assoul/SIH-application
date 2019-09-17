package org.Projet.servletes.agentParamedical;

import org.Projet.beans.personnel.personnelDeSante.uniteSoins.Medecin;
import org.Projet.beans.resultat.Rdv;
import org.Projet.consumer.DaoFactory;
import org.Projet.consumer.ImplemantationInterfaceDao.AgentParamedicalDaoImpl;
import org.Projet.consumer.InterfaceDao.AgentParamedicalDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/ServletListeRdvMedecin")
public class ServletListeRdvMedecin extends HttpServlet {


    private static final long serialVersionUID = 1L;
    private AgentParamedicalDao agentParamedicalDao;

    public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.agentParamedicalDao = (AgentParamedicalDaoImpl) daoFactory.getUtilisateurDao("agentParamedicale");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("idMedecin") != null && !request.getParameter("idMedecin").equals("")) {
            int idMedecin = Integer.parseInt(request.getParameter("idMedecin"));
            Rdv rdv = agentParamedicalDao.getRendezVous(idMedecin);
            HttpSession session = request.getSession();
            session.setAttribute("rdv", rdv);
            request.setAttribute("rdv", rdv);
        }
        this.getServletContext().getRequestDispatcher("/WEB-INF/AgentParamedicale/GestionRdvs.jsp").forward(request, response);
    }
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

    }
}

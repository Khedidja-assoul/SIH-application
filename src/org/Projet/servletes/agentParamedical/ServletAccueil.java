package org.Projet.servletes.agentParamedical;

import org.Projet.beans.patient.Patient;
import org.Projet.beans.personnel.agentParamedicale.AgentParamedicale;
import org.Projet.consumer.DaoFactory;
import org.Projet.consumer.ImplemantationInterfaceDao.AgentParamedicalDaoImpl;
import org.Projet.consumer.InterfaceDao.AgentParamedicalDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ServletAccueil")
public class ServletAccueil extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private AgentParamedicalDao agentParamedicalDao;

    public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.agentParamedicalDao = (AgentParamedicalDaoImpl)daoFactory.getUtilisateurDao("agentParamedicale");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           this.getServletContext().getRequestDispatcher("/WEB-INF/AgentParamedicale/Accueil.jsp").forward(request, response);
    }
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {


    }

}

package org.Projet.servletes.agentBlocOperatoire;

import org.Projet.consumer.DaoFactory;
import org.Projet.consumer.ImplemantationInterfaceDao.AgentBlocOperatoireDaoImpl;
import org.Projet.consumer.InterfaceDao.AgentBlocOperatoireDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/ServletAccueilAgentBloc ")
public class ServletAccueilAgentBloc extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AgentBlocOperatoireDao agentBlocOperatoireDao;

    public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.agentBlocOperatoireDao= (AgentBlocOperatoireDaoImpl)daoFactory.getUtilisateurDao("agentBlocOperatoire");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/AgentBlocOperatoire/Accueil.jsp").forward(request, response);
    }
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {


    }
}

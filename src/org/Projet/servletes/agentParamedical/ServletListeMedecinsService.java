package org.Projet.servletes.agentParamedical;

import org.Projet.beans.etablisement.Service;
import org.Projet.beans.personnel.personnelDeSante.uniteSoins.Medecin;
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

@WebServlet("/ServletListeMedecinsService")
public class ServletListeMedecinsService extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private AgentParamedicalDao agentParamedicalDao;

    public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.agentParamedicalDao = (AgentParamedicalDaoImpl)daoFactory.getUtilisateurDao("agentParamedicale");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("idService") != null && !request.getParameter("idService").equals("")){
            System.out.println("servlet liste medecin service");
            int idService = Integer.parseInt(request.getParameter("idService"));
            ArrayList<Medecin> listeMedecins = agentParamedicalDao.getMedecinsService(idService);
            request.setAttribute("listeMedecins",listeMedecins);
            this.getServletContext().getRequestDispatcher("/WEB-INF/AgentParamedicale/GestionRdvs.jsp").forward(request, response);
        }
    }
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

    }
}

package org.Projet.servletes.agentParamedical;

import org.Projet.beans.patient.Patient;
import org.Projet.consumer.DaoFactory;
import org.Projet.consumer.ImplemantationInterfaceDao.AgentParamedicalDaoImpl;
import org.Projet.consumer.InterfaceDao.AgentParamedicalDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ServletGestionPatient")

public class ServletGestionPatient extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AgentParamedicalDao agentParamedicalDao;

    public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.agentParamedicalDao = (AgentParamedicalDaoImpl)daoFactory.getUtilisateurDao("agentParamedicale");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.getServletContext().getRequestDispatcher("/WEB-INF/AgentParamedicale/GestionPatient.jsp").forward(request, response);
    }
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        Patient patient = new Patient(request.getParameter("nom"),request.getParameter("prenom"),request.getParameter("dateNaissance"),
                request.getParameter("adresse"),request.getParameter("tel"),request.getParameter("email"));
        agentParamedicalDao.ajouter(patient);
        this.getServletContext().getRequestDispatcher("/WEB-INF/AgentParamedicale/GestionPatient.jsp").forward(request, response);

    }

}

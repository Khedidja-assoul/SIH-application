package org.Projet.servletes.agentParamedical;

import org.Projet.beans.Utilisateur;
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
        int id = agentParamedicalDao.ajouter(patient);

        //A l'ajout d'un mombre du personnel on ajoute un compte avec comme valeur par defaut  nomUtilisateur :
        //nomUtilisateur : @mail / mot de passe :nom+prenom le tout en miniscule

        String motPasse = request.getParameter("nom").toLowerCase()+request.getParameter("prenom").toLowerCase();
        Utilisateur compte = new Utilisateur(request.getParameter("email"),motPasse,"patient",id);
        agentParamedicalDao.ajouter(compte);

        this.getServletContext().getRequestDispatcher("/WEB-INF/AgentParamedicale/GestionPatient.jsp").forward(request, response);

    }

}

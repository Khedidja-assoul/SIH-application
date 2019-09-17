package org.Projet.servletes.general;

import org.Projet.beans.Authentifiable;
import org.Projet.beans.patient.Patient;
import org.Projet.beans.personnel.Personnel;
import org.Projet.beans.personnel.personnelDeSante.uniteSoins.Medecin;
import org.Projet.consumer.DaoFactory;
import org.Projet.consumer.ImplemantationInterfaceDao.AgentParamedicalDaoImpl;
import org.Projet.consumer.ImplemantationInterfaceDao.UtilisateurDaoImpl;
import org.Projet.consumer.InterfaceDao.AgentParamedicalDao;
import org.Projet.consumer.InterfaceDao.UtilisateurDao;
import org.Projet.exceptions.InformationsErroneeException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/ServletAuthentification")
public class ServletAuthentification  extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UtilisateurDao utilisateurDao;

    public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.utilisateurDao = (UtilisateurDaoImpl)daoFactory.getUtilisateurDao("utilisateur");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.getServletContext().getRequestDispatcher("/WEB-INF/General/Authentification.jsp").forward(request, response);
    }
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        try {

                Authentifiable utilisateur = utilisateurDao.getCompte(request.getParameter("nomUtilisateur"),
                        request.getParameter("motPasse"), request.getParameter("typeUtilisateur"));
                request.setAttribute("utilisateur", utilisateur);
                System.out.println(utilisateur);
                if (request.getParameter("typeUtilisateur").equals("agentparamedicale")) {
                    HttpSession session = request.getSession();
                    session.setAttribute("utilisateur", utilisateur);
                    response.sendRedirect("AccueilAgentParamedicale");
                } else if (request.getParameter("typeUtilisateur").equals("medecin")) {
                    if(request.getParameter("chefservice") != null) {
                        if (request.getParameter("chefservice").equals("true")) {
                            int idService = utilisateurDao.isChefService(((Medecin) utilisateur).getMatricule());
                            HttpSession session = request.getSession();
                            session.setAttribute("utilisateur", utilisateur);
                            session.setAttribute("idService", idService);
                            response.sendRedirect("AccueilChefService");
                        }
                    }
                    else {
                        HttpSession session = request.getSession();
                        session.setAttribute("utilisateur", utilisateur);
                        response.sendRedirect("AccueilMedecin");
                    }
                } else if (request.getParameter("typeUtilisateur").equals("infirmier")) {
                    HttpSession session = request.getSession();
                    session.setAttribute("utilisateur", utilisateur);
                    response.sendRedirect("AccueilInfirmier");
                } else if (request.getParameter("typeUtilisateur").equals("agentlaboratoire")) {
                    HttpSession session = request.getSession();
                    session.setAttribute("utilisateur", utilisateur);
                    response.sendRedirect("AccueilAgentLaboratoire");
                } else if (request.getParameter("typeUtilisateur").equals("agentblocoperatoire")) {
                    HttpSession session = request.getSession();
                    session.setAttribute("utilisateur", utilisateur);
                    response.sendRedirect("AccueilBlocOperatoire");
                } else if (request.getParameter("typeUtilisateur").equals("patient")) {
                    HttpSession session = request.getSession();
                    session.setAttribute("utilisateur", utilisateur);
                    response.sendRedirect("AccueilPatient");

            }


         }
         catch (InformationsErroneeException e){
             request.setAttribute("erreur",e.getMessage());
             this.getServletContext().getRequestDispatcher("/WEB-INF/General/Authentification.jsp").forward(request, response);
         }
        //this.getServletContext().getRequestDispatcher("/WEB-INF/General/Authentification.jsp").forward(request, response);

    }
}

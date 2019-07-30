package org.Projet.servletes.administrateur;

import org.Projet.beans.personnel.Personnel;
import org.Projet.beans.personnel.agentParamedicale.AgentParamedicale;
import org.Projet.beans.personnel.personnelDeSante.medicoTechenique.AgentBlocOperatoire;
import org.Projet.beans.personnel.personnelDeSante.medicoTechenique.AgentLaboratoire;
import org.Projet.beans.personnel.personnelDeSante.uniteSoins.Infirmier;
import org.Projet.beans.personnel.personnelDeSante.uniteSoins.Medecin;
import org.Projet.consumer.DaoFactory;
import org.Projet.consumer.ImplemantationInterfaceDao.AdministrateurDaoImpl;
import org.Projet.consumer.InterfaceDao.AdministrateurDao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SevletGetionPersonnel")

public class SevletGetionPersonnel extends HttpServlet{
    private static final long serialVersionUID = 1L;
    private AdministrateurDao administrateurDao;

    public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.administrateurDao= (AdministrateurDaoImpl) daoFactory.getUtilisateurDao("administrateur");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.getServletContext().getRequestDispatcher("/WEB-INF/Administrateur/GestionPersonnel.jsp").forward(request, response);
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        Personnel personnel = null;
        String typePersonnel = request.getParameter("typePersonnel");
        if (request.getParameter("typePersonnel")!=null) {
            switch (typePersonnel) {
                case "Medecin":
                    personnel = new Medecin(request.getParameter("nom"), request.getParameter("prenom"),
                            Integer.parseInt(request.getParameter("nbHeures")), request.getParameter("dateNaissance"),
                            request.getParameter("email"), request.getParameter("tel"), request.getParameter("grade"),
                            request.getParameter("specialite"));
                    break;

                case "Infirmier":
                    personnel = new Infirmier(request.getParameter("nom"), request.getParameter("prenom"),
                            Integer.parseInt(request.getParameter("nbHeures")), request.getParameter("dateNaissance"),
                            request.getParameter("email"), request.getParameter("tel"));
                    System.out.println("\n type chois i\n" + typePersonnel);
                    break;

                case "Agent bloc operatoire":
                    personnel = new AgentBlocOperatoire(request.getParameter("nom"), request.getParameter("prenom"),
                            Integer.parseInt(request.getParameter("nbHeures")), request.getParameter("dateNaissance"),
                            request.getParameter("email"), request.getParameter("tel"));
                    break;

                case "Agent laboratoire":
                    personnel = new AgentLaboratoire(request.getParameter("nom"), request.getParameter("prenom"),
                            Integer.parseInt(request.getParameter("nbHeures")), request.getParameter("dateNaissance"),
                            request.getParameter("email"), request.getParameter("tel"));
                    break;

                case "Agent paramedicale":
                    personnel = new AgentParamedicale(request.getParameter("nom"), request.getParameter("prenom"),
                            Integer.parseInt(request.getParameter("nbHeures")), request.getParameter("dateNaissance"),
                            request.getParameter("email"), request.getParameter("tel"));
                    break;

            }

            administrateurDao.ajouter(personnel, typePersonnel);
        }
        if (request.getParameter("typePersonnelAffichier")!=null) {
            request.setAttribute("personnels", administrateurDao.affichierPersonnels(request.getParameter("typePersonnelAffichier")));
        }


        this.getServletContext().getRequestDispatcher("/WEB-INF/Administrateur/GestionPersonnel.jsp").forward(request, response);
    }


}

package org.Projet.servletes.administrateur;

import org.Projet.beans.Utilisateur;
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
        String id ;
        if(request.getParameter("personnelSupp")!=null){
            id =  request.getParameter("personnelSupp");
            String typePersonnelSupprimer = request.getParameter("typePersonnelSupprimer");
            System.out.println(id +" type : "+typePersonnelSupprimer);
            administrateurDao.supprimer(typePersonnelSupprimer,Integer.parseInt(id));
        }

        if(request.getParameter("personnelModif")!=null){
            id =  request.getParameter("personnelModif");
            String typePersonnelModifier = request.getParameter("typePersonnelModifier");
            System.out.println(id +" type : "+typePersonnelModifier);

        }

        this.getServletContext().getRequestDispatcher("/WEB-INF/Administrateur/GestionPersonnel.jsp").forward(request, response);
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        Personnel personnel = null;
        String typePersonnel = request.getParameter("typePersonnel");
        if (request.getParameter("typePersonnel")!=null) {
            switch (typePersonnel) {
                case "medecin":
                    personnel = new Medecin(request.getParameter("nom"), request.getParameter("prenom"),
                            Integer.parseInt(request.getParameter("nbHeures")), request.getParameter("dateNaissance"),
                            request.getParameter("email"), request.getParameter("tel"), request.getParameter("grade"),
                            request.getParameter("specialite"));
                    break;

                case "infirmier":
                    personnel = new Infirmier(request.getParameter("nom"), request.getParameter("prenom"),
                            Integer.parseInt(request.getParameter("nbHeures")), request.getParameter("dateNaissance"),
                            request.getParameter("email"), request.getParameter("tel"));
                    break;

                case "agentblocoperatoire":
                    personnel = new AgentBlocOperatoire(request.getParameter("nom"), request.getParameter("prenom"),
                            Integer.parseInt(request.getParameter("nbHeures")), request.getParameter("dateNaissance"),
                            request.getParameter("email"), request.getParameter("tel"));
                    break;

                case "agentlaboratoire":
                    personnel = new AgentLaboratoire(request.getParameter("nom"), request.getParameter("prenom"),
                            Integer.parseInt(request.getParameter("nbHeures")), request.getParameter("dateNaissance"),
                            request.getParameter("email"), request.getParameter("tel"));
                    break;

                case "agentparamedicale":
                    personnel = new AgentParamedicale(request.getParameter("nom"), request.getParameter("prenom"),
                            Integer.parseInt(request.getParameter("nbHeures")), request.getParameter("dateNaissance"),
                            request.getParameter("email"), request.getParameter("tel"));
                    break;

            }
            //A l'ajout d'un mombre du personnel on ajoute un compte avec comme valeur par defaut  nomUtilisateur :
            //nomUtilisateur : @mail mot de passe :nom+prenom le tout en miniscule
            int id = administrateurDao.ajouter(personnel, typePersonnel);
            String motPasse = request.getParameter("nom").toLowerCase()+request.getParameter("prenom").toLowerCase();
            Utilisateur compte = new Utilisateur(request.getParameter("email"),motPasse,typePersonnel,id);
            administrateurDao.ajouter(compte);
        }
        if (request.getParameter("typePersonnelAffichier")!=null) {
            request.setAttribute("typePersonnelSupprimer",request.getParameter("typePersonnelAffichier"));
            request.setAttribute("typePersonnelModifier",request.getParameter("typePersonnelAffichier"));
            System.out.println("type : "+request.getParameter("typePersonnelAffichier"));
            request.setAttribute("personnels", administrateurDao.affichierPersonnels(request.getParameter("typePersonnelAffichier")));
        }


        this.getServletContext().getRequestDispatcher("/WEB-INF/Administrateur/GestionPersonnel.jsp").forward(request, response);
    }


}

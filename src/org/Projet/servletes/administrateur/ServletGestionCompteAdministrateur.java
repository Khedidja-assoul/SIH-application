package org.Projet.servletes.administrateur;

import org.Projet.beans.Administrateur;
import org.Projet.consumer.DaoFactory;
import org.Projet.consumer.ImplemantationInterfaceDao.AdministrateurDaoImpl;
import org.Projet.consumer.InterfaceDao.AdministrateurDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ServletGestionCompteAdministrateur")
public class ServletGestionCompteAdministrateur extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AdministrateurDao administrateurDao;

    public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.administrateurDao= (AdministrateurDaoImpl) daoFactory.getUtilisateurDao("administrateur");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.getServletContext().getRequestDispatcher("/WEB-INF/Administrateur/GestionComptesAdministrateurs.jsp").forward(request, response);
    }
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        Administrateur administrateur = new Administrateur(request.getParameter("nomUtilisateur"),
                request.getParameter("motDePasse"),request.getParameter("nom"),request.getParameter("prenom"));
        System.out.println(administrateur.toString());
        administrateurDao.ajouter(administrateur);
        request.setAttribute("message","Creation du compte avec succès");
        this.getServletContext().getRequestDispatcher("/WEB-INF/Administrateur/GestionComptesAdministrateurs.jsp").forward(request, response);
    }


}

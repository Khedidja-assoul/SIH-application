package org.Projet.servletes.administrateur;

import org.Projet.beans.etablisement.Service;
import org.Projet.consumer.DaoFactory;
import org.Projet.consumer.InterfaceDao.AdministrateurDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ServletAjouterService")
public class ServletAjouterService extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private AdministrateurDao administrateurDao;

    public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.administrateurDao = (AdministrateurDao) daoFactory.getUtilisateurDao("administrateur");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.getServletContext().getRequestDispatcher("/WEB-INF/Administrateur/AjouterService.jsp").forward(request, response);
    }
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        if (administrateurDao.getMedecin(Integer.parseInt(request.getParameter("idchef"))) != null) {
            Service service = new Service(request.getParameter("nom"), Integer.parseInt(request.getParameter("etage")),
                    request.getParameter("aile"), Integer.parseInt(request.getParameter("idchef")));
            administrateurDao.ajouter(service);
        }
        else System.out.println("Identifiant medecin inexistant"); //TODO: exeption


        this.getServletContext().getRequestDispatcher("/WEB-INF/Administrateur/AjouterService.jsp").forward(request, response);

    }

}

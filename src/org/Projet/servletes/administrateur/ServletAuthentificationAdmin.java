package org.Projet.servletes.administrateur;

import org.Projet.beans.Administrateur;
import org.Projet.beans.etablisement.Chambre;
import org.Projet.consumer.DaoFactory;
import org.Projet.consumer.ImplemantationInterfaceDao.AdministrateurDaoImpl;
import org.Projet.consumer.InterfaceDao.AdministrateurDao;
import org.Projet.exceptions.InformationsErroneeException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/ServletAuthentificationAdmin")
public class ServletAuthentificationAdmin extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AdministrateurDao administrateurDao;

    public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.administrateurDao= (AdministrateurDaoImpl) daoFactory.getUtilisateurDao("administrateur");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/Administrateur/AuthentificationAdmin.jsp").forward(request, response);

    }

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        try {
            Administrateur administrateur = administrateurDao.getCompte(request.getParameter("nomUtilisateur")
                    ,request.getParameter("motDePasse"));
            HttpSession session = request.getSession();
            session.setAttribute("administrateur",administrateur);
            response.sendRedirect("AccueilAdministrateur");
        }
        catch (InformationsErroneeException e) {
            request.setAttribute("erreur",e.getMessage());
            this.getServletContext().getRequestDispatcher("/WEB-INF/Administrateur/AuthentificationAdmin.jsp").forward(request, response);
        }
    }

}

package org.Projet.servletes.administrateur;

import org.Projet.beans.etablisement.Chambre;
import org.Projet.consumer.DaoFactory;
import org.Projet.consumer.ImplemantationInterfaceDao.AdministrateurDaoImpl;
import org.Projet.consumer.InterfaceDao.AdministrateurDao;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ServletGestionChambre")
public class ServletGestionChambre extends HttpServlet {

        private static final long serialVersionUID = 1L;
        private AdministrateurDao administrateurDao;

        public void init() throws ServletException {
            DaoFactory daoFactory = DaoFactory.getInstance();
            this.administrateurDao= (AdministrateurDaoImpl)daoFactory.getUtilisateurDao("administrateur");
        }

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            this.getServletContext().getRequestDispatcher("/WEB-INF/Administrateur/GestionChambre.jsp").forward(request, response);
        }

        public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

            Chambre chambre = new Chambre(Integer.parseInt(request.getParameter("num")),Integer.parseInt(request.getParameter("etage")),
                    Integer.parseInt(request.getParameter("nbLits")));
            administrateurDao.ajouter(chambre);

            this.getServletContext().getRequestDispatcher("/WEB-INF/Administrateur/GestionChambre.jsp").forward(request, response);
        }


}




package org.Projet.servletes.infirmier;

import org.Projet.consumer.DaoFactory;
import org.Projet.consumer.ImplemantationInterfaceDao.InfirmierDaoImpl;
import org.Projet.consumer.InterfaceDao.InfirmierDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ServletAccueilInfirmier")
public class ServletAccueilInfirmier extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private InfirmierDao infirmierDao;

    public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.infirmierDao= (InfirmierDaoImpl)daoFactory.getUtilisateurDao("Infirmier");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/Infirmier/Accueil.jsp").forward(request, response);
    }
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {


    }
}

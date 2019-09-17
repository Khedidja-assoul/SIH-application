package org.Projet.servletes.chefService;

import org.Projet.consumer.DaoFactory;
import org.Projet.consumer.ImplemantationInterfaceDao.ChefServiceDaoImpl;
import org.Projet.consumer.InterfaceDao.ChefServiceDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/ServletEmploiDuTemps")
public class ServletEmploiDuTemps extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ChefServiceDao chefServiceDao;

    public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.chefServiceDao = (ChefServiceDaoImpl)daoFactory.getUtilisateurDao("chefService");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.getServletContext().getRequestDispatcher("/WEB-INF/ChefService/EmploiDuTemps.jsp").forward(request, response);
    }
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {


    }
}

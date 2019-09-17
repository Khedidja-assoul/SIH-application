package org.Projet.servletes.chefService;

import jdk.internal.org.objectweb.asm.Handle;
import org.Projet.beans.etablisement.Service;
import org.Projet.beans.personnel.personnelDeSante.uniteSoins.Medecin;
import org.Projet.beans.resultat.Rdv;
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
import java.util.ArrayList;

@WebServlet("/ServletMedecinService")
public class ServletMedecinService extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ChefServiceDao chefServiceDao;

    public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.chefServiceDao = (ChefServiceDaoImpl)daoFactory.getUtilisateurDao("chefService");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        int idService= ((Integer) session.getAttribute("idService"));
        ArrayList<Medecin> listeMedecinService = chefServiceDao.listeMedecinsService(idService);
        session.setAttribute("listeMedecinService",listeMedecinService);

        this.getServletContext().getRequestDispatcher("/WEB-INF/ChefService/GestionMedecinService.jsp").forward(request, response);
    }
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        int idMedecin = Integer.parseInt(request.getParameter("idMedecin"));
        HttpSession session = request.getSession();
        int  idService = (Integer) session.getAttribute("idService");
        Rdv rdv = new Rdv(idMedecin);
        String [] jours = request.getParameterValues("jours");
        for (int i =0 ; i<jours.length ; i++)
        {
            rdv.getJoursTravail().add(jours[i]);
        }
        chefServiceDao.ajouter(idService,rdv);
        response.sendRedirect("GestionMedecinService");
    }
}

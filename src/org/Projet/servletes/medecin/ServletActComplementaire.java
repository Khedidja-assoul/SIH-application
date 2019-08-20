package org.Projet.servletes.medecin;

import org.Projet.beans.resultat.ActeComplementaireLaboratoire;
import org.Projet.beans.resultat.CompteRenduConsultation;
import org.Projet.consumer.DaoFactory;
import org.Projet.consumer.ImplemantationInterfaceDao.MedecinDaoImpl;
import org.Projet.consumer.InterfaceDao.MedecinDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/ServletActComplementaire")
public class ServletActComplementaire extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private MedecinDao medecinDao;

    public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.medecinDao= (MedecinDaoImpl)daoFactory.getUtilisateurDao("medecin");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ArrayList<ActeComplementaireLaboratoire> list =
                medecinDao.getActeComplementaireLaboratoire(Integer.parseInt(request.getParameter("actecomplementaire")));
        request.setAttribute("list",list);
        this.getServletContext().getRequestDispatcher("/WEB-INF/Medecin/ActeComplementaire.jsp").forward(request, response);
    }
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {


    }
}

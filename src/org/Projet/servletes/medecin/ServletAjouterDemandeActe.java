package org.Projet.servletes.medecin;

import org.Projet.beans.resultat.ActeComplementaireLaboratoire;
import org.Projet.beans.resultat.Consultation;
import org.Projet.consumer.DaoFactory;
import org.Projet.consumer.ImplemantationInterfaceDao.MedecinDaoImpl;
import org.Projet.consumer.InterfaceDao.MedecinDao;
import org.Projet.exceptions.InformationDupliquerExeption;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ServletAjouterDemandeActe")
public class ServletAjouterDemandeActe extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private MedecinDao medecinDao;

    public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.medecinDao= (MedecinDaoImpl)daoFactory.getUtilisateurDao("medecin");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
        if (request.getParameter("typeActe")!=null){
            if (request.getParameter("typeActe").equals("actecomplementairelabo")){
                Consultation consultation = (Consultation) request.getSession().getAttribute("consultation");
                System.out.println("l 'id de la consultation est : " + consultation.getId());
                String analyse = request.getParameter("analyse");
                ActeComplementaireLaboratoire actLabo = new ActeComplementaireLaboratoire(consultation.getId(),
                        medecinDao.getAnalyse(analyse).getId());
                medecinDao.ajouter(actLabo);

                this.getServletContext().getRequestDispatcher("/WEB-INF/Medecin/ComposantConsultation.jsp").forward(request, response);

            }
            else if (request.getParameter("typeActe").equals("actecomplementairebloc")){
                this.getServletContext().getRequestDispatcher("/WEB-INF/Medecin/AjouterDemandeActe.jsp").forward(request, response);
            }
        }
        else {
            this.getServletContext().getRequestDispatcher("/WEB-INF/Medecin/AjouterDemandeActe.jsp").forward(request, response);
        }
    }
        catch (InformationDupliquerExeption e){
        request.setAttribute("erreur",e.getMessage());
        this.getServletContext().getRequestDispatcher("/WEB-INF/Medecin/AjouterDemandeActe.jsp").forward(request, response);
        }
    }
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

    }
}

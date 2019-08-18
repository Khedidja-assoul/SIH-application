package org.Projet.servletes.medecin;

import org.Projet.beans.resultat.ActeComplementaireLaboratoire;
import org.Projet.beans.resultat.Consultation;
import org.Projet.consumer.DaoFactory;
import org.Projet.consumer.ImplemantationInterfaceDao.MedecinDaoImpl;
import org.Projet.consumer.InterfaceDao.MedecinDao;

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
        if (request.getParameter("typeActe")!=null){
            if (request.getParameter("typeActe").equals("actecomplementairelabo")){
                Consultation consultation = (Consultation) request.getSession().getAttribute("consultation");
                System.out.println("l 'id de la consultation est : " + consultation.getId());
                ActeComplementaireLaboratoire actLabo = new ActeComplementaireLaboratoire(consultation.getId());
                String liste [] = request.getParameterValues("analyse");
                for (int i = 0 ; i < liste.length; i++){
                    System.out.println("l'analyse a ajouter est : "+ liste[i]);
                    actLabo.ajouterAnalyse(medecinDao.getAnalyse(liste[i]).getId());
                }
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
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

    }
}

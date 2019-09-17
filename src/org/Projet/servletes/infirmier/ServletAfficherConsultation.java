package org.Projet.servletes.infirmier;

import org.Projet.beans.personnel.personnelDeSante.uniteSoins.Medecin;
import org.Projet.beans.resultat.Consultation;
import org.Projet.consumer.DaoFactory;
import org.Projet.consumer.ImplemantationInterfaceDao.InfirmierDaoImpl;
import org.Projet.consumer.InterfaceDao.InfirmierDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/ServletAfficherConsultation")
public class ServletAfficherConsultation extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private InfirmierDao infirmierDao;

    public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.infirmierDao= (InfirmierDaoImpl)daoFactory.getUtilisateurDao("infirmier");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getParameter("idPatient") != null){
            if (!request.getParameter("idPatient").equals(""))
            {
                int idPatient = Integer.parseInt(request.getParameter("idPatient"));
                ArrayList<Consultation> consultations = infirmierDao.afficherPlansDeSoin(idPatient);
                ArrayList<Medecin> medecins = new ArrayList<>();
                for(int i = 0; i<consultations.size();i++)
                {
                    medecins.add(infirmierDao.getMedecin(consultations.get(i).getIdMedecin()));
                }
                request.setAttribute("listeConsultation",consultations);
                request.setAttribute("listeMedecins",medecins);
            }
        }
        this.getServletContext().getRequestDispatcher("/WEB-INF/Infirmier/AfficherPlansSoins.jsp").forward(request, response);
    }
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {


    }
}

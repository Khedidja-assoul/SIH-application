package org.Projet.servletes.agentParamedical;

import org.Projet.beans.etablisement.Service;
import org.Projet.beans.patient.Patient;
import org.Projet.beans.personnel.agentParamedicale.AgentParamedicale;
import org.Projet.beans.personnel.personnelDeSante.uniteSoins.Medecin;
import org.Projet.beans.resultat.DateRdv;
import org.Projet.beans.resultat.HeureRdv;
import org.Projet.beans.resultat.Rdv;
import org.Projet.consumer.DaoFactory;
import org.Projet.consumer.ImplemantationInterfaceDao.AgentParamedicalDaoImpl;
import org.Projet.consumer.InterfaceDao.AgentParamedicalDao;
import org.Projet.exceptions.InformationDupliquerExeption;
import org.Projet.exceptions.InformationIncompletException;
import org.Projet.exceptions.InformationsErroneeException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/ServletGestionRdvs")
public class ServletGestionRdvs extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private AgentParamedicalDao agentParamedicalDao;

    public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.agentParamedicalDao = (AgentParamedicalDaoImpl)daoFactory.getUtilisateurDao("agentParamedicale");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getParameter("idService") != null && !request.getParameter("idService").equals("")) {
            int idService = Integer.parseInt(request.getParameter("idService"));
            ArrayList<Medecin> listeMedecins = agentParamedicalDao.getMedecinsService(idService);
            HttpSession session = request.getSession();
            if (session.getAttribute("listeMedecin") != null ) session.removeAttribute("listeMedecins");
            if (session.getAttribute("idService") != null ) session.removeAttribute("idService");
            session.setAttribute("idService",idService);
            session.setAttribute("listeMedecins", listeMedecins);
        }
        else{
                if (request.getParameter("idMedecin") != null && !request.getParameter("idMedecin").equals("")) {
                    int idMedecin = Integer.parseInt(request.getParameter("idMedecin"));
                    Rdv rdv = agentParamedicalDao.getRendezVous(idMedecin);
                    HttpSession session = request.getSession();
                    if (session.getAttribute("idMedecin") != null ) session.removeAttribute("idMedecin");
                    if (session.getAttribute("rdv") != null ) session.removeAttribute("rdv");
                    session.setAttribute("idMedecin",idMedecin);
                    session.setAttribute("rdv", rdv);
                }
                else {
                    ArrayList <Service> listeServices = agentParamedicalDao.getServices();
                    HttpSession session = request.getSession();
                    if (session.getAttribute("listeMedecin") != null ) session.removeAttribute("listeMedecins");
                    if (session.getAttribute("rdv") != null ) session.removeAttribute("rdv");
                    session.setAttribute("listeServices",listeServices);
                }

            }
        this.getServletContext().getRequestDispatcher("/WEB-INF/AgentParamedicale/GestionRdvs.jsp").forward(request, response);
    }
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{

        String jour = request.getParameter("jour");
        String heure = request.getParameter("heure");
        int idPatient = Integer.parseInt(request.getParameter("idPatient"));
        String nomPatient = request.getParameter("nomPatient");
        String prenomPatient= request.getParameter("prenomPatient");
        Patient patient = agentParamedicalDao.getPatient(idPatient,nomPatient,prenomPatient);
        try {
            if ((patient != null)) {
                    if (jour != null && heure != null) {
                        if (!jour.equals("") && (!heure.equals(""))) {
                            HttpSession session = request.getSession();
                            Rdv rdv = ((Rdv) session.getAttribute("rdv"));
                            AgentParamedicale agentParamedicale = ((AgentParamedicale) session.getAttribute("utilisateur"));
                            int idRdv = rdv.getId();
                            int idMedecin = rdv.getIdMedecin();
                            int idAgent = agentParamedicale.getMatricule();
                            System.out.println("idRdv : "+idRdv+" id Medecin : "+idMedecin+" idAgent = "+idAgent);
                            if (rdv.estJourPlein(jour))
                                throw new InformationsErroneeException(" l’heure et la date choisies déjà réservées.");
                            else if (rdv.estJourDisponible(jour)) {
                                DateRdv dateRdv = rdv.getJourDisponible(jour);
                                System.out.println("date = " + dateRdv.getDate() + " iddate = " + dateRdv.getId());
                                if (!dateRdv.estHeureBloquer(heure)) {
                                    HeureRdv heureRdv = new HeureRdv(idPatient, idAgent, heure);
                                    heureRdv.setIdDate(dateRdv.getId());
                                    agentParamedicalDao.ajouterHeureDateDispo(heureRdv);
                                }
                            } else {
                                DateRdv dateRdv = new DateRdv(jour);
                                HeureRdv heureRdv = new HeureRdv(idPatient, idAgent, heure);
                                dateRdv.getHeures().add(heureRdv);
                                agentParamedicalDao.ajouterDate(dateRdv, idRdv);

                            }
                        }
                    }
                response.sendRedirect("AccueilAgentParamedicale");
            }
            else throw new InformationsErroneeException("Compte innexisatant.");
        }

        catch (InformationsErroneeException b){
            HttpSession session = request.getSession();

            Rdv rdv =agentParamedicalDao.getRendezVous((Integer) session.getAttribute("idMedecin"));

            session.setAttribute("rdv",rdv);
            request.setAttribute("rdv",rdv);
            request.setAttribute("erreur",b.getMessage());
            this.getServletContext().getRequestDispatcher("/WEB-INF/AgentParamedicale/GestionRdvs.jsp").forward(request, response);
        }
        catch (InformationDupliquerExeption e){
            HttpSession session = request.getSession();
            Rdv rdv =agentParamedicalDao.getRendezVous((Integer) session.getAttribute("idMedecin"));
            session.setAttribute("rdv",rdv);
            request.setAttribute("rdv",rdv);
            request.setAttribute("erreur",e.getMessage());
            this.getServletContext().getRequestDispatcher("/WEB-INF/AgentParamedicale/GestionRdvs.jsp").forward(request, response);

        }


    }
}

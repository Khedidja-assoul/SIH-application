package org.Projet.servletes.agentLaboratoire;

import org.Projet.beans.patient.Patient;
import org.Projet.beans.personnel.personnelDeSante.uniteSoins.Medecin;
import org.Projet.beans.resultat.ActeComplementaireLaboratoire;
import org.Projet.beans.resultat.Consultation;
import org.Projet.consumer.DaoFactory;
import org.Projet.consumer.ImplemantationInterfaceDao.AgentLaboratoireDaoImpl;
import org.Projet.consumer.InterfaceDao.AgentLaboratoireDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/ServletResultatsActes")
public class ServletResultatsActes extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private AgentLaboratoireDao agentLaboratoireDao;

    public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.agentLaboratoireDao= (AgentLaboratoireDaoImpl)daoFactory.getUtilisateurDao("agentLaboratoire");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<ActeComplementaireLaboratoire> listeResultatsActes = agentLaboratoireDao.afficherActeLaboEtablis();
        ArrayList<Consultation> listeConsultation = new ArrayList<>();
        ArrayList<Patient> listePatient = new ArrayList<>();
        ArrayList<Medecin> listeMedecin= new ArrayList<>();
        for(int i =0 ; i<listeResultatsActes.size() ; i++){
            Consultation consultation = agentLaboratoireDao.getConsultation(listeResultatsActes.get(i).getIdConsultation());
            System.out.println(consultation.getId()+" idPatient : "+consultation.getIdPatient()+" idMedecin : "+consultation.getIdMedecin());
            listePatient.add(agentLaboratoireDao.getPatient(consultation.getIdPatient()));
            listeMedecin.add(agentLaboratoireDao.getMedecin(consultation.getIdMedecin()));
            listeConsultation.add(consultation);
        }
        request.setAttribute("listeResultatsActes",listeResultatsActes);
        request.setAttribute("listeConsultation",listeConsultation);
        request.setAttribute("listeMedecin",listeMedecin);
        request.setAttribute("listePatient",listePatient);
        this.getServletContext().getRequestDispatcher("/WEB-INF/AgentLaboratoire/ResultatsActes.jsp").forward(request, response);

    }
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {


    }
}

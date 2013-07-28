package fr.upyourbizz.web.presentation.controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.upyourbizz.utils.adaptateur.AjoutClientAdaptateur;
import fr.upyourbizz.utils.exception.TechnicalException;
import fr.upyourbizz.web.coordination.AjoutClientCoordinateur;
import fr.upyourbizz.web.dto.ClientDto;
import fr.upyourbizz.web.presentation.model.AjoutClientModel;

@Component
public class AjoutClientController extends AbstractController {

    // ===== Attributs statiques ==============================================

    @SuppressWarnings("unused")
    private final Logger logger = LoggerFactory.getLogger(AjoutClientController.class);

    // ===== Méthodes statiques ===============================================

    // ===== Attributs ========================================================

    @Autowired
    private AjoutClientModel ajoutClientModel;

    @Autowired
    private AjoutClientCoordinateur ajoutClientCoordinateur;

    // ===== Constructeurs ====================================================

    // ===== Méthodes =========================================================

    public void init() {

    }

    public void handleFileUpload(FileUploadEvent event) {
        FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName()
                + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public String ajouterClient() {
        logger.debug("AJout client");
        ClientDto nouveauClient = AjoutClientAdaptateur.preparationEnregistrementModel(ajoutClientModel);

        try {
            ajoutClientCoordinateur.ajouterClient(nouveauClient);
        }
        catch (TechnicalException e) {
            e.printStackTrace();
            redirectionVersPageErreurTechnique(e.getMessage(), "détail");
        }
        return "";
    }

    // ===== Accesseurs =======================================================

    // ===== Classes imbriquées ===============================================
}

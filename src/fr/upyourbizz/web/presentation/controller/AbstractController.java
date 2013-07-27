package fr.upyourbizz.web.presentation.controller;

import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AbstractController {

    // ===== Attributs statiques ==============================================

    @SuppressWarnings("unused")
    private final Logger logger = LoggerFactory.getLogger(AbstractController.class);

    // ===== Méthodes statiques ===============================================

    // ===== Attributs ========================================================

    // ===== Constructeurs ====================================================

    // ===== Méthodes =========================================================

    /**
     * Return true if the current request is a postback.
     * 
     * @return Return true if the current request is a postback.
     */
    public static boolean isPostback() {
        return FacesContext.getCurrentInstance().isPostback();
    }

    protected boolean controlerChampsObligatoires(Map<String, Object> champsObligatoires) {
        boolean resultat = true;
        for (Map.Entry<String, Object> champsObligatoire : champsObligatoires.entrySet()) {
            if (champsObligatoire.getValue() instanceof String
                    && ((String) champsObligatoire.getValue()).isEmpty()) {
                FacesContext.getCurrentInstance().addMessage(
                        null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Champ \""
                                + champsObligatoire.getKey() + "\" manquant", "Champs manquant"));
                resultat = false;
            }
            else if (champsObligatoire.getValue() instanceof Integer
                    && ((Integer) champsObligatoire.getValue()).equals(0)) {
                FacesContext.getCurrentInstance().addMessage(
                        null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Champ "
                                + champsObligatoire.getKey() + " manquant", "Champs manquant"));
                resultat = false;
            }
            else if (champsObligatoire.getValue() instanceof Float
                    && ((Float) champsObligatoire.getValue()).equals(0F)) {
                FacesContext.getCurrentInstance().addMessage(
                        null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Champ "
                                + champsObligatoire.getKey() + " manquant", "Champs manquant"));
                resultat = false;
            }
        }
        return resultat;
    }

    /**
     * Redirige vers la page d'erreur technique
     * 
     * @param message Le message d'erreur
     * @param detail le detail du message
     */
    public void redirectionVersPageErreurTechnique(String message, String detail) {
        // TODO rediriger vers page d'erreur
    }

    // ===== Accesseurs =======================================================

    // ===== Classes imbriquées ===============================================
}

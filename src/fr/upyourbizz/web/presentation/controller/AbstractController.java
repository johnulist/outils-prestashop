package fr.upyourbizz.web.presentation.controller;

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

    // ===== Accesseurs =======================================================

    // ===== Classes imbriquées ===============================================
}

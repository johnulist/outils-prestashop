package fr.upyourbizz.web.presentation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import fr.upyourbizz.web.presentation.model.CreerPacModele;

@Component
public class CreerPacController {

    // ===== Attributs statiques ==============================================

    @SuppressWarnings("unused")
    private final Logger logger = LoggerFactory.getLogger(CreerPacController.class);

    // ===== Méthodes statiques ===============================================

    // ===== Attributs ========================================================

    private CreerPacModele creerPacModele;

    // ===== Constructeurs ====================================================

    // ===== Méthodes =========================================================

    public void init() {
        try {
            // int clientId = Integer.parseInt(creerPacModele.getClientId());
            // int produitId = Integer.parseInt(creerPacModele.getProduitId());

        }
        catch (NumberFormatException ex) {

        }

    }

    // ===== Accesseurs =======================================================

    // ===== Classes imbriquées ===============================================
}

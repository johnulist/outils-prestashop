/**
 * © 2013, Upyourbizz - All right reserved
 */
package fr.upyourbizz.web.presentation.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * GestionClientModel
 */
@Component
public class GestionClientsModel {

    // ===== Attributs statiques ==============================================

    @SuppressWarnings("unused")
    private final Logger logger = LoggerFactory.getLogger(GestionClientsModel.class);

    // ===== Méthodes statiques ===============================================

    // ===== Attributs ========================================================

    private String income;

    // ===== Constructeurs ====================================================

    // ===== Méthodes =========================================================

    public void reinitialiser() {
        // TODO Ébauche de méthode auto-générée

    }

    // ===== Accesseurs =======================================================

    /**
     * Retourne income
     * 
     * @return income
     */
    public String getIncome() {
        return income;
    }

    /**
     * Affecte income
     * 
     * @param income income à affecter
     */
    public void setIncome(String income) {
        this.income = income;
    }

    // ===== Classes imbriquées ===============================================
}

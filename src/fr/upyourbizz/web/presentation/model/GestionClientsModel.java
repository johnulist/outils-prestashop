/**
 * © 2013, Upyourbizz - All right reserved
 */
package fr.upyourbizz.web.presentation.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import fr.upyourbizz.web.dto.ClientDto;

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

    private String income = "";

    private String contextePage = "";

    private ClientDto clientSelectionne;

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

    /**
     * Retourne contextePage
     * 
     * @return contextePage
     */
    public String getContextePage() {
        return contextePage;
    }

    /**
     * Affecte contextePage
     * 
     * @param contextePage contextePage à affecter
     */
    public void setContextePage(String contextePage) {
        this.contextePage = contextePage;
    }

    /**
     * Retourne clientSelectionne
     * 
     * @return clientSelectionne
     */
    public ClientDto getClientSelectionne() {
        return clientSelectionne;
    }

    /**
     * Affecte clientSelectionne
     * 
     * @param clientSelectionne clientSelectionne à affecter
     */
    public void setClientSelectionne(ClientDto clientSelectionne) {
        this.clientSelectionne = clientSelectionne;
    }

    // ===== Classes imbriquées ===============================================
}

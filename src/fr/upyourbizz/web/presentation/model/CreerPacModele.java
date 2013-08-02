package fr.upyourbizz.web.presentation.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.upyourbizz.web.dto.ClientDto;
import fr.upyourbizz.web.dto.ProduitReferenceDto;

public class CreerPacModele {

    // ===== Attributs statiques ==============================================

    @SuppressWarnings("unused")
    private final Logger logger = LoggerFactory.getLogger(CreerPacModele.class);

    // ===== Méthodes statiques ===============================================

    // ===== Attributs ========================================================

    private String clientId = "";

    private String produitId = "";

    private ClientDto client;

    private ProduitReferenceDto produit;

    // ===== Constructeurs ====================================================

    // ===== Méthodes =========================================================

    // ===== Accesseurs =======================================================

    /**
     * Retourne clientId
     * 
     * @return clientId
     */
    public String getClientId() {
        return clientId;
    }

    /**
     * Affecte clientId
     * 
     * @param clientId clientId à affecter
     */
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    /**
     * Retourne produitId
     * 
     * @return produitId
     */
    public String getProduitId() {
        return produitId;
    }

    /**
     * Affecte produitId
     * 
     * @param produitId produitId à affecter
     */
    public void setProduitId(String produitId) {
        this.produitId = produitId;
    }

    // ===== Classes imbriquées ===============================================
}

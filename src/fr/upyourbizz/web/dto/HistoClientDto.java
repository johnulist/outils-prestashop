package fr.upyourbizz.web.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HistoClientDto {

    // ===== Attributs statiques ==============================================

    @SuppressWarnings("unused")
    private final Logger logger = LoggerFactory.getLogger(HistoClientDto.class);

    // ===== Méthodes statiques ===============================================

    // ===== Attributs ========================================================

    private final int idClient;

    private final String nomSociete;

    private final String ville;

    // ===== Constructeurs ====================================================

    public HistoClientDto(int idClient, String nomSociete, String ville) {
        super();
        this.idClient = idClient;
        this.nomSociete = nomSociete;
        this.ville = ville;
    }

    // ===== Méthodes =========================================================

    // ===== Accesseurs =======================================================

    /**
     * Retourne idClient
     * 
     * @return idClient
     */
    public int getIdClient() {
        return idClient;
    }

    /**
     * Retourne nomSociete
     * 
     * @return nomSociete
     */
    public String getNomSociete() {
        return nomSociete;
    }

    /**
     * Retourne ville
     * 
     * @return ville
     */
    public String getVille() {
        return ville;
    }

    // ===== Classes imbriquées ===============================================
}

package fr.upyourbizz.web.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StatistiquesDto {

    // ===== Attributs statiques ==============================================

    @SuppressWarnings("unused")
    private final Logger logger = LoggerFactory.getLogger(StatistiquesDto.class);

    // ===== Méthodes statiques ===============================================

    // ===== Attributs ========================================================

    private String meilleurVendeur;

    private int nombreVentesSemaine;

    private int nombreVentesMois;

    // ===== Constructeurs ====================================================

    public StatistiquesDto(String meilleurVendeur, int nombreVentesSemaine, int nombreVentesMois) {
        super();
        this.meilleurVendeur = meilleurVendeur;
        this.nombreVentesSemaine = nombreVentesSemaine;
        this.nombreVentesMois = nombreVentesMois;
    }

    // ===== Méthodes =========================================================

    // ===== Accesseurs =======================================================

    /**
     * Retourne meilleurVendeur
     * 
     * @return meilleurVendeur
     */
    public String getMeilleurVendeur() {
        return meilleurVendeur;
    }

    /**
     * Affecte meilleurVendeur
     * 
     * @param meilleurVendeur meilleurVendeur à affecter
     */
    public void setMeilleurVendeur(String meilleurVendeur) {
        this.meilleurVendeur = meilleurVendeur;
    }

    /**
     * Retourne nombreVentesSemaine
     * 
     * @return nombreVentesSemaine
     */
    public int getNombreVentesSemaine() {
        return nombreVentesSemaine;
    }

    /**
     * Affecte nombreVentesSemaine
     * 
     * @param nombreVentesSemaine nombreVentesSemaine à affecter
     */
    public void setNombreVentesSemaine(int nombreVentesSemaine) {
        this.nombreVentesSemaine = nombreVentesSemaine;
    }

    /**
     * Retourne nombreVentesMois
     * 
     * @return nombreVentesMois
     */
    public int getNombreVentesMois() {
        return nombreVentesMois;
    }

    /**
     * Affecte nombreVentesMois
     * 
     * @param nombreVentesMois nombreVentesMois à affecter
     */
    public void setNombreVentesMois(int nombreVentesMois) {
        this.nombreVentesMois = nombreVentesMois;
    }

    // ===== Classes imbriquées ===============================================
}

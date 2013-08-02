package fr.upyourbizz.web.dto;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DerniereVenteDto {

    // ===== Attributs statiques ==============================================

    @SuppressWarnings("unused")
    private final Logger logger = LoggerFactory.getLogger(DerniereVenteDto.class);

    // ===== Méthodes statiques ===============================================

    // ===== Attributs ========================================================

    private String nomSociete;

    private String nomProduit;

    private Date dateVente;

    private float prixVente;

    // ===== Constructeurs ====================================================

    public DerniereVenteDto(String nomSociete, String nomProduit, Date dateVente, float prixVente) {
        super();
        this.nomSociete = nomSociete;
        this.nomProduit = nomProduit;
        this.dateVente = dateVente;
        this.prixVente = prixVente;
    }

    // ===== Méthodes =========================================================

    // ===== Accesseurs =======================================================

    /**
     * Retourne nomSociete
     * 
     * @return nomSociete
     */
    public String getNomSociete() {
        return nomSociete;
    }

    /**
     * Affecte nomSociete
     * 
     * @param nomSociete nomSociete à affecter
     */
    public void setNomSociete(String nomSociete) {
        this.nomSociete = nomSociete;
    }

    /**
     * Retourne nomProduit
     * 
     * @return nomProduit
     */
    public String getNomProduit() {
        return nomProduit;
    }

    /**
     * Affecte nomProduit
     * 
     * @param nomProduit nomProduit à affecter
     */
    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    /**
     * Retourne dateVente
     * 
     * @return dateVente
     */
    public Date getDateVente() {
        return dateVente;
    }

    /**
     * Affecte dateVente
     * 
     * @param dateVente dateVente à affecter
     */
    public void setDateVente(Date dateVente) {
        this.dateVente = dateVente;
    }

    /**
     * Retourne prixVente
     * 
     * @return prixVente
     */
    public float getPrixVente() {
        return prixVente;
    }

    /**
     * Affecte prixVente
     * 
     * @param prixVente prixVente à affecter
     */
    public void setPrixVente(float prixVente) {
        this.prixVente = prixVente;
    }

    // ===== Classes imbriquées ===============================================
}

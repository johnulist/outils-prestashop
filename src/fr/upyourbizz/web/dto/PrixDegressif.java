/**
 * © 2013, Upyourbizz - All right reserved
 */
package fr.upyourbizz.web.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * PrixDegressif
 */
public class PrixDegressif {

    // ===== Attributs statiques ==============================================

    @SuppressWarnings("unused")
    private final Logger logger = LoggerFactory.getLogger(PrixDegressif.class);

    // ===== Méthodes statiques ===============================================

    // ===== Attributs ========================================================

    private int idPrixDegressif;

    private int borneInferieure;

    private int borneSuperieure;

    private float prixUnitaire;

    // ===== Constructeurs ====================================================

    /**
     * @param idPrixDegressif id du prix dégressif
     * @param borneInferieure borne inférieur (par rapport quantité)
     * @param borneSuperieure borne supérieur (par rapport quantité)
     * @param prixUnitaire prix du produit avec une quantité comprise entre la
     *            borne suppérieure et la borne inférieure
     */
    public PrixDegressif(int idPrixDegressif, int borneInferieure, int borneSuperieure,
            float prixUnitaire) {
        super();
        this.idPrixDegressif = idPrixDegressif;
        this.borneInferieure = borneInferieure;
        this.borneSuperieure = borneSuperieure;
        this.prixUnitaire = prixUnitaire;
    }

    /**
     * @param borneInferieure borne inférieur (par rapport quantité)
     * @param borneSuperieure borne supérieur (par rapport quantité)
     * @param prixUnitaire prix du produit avec une quantité comprise entre la
     *            borne suppérieure et la borne inférieure
     */
    public PrixDegressif(int borneInferieure, int borneSuperieure, float prixUnitaire) {
        super();
        this.borneInferieure = borneInferieure;
        this.borneSuperieure = borneSuperieure;
        this.prixUnitaire = prixUnitaire;
    }

    // ===== Méthodes =========================================================

    // ===== Accesseurs =======================================================

    /**
     * Retourne idPrixDegressif
     * 
     * @return idPrixDegressif
     */
    public int getIdPrixDegressif() {
        return idPrixDegressif;
    }

    /**
     * Affecte idPrixDegressif
     * 
     * @param idPrixDegressif idPrixDegressif à affecter
     */
    public void setIdPrixDegressif(int idPrixDegressif) {
        this.idPrixDegressif = idPrixDegressif;
    }

    /**
     * Retourne borneInferieure
     * 
     * @return borneInferieure
     */
    public int getBorneInferieure() {
        return borneInferieure;
    }

    /**
     * Affecte borneInferieure
     * 
     * @param borneInferieure borneInferieure à affecter
     */
    public void setBorneInferieure(int borneInferieure) {
        this.borneInferieure = borneInferieure;
    }

    /**
     * Retourne borneSuperieure
     * 
     * @return borneSuperieure
     */
    public int getBorneSuperieure() {
        return borneSuperieure;
    }

    /**
     * Affecte borneSuperieure
     * 
     * @param borneSuperieure borneSuperieure à affecter
     */
    public void setBorneSuperieure(int borneSuperieure) {
        this.borneSuperieure = borneSuperieure;
    }

    /**
     * Retourne prixUnitaire
     * 
     * @return prixUnitaire
     */
    public float getPrixUnitaire() {
        return prixUnitaire;
    }

    /**
     * Affecte prixUnitaire
     * 
     * @param prixUnitaire prixUnitaire à affecter
     */
    public void setPrixUnitaire(float prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    // ===== Classes imbriquées ===============================================
}

package fr.upyourbizz.web.dto;

import java.util.Date;

public class AnnonceDto {

    // ===== Attributs statiques ==============================================

    // ===== Méthodes statiques ===============================================

    // ===== Attributs ========================================================

    private String texte;

    private Date dateCreation;

    private String gravite;

    private String redacteur;

    public AnnonceDto(String texte, Date dateCreation, String gravite, String redacteur) {
        super();
        this.texte = texte;
        this.dateCreation = dateCreation;
        this.gravite = gravite;
        this.redacteur = redacteur;
    }

    // ===== Constructeurs ====================================================

    // ===== Méthodes =========================================================

    // ===== Accesseurs =======================================================

    /**
     * Retourne texte
     * 
     * @return texte
     */
    public String getTexte() {
        return texte;
    }

    /**
     * Affecte texte
     * 
     * @param texte texte à affecter
     */
    public void setTexte(String texte) {
        this.texte = texte;
    }

    /**
     * Retourne dateCreation
     * 
     * @return dateCreation
     */
    public Date getDateCreation() {
        return dateCreation;
    }

    /**
     * Affecte dateCreation
     * 
     * @param dateCreation dateCreation à affecter
     */
    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    /**
     * Retourne gravite
     * 
     * @return gravite
     */
    public String getGravite() {
        return gravite;
    }

    /**
     * Affecte gravite
     * 
     * @param gravite gravite à affecter
     */
    public void setGravite(String gravite) {
        this.gravite = gravite;
    }

    /**
     * Retourne redacteur
     * 
     * @return redacteur
     */
    public String getRedacteur() {
        return redacteur;
    }

    /**
     * Affecte redacteur
     * 
     * @param redacteur redacteur à affecter
     */
    public void setRedacteur(String redacteur) {
        this.redacteur = redacteur;
    }

    // ===== Classes imbriquées ===============================================
}

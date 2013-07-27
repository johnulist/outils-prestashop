/**
 * © 2013, Upyourbizz - All right reserved
 */
package fr.upyourbizz.web.dto;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Option
 */
public class Option {

    // ===== Attributs statiques ==============================================

    @SuppressWarnings("unused")
    private final Logger logger = LoggerFactory.getLogger(Option.class);

    // ===== Méthodes statiques ===============================================

    // ===== Attributs ========================================================

    private String nom = "";

    private String reference = "";

    private boolean obligatoire;

    private float coutUnitaireFixe;

    private List<PrixDegressif> listePrixDegressif = new ArrayList<PrixDegressif>();

    // ===== Constructeurs ====================================================

    public Option(String nom, String reference, boolean obligatoire) {
        super();
        this.nom = nom;
        this.reference = reference;
        this.obligatoire = obligatoire;
    }

    // ===== Méthodes =========================================================
    /**
     * @param idPrixDegressif
     * @param borneInferieure
     * @param borneSuperieure
     * @param prixUnitaire
     */
    public void ajouterPrixDegressif(Integer idPrixDegressif, int borneInferieure,
            int borneSuperieure, float prixUnitaire) {
        listePrixDegressif.add(new PrixDegressif(borneInferieure, borneSuperieure, prixUnitaire));
    }

    // ===== Accesseurs =======================================================

    /**
     * Retourne nom
     * 
     * @return nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * Affecte nom
     * 
     * @param nom nom à affecter
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Retourne reference
     * 
     * @return reference
     */
    public String getReference() {
        return reference;
    }

    /**
     * Affecte reference
     * 
     * @param reference reference à affecter
     */
    public void setReference(String reference) {
        this.reference = reference;
    }

    /**
     * Retourne obligatoire
     * 
     * @return obligatoire
     */
    public boolean isObligatoire() {
        return obligatoire;
    }

    /**
     * Affecte obligatoire
     * 
     * @param obligatoire obligatoire à affecter
     */
    public void setObligatoire(boolean obligatoire) {
        this.obligatoire = obligatoire;
    }

    /**
     * Retourne coutUnitaireFixe
     * 
     * @return coutUnitaireFixe
     */
    public float getCoutUnitaireFixe() {
        return coutUnitaireFixe;
    }

    /**
     * Affecte coutUnitaireFixe
     * 
     * @param coutUnitaireFixe coutUnitaire à affecter
     */
    public void setCoutUnitaireFixe(float coutUnitaireFixe) {
        this.coutUnitaireFixe = coutUnitaireFixe;
    }

    /**
     * Retourne listePrixDegressif
     * 
     * @return listePrixDegressif
     */
    public List<PrixDegressif> getListePrixDegressif() {
        return listePrixDegressif;
    }

    /**
     * Affecte listePrixDegressif
     * 
     * @param listePrixDegressif listePrixDegressif à affecter
     */
    public void setListePrixDegressif(List<PrixDegressif> listePrixDegressif) {
        this.listePrixDegressif = listePrixDegressif;
    }
    // ===== Classes imbriquées ===============================================
}

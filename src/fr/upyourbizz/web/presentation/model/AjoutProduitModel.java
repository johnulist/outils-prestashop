/**
 * © 2013, Upyourbizz - All right reserved
 */
package fr.upyourbizz.web.presentation.model;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * AjoutProduitModel
 */
public class AjoutProduitModel {

    // ===== Attributs statiques ==============================================

    @SuppressWarnings("unused")
    private final Logger logger = LoggerFactory.getLogger(AjoutProduitModel.class);

    // ===== Méthodes statiques ===============================================

    /*
     * Produit
     */

    private String nom = "";

    private String reference = "";

    private List<SelectItem> listeFamilles = new ArrayList<SelectItem>();

    private String familleSelectionnee = "";

    private List<SelectItem> listeSousFamilles = new ArrayList<SelectItem>();;

    private String sousFamilleSelectionnee = "";

    /*
     * Description
     */

    private String descriptionCourte = "";

    private String descriptionOffre = "";

    private String avantages = "";

    private String benefices = "";

    /*
     * Prix
     */

    private float coutNominal = 0F;

    private float prixUnitaireFixe = 0F;

    private int borneInferieure;

    private int borneSuperieure;

    private float coutUnitaire = 0F;

    private List<PrixDegressif> listePrixDegressifProduit = new ArrayList<PrixDegressif>();

    /*
     * Options
     */

    private List<Option> listeOptions = new ArrayList<Option>();

    private String optionNom = "";

    private String optionReference = "";

    private float optionCoutNominal = 0F;

    private float optionPrixUnitaireFixe = 0F;

    private int optionBorneInferieure;

    private int optionBorneSuperieur;

    private float optionCoutUnitaire = 0F;

    // ===== Attributs ========================================================

    // ===== Constructeurs ====================================================

    public AjoutProduitModel() {
        listeFamilles.add(new SelectItem("Marketing"));
    }

    // ===== Méthodes =========================================================

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
     * Retourne listeFamilles
     * 
     * @return listeFamilles
     */
    public List<SelectItem> getListeFamilles() {
        return listeFamilles;
    }

    /**
     * Affecte listeFamilles
     * 
     * @param listeFamilles listeFamilles à affecter
     */
    public void setListeFamilles(List<SelectItem> listeFamilles) {
        this.listeFamilles = listeFamilles;
    }

    /**
     * Retourne familleSelectionnee
     * 
     * @return familleSelectionnee
     */
    public String getFamilleSelectionnee() {
        return familleSelectionnee;
    }

    /**
     * Affecte familleSelectionnee
     * 
     * @param familleSelectionnee familleSelectionnee à affecter
     */
    public void setFamilleSelectionnee(String familleSelectionnee) {
        this.familleSelectionnee = familleSelectionnee;
    }

    /**
     * Retourne listeSousFamilles
     * 
     * @return listeSousFamilles
     */
    public List<SelectItem> getListeSousFamilles() {
        return listeSousFamilles;
    }

    /**
     * Affecte listeSousFamilles
     * 
     * @param listeSousFamilles listeSousFamilles à affecter
     */
    public void setListeSousFamilles(List<SelectItem> listeSousFamilles) {
        this.listeSousFamilles = listeSousFamilles;
    }

    /**
     * Retourne sousFamilleSelectionnee
     * 
     * @return sousFamilleSelectionnee
     */
    public String getSousFamilleSelectionnee() {
        return sousFamilleSelectionnee;
    }

    /**
     * Affecte sousFamilleSelectionnee
     * 
     * @param sousFamilleSelectionnee sousFamilleSelectionnee à affecter
     */
    public void setSousFamilleSelectionnee(String sousFamilleSelectionnee) {
        this.sousFamilleSelectionnee = sousFamilleSelectionnee;
    }

    /**
     * Retourne descriptionCourte
     * 
     * @return descriptionCourte
     */
    public String getDescriptionCourte() {
        return descriptionCourte;
    }

    /**
     * Affecte descriptionCourte
     * 
     * @param descriptionCourte descriptionCourte à affecter
     */
    public void setDescriptionCourte(String descriptionCourte) {
        this.descriptionCourte = descriptionCourte;
    }

    /**
     * Retourne descriptionOffre
     * 
     * @return descriptionOffre
     */
    public String getDescriptionOffre() {
        return descriptionOffre;
    }

    /**
     * Affecte descriptionOffre
     * 
     * @param descriptionOffre descriptionOffre à affecter
     */
    public void setDescriptionOffre(String descriptionOffre) {
        this.descriptionOffre = descriptionOffre;
    }

    /**
     * Retourne avantages
     * 
     * @return avantages
     */
    public String getAvantages() {
        return avantages;
    }

    /**
     * Affecte avantages
     * 
     * @param avantages avantages à affecter
     */
    public void setAvantages(String avantages) {
        this.avantages = avantages;
    }

    /**
     * Retourne benefices
     * 
     * @return benefices
     */
    public String getBenefices() {
        return benefices;
    }

    /**
     * Affecte benefices
     * 
     * @param benefices benefices à affecter
     */
    public void setBenefices(String benefices) {
        this.benefices = benefices;
    }

    /**
     * Retourne coutNominal
     * 
     * @return coutNominal
     */
    public float getCoutNominal() {
        return coutNominal;
    }

    /**
     * Affecte coutNominal
     * 
     * @param coutNominal coutNominal à affecter
     */
    public void setCoutNominal(float coutNominal) {
        this.coutNominal = coutNominal;
    }

    /**
     * Retourne prixUnitaireFixe
     * 
     * @return prixUnitaireFixe
     */
    public float getPrixUnitaireFixe() {
        return prixUnitaireFixe;
    }

    /**
     * Affecte prixUnitaireFixe
     * 
     * @param prixUnitaireFixe prixUnitaireFixe à affecter
     */
    public void setPrixUnitaireFixe(float prixUnitaireFixe) {
        this.prixUnitaireFixe = prixUnitaireFixe;
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
     * Affecte borneSuperieur
     * 
     * @param borneSuperieure borneSuperieur à affecter
     */
    public void setBorneSuperieure(int borneSuperieure) {
        this.borneSuperieure = borneSuperieure;
    }

    /**
     * Retourne coutUnitaire
     * 
     * @return coutUnitaire
     */
    public float getCoutUnitaire() {
        return coutUnitaire;
    }

    /**
     * Affecte coutUnitaire
     * 
     * @param coutUnitaire coutUnitaire à affecter
     */
    public void setCoutUnitaire(float coutUnitaire) {
        this.coutUnitaire = coutUnitaire;
    }

    /**
     * Retourne listePrixDegressifProduit
     * 
     * @return listePrixDegressifProduit
     */
    public List<PrixDegressif> getListePrixDegressifProduit() {
        return listePrixDegressifProduit;
    }

    /**
     * Affecte listePrixDegressifProduit
     * 
     * @param listePrixDegressifProduit listePrixDegressifProduit à affecter
     */
    public void setListePrixDegressifProduit(List<PrixDegressif> listePrixDegressifProduit) {
        this.listePrixDegressifProduit = listePrixDegressifProduit;
    }

    /**
     * Retourne listeOptions
     * 
     * @return listeOptions
     */
    public List<Option> getListeOptions() {
        return listeOptions;
    }

    /**
     * Affecte listeOptions
     * 
     * @param listeOptions listeOptions à affecter
     */
    public void setListeOptions(List<Option> listeOptions) {
        this.listeOptions = listeOptions;
    }

    /**
     * Affecte optionNom
     * 
     * @param optionNom optionNom à affecter
     */
    public void setOptionNom(String optionNom) {
        this.optionNom = optionNom;
    }

    /**
     * Retourne optionReference
     * 
     * @return optionReference
     */
    public String getOptionReference() {
        return optionReference;
    }

    /**
     * Affecte optionReference
     * 
     * @param optionReference optionReference à affecter
     */
    public void setOptionReference(String optionReference) {
        this.optionReference = optionReference;
    }

    /**
     * Retourne optionCoutNominal
     * 
     * @return optionCoutNominal
     */
    public float getOptionCoutNominal() {
        return optionCoutNominal;
    }

    /**
     * Affecte optionCoutNominal
     * 
     * @param optionCoutNominal optionCoutNominal à affecter
     */
    public void setOptionCoutNominal(float optionCoutNominal) {
        this.optionCoutNominal = optionCoutNominal;
    }

    /**
     * Retourne optionPrixUnitaireFixe
     * 
     * @return optionPrixUnitaireFixe
     */
    public float getOptionPrixUnitaireFixe() {
        return optionPrixUnitaireFixe;
    }

    /**
     * Affecte optionPrixUnitaireFixe
     * 
     * @param optionPrixUnitaireFixe optionPrixUnitaireFixe à affecter
     */
    public void setOptionPrixUnitaireFixe(float optionPrixUnitaireFixe) {
        this.optionPrixUnitaireFixe = optionPrixUnitaireFixe;
    }

    /**
     * Retourne optionBorneInferieure
     * 
     * @return optionBorneInferieure
     */
    public int getOptionBorneInferieure() {
        return optionBorneInferieure;
    }

    /**
     * Affecte optionBorneInferieure
     * 
     * @param optionBorneInferieure optionBorneInferieure à affecter
     */
    public void setOptionBorneInferieure(int optionBorneInferieure) {
        this.optionBorneInferieure = optionBorneInferieure;
    }

    /**
     * Retourne optionBorneSuperieur
     * 
     * @return optionBorneSuperieur
     */
    public int getOptionBorneSuperieur() {
        return optionBorneSuperieur;
    }

    /**
     * Affecte optionBorneSuperieur
     * 
     * @param optionBorneSuperieur optionBorneSuperieur à affecter
     */
    public void setOptionBorneSuperieur(int optionBorneSuperieur) {
        this.optionBorneSuperieur = optionBorneSuperieur;
    }

    /**
     * Retourne optionCoutUnitaire
     * 
     * @return optionCoutUnitaire
     */
    public float getOptionCoutUnitaire() {
        return optionCoutUnitaire;
    }

    /**
     * Affecte optionCoutUnitaire
     * 
     * @param optionCoutUnitaire optionCoutUnitaire à affecter
     */
    public void setOptionCoutUnitaire(float optionCoutUnitaire) {
        this.optionCoutUnitaire = optionCoutUnitaire;
    }

    // ===== Classes imbriquées ===============================================

    public class Option {

        private final String nom = "";

        private boolean obligatoire;

        private float prixUnitaire;

        private PrixDegressif prixDegressif;
    }

    public class PrixDegressif {

        private int borneInferieure;

        private int borneSuperieure;

        private float prixUnitaire;

        public PrixDegressif(int borneInferieure, int borneSuperieure, float prixUnitaire) {
            super();
            this.borneInferieure = borneInferieure;
            this.borneSuperieure = borneSuperieure;
            this.prixUnitaire = prixUnitaire;
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
    }
}

/**
 * © 2013, Upyourbizz - All right reserved
 */
package fr.upyourbizz.web.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ProduitDto
 */
public class ProduitReferenceDto {

    // ===== Attributs statiques ==============================================

    @SuppressWarnings("unused")
    private final Logger logger = LoggerFactory.getLogger(ProduitReferenceDto.class);

    // ===== Méthodes statiques ===============================================

    // ===== Attributs ========================================================

    private int idProduit;

    private ProduitFamilleDto famille;

    private ProduitSousFamilleDto sousFamille;

    private String reference;

    private String nom;

    private String descriptionCourte;

    private String descriptionLongueHtml;

    private String descriptionOffreHtml;

    private String avantagesHtml;

    private String beneficesHtml;

    private String urlImgIllustrationProduit;

    private String urlImgIconeProduit;

    private String urlImgProcessus;

    private float coutNominal;

    private float prixUnitaire;

    private PrixDegressifProduitDto prixDegressifProduit;

    private String commentaire;

    // ===== Constructeurs ====================================================

    /**
     * @param idProduit
     * @param famille
     * @param sousFamille
     * @param reference
     * @param nom
     * @param descriptionCourte
     * @param descriptionLongueHtml
     * @param descriptionOffreHtml
     * @param avantagesHtml
     * @param beneficesHtml
     * @param urlImgIllustrationProduit
     * @param urlImgIconeProduit
     * @param urlImgProcessus
     * @param coutNominal
     * @param commentaire
     */
    public ProduitReferenceDto(int idProduit, ProduitFamilleDto famille,
            ProduitSousFamilleDto sousFamille, String reference, String nom,
            String descriptionCourte, String descriptionLongueHtml, String descriptionOffreHtml,
            String avantagesHtml, String beneficesHtml, String urlImgIllustrationProduit,
            String urlImgIconeProduit, String urlImgProcessus, float coutNominal, String commentaire) {
        super();
        this.idProduit = idProduit;
        this.famille = famille;
        this.sousFamille = sousFamille;
        this.reference = reference;
        this.nom = nom;
        this.descriptionCourte = descriptionCourte;
        this.descriptionLongueHtml = descriptionLongueHtml;
        this.descriptionOffreHtml = descriptionOffreHtml;
        this.avantagesHtml = avantagesHtml;
        this.beneficesHtml = beneficesHtml;
        this.urlImgIllustrationProduit = urlImgIllustrationProduit;
        this.urlImgIconeProduit = urlImgIconeProduit;
        this.urlImgProcessus = urlImgProcessus;
        this.coutNominal = coutNominal;
        this.commentaire = commentaire;
    }

    // ===== Méthodes =========================================================

    // ===== Accesseurs =======================================================

    /**
     * Retourne idProduit
     * 
     * @return idProduit
     */
    public int getIdProduit() {
        return idProduit;
    }

    /**
     * Affecte idProduit
     * 
     * @param idProduit idProduit à affecter
     */
    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    /**
     * Retourne famille
     * 
     * @return famille
     */
    public ProduitFamilleDto getFamille() {
        return famille;
    }

    /**
     * Affecte famille
     * 
     * @param famille famille à affecter
     */
    public void setFamille(ProduitFamilleDto famille) {
        this.famille = famille;
    }

    /**
     * Retourne sousFamille
     * 
     * @return sousFamille
     */
    public ProduitSousFamilleDto getSousFamille() {
        return sousFamille;
    }

    /**
     * Affecte sousFamille
     * 
     * @param sousFamille sousFamille à affecter
     */
    public void setSousFamille(ProduitSousFamilleDto sousFamille) {
        this.sousFamille = sousFamille;
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
     * Retourne descriptionLongueHtml
     * 
     * @return descriptionLongueHtml
     */
    public String getDescriptionLongueHtml() {
        return descriptionLongueHtml;
    }

    /**
     * Affecte descriptionLongueHtml
     * 
     * @param descriptionLongueHtml descriptionLongueHtml à affecter
     */
    public void setDescriptionLongueHtml(String descriptionLongueHtml) {
        this.descriptionLongueHtml = descriptionLongueHtml;
    }

    /**
     * Retourne descriptionOffreHtml
     * 
     * @return descriptionOffreHtml
     */
    public String getDescriptionOffreHtml() {
        return descriptionOffreHtml;
    }

    /**
     * Affecte descriptionOffreHtml
     * 
     * @param descriptionOffreHtml descriptionOffreHtml à affecter
     */
    public void setDescriptionOffreHtml(String descriptionOffreHtml) {
        this.descriptionOffreHtml = descriptionOffreHtml;
    }

    /**
     * Retourne avantagesHtml
     * 
     * @return avantagesHtml
     */
    public String getAvantagesHtml() {
        return avantagesHtml;
    }

    /**
     * Affecte avantagesHtml
     * 
     * @param avantagesHtml avantagesHtml à affecter
     */
    public void setAvantagesHtml(String avantagesHtml) {
        this.avantagesHtml = avantagesHtml;
    }

    /**
     * Retourne beneficesHtml
     * 
     * @return beneficesHtml
     */
    public String getBeneficesHtml() {
        return beneficesHtml;
    }

    /**
     * Affecte beneficesHtml
     * 
     * @param beneficesHtml beneficesHtml à affecter
     */
    public void setBeneficesHtml(String beneficesHtml) {
        this.beneficesHtml = beneficesHtml;
    }

    /**
     * Retourne urlImgIllustrationProduit
     * 
     * @return urlImgIllustrationProduit
     */
    public String getUrlImgIllustrationProduit() {
        return urlImgIllustrationProduit;
    }

    /**
     * Affecte urlImgIllustrationProduit
     * 
     * @param urlImgIllustrationProduit urlImgIllustrationProduit à affecter
     */
    public void setUrlImgIllustrationProduit(String urlImgIllustrationProduit) {
        this.urlImgIllustrationProduit = urlImgIllustrationProduit;
    }

    /**
     * Retourne urlImgIconeProduit
     * 
     * @return urlImgIconeProduit
     */
    public String getUrlImgIconeProduit() {
        return urlImgIconeProduit;
    }

    /**
     * Affecte urlImgIconeProduit
     * 
     * @param urlImgIconeProduit urlImgIconeProduit à affecter
     */
    public void setUrlImgIconeProduit(String urlImgIconeProduit) {
        this.urlImgIconeProduit = urlImgIconeProduit;
    }

    /**
     * Retourne urlImgProcessus
     * 
     * @return urlImgProcessus
     */
    public String getUrlImgProcessus() {
        return urlImgProcessus;
    }

    /**
     * Affecte urlImgProcessus
     * 
     * @param urlImgProcessus urlImgProcessus à affecter
     */
    public void setUrlImgProcessus(String urlImgProcessus) {
        this.urlImgProcessus = urlImgProcessus;
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

    /**
     * Retourne prixDegressifProduit
     * 
     * @return prixDegressifProduit
     */
    public PrixDegressifProduitDto getPrixDegressifProduit() {
        return prixDegressifProduit;
    }

    /**
     * Affecte prixDegressifProduit
     * 
     * @param prixDegressifProduit prixDegressifProduit à affecter
     */
    public void setPrixDegressifProduit(PrixDegressifProduitDto prixDegressifProduit) {
        this.prixDegressifProduit = prixDegressifProduit;
    }

    /**
     * Retourne commentaire
     * 
     * @return commentaire
     */
    public String getCommentaire() {
        return commentaire;
    }

    /**
     * Affecte commentaire
     * 
     * @param commentaire commentaire à affecter
     */
    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }
}

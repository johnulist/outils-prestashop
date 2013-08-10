package fr.upyourbizz.web.dto;

import java.util.Date;
import java.util.List;

public class ProduitPacDto {

    // ===== Attributs statiques ==============================================

    // ===== Méthodes statiques ===============================================

    // ===== Attributs ========================================================

    private int idProduitPac;

    private int idProduitRef;

    private int quantite;

    private String commentaire;

    private Date dateRealisation;

    private int duree;

    private List<ProduitPacOptionDto> listeOptions;

    public ProduitPacDto(int idProduitPac, int idProduitRef, int quantite, String commentaire,
            Date dateRealisation, int duree, List<ProduitPacOptionDto> listeOptions) {
        super();
        this.idProduitPac = idProduitPac;
        this.idProduitRef = idProduitRef;
        this.quantite = quantite;
        this.commentaire = commentaire;
        this.dateRealisation = dateRealisation;
        this.duree = duree;
        this.listeOptions = listeOptions;
    }

    // ===== Constructeurs ====================================================

    // ===== Méthodes =========================================================

    // ===== Accesseurs =======================================================

    /**
     * Retourne idProduitPac
     * 
     * @return idProduitPac
     */
    public int getIdProduitPac() {
        return idProduitPac;
    }

    /**
     * Affecte idProduitPac
     * 
     * @param idProduitPac idProduitPac à affecter
     */
    public void setIdProduitPac(int idProduitPac) {
        this.idProduitPac = idProduitPac;
    }

    /**
     * Retourne idProduitRef
     * 
     * @return idProduitRef
     */
    public int getIdProduitRef() {
        return idProduitRef;
    }

    /**
     * Affecte idProduitRef
     * 
     * @param idProduitRef idProduitRef à affecter
     */
    public void setIdProduitRef(int idProduitRef) {
        this.idProduitRef = idProduitRef;
    }

    /**
     * Retourne quantite
     * 
     * @return quantite
     */
    public int getQuantite() {
        return quantite;
    }

    /**
     * Affecte quantite
     * 
     * @param quantite quantite à affecter
     */
    public void setQuantite(int quantite) {
        this.quantite = quantite;
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

    /**
     * Retourne dateRealisation
     * 
     * @return dateRealisation
     */
    public Date getDateRealisation() {
        return dateRealisation;
    }

    /**
     * Affecte dateRealisation
     * 
     * @param dateRealisation dateRealisation à affecter
     */
    public void setDateRealisation(Date dateRealisation) {
        this.dateRealisation = dateRealisation;
    }

    /**
     * Retourne duree
     * 
     * @return duree
     */
    public int getDuree() {
        return duree;
    }

    /**
     * Affecte duree
     * 
     * @param duree duree à affecter
     */
    public void setDuree(int duree) {
        this.duree = duree;
    }

    /**
     * Retourne listeOptions
     * 
     * @return listeOptions
     */
    public List<ProduitPacOptionDto> getListeOptions() {
        return listeOptions;
    }

    /**
     * Affecte listeOptions
     * 
     * @param listeOptions listeOptions à affecter
     */
    public void setListeOptions(List<ProduitPacOptionDto> listeOptions) {
        this.listeOptions = listeOptions;
    }

    // ===== Classes imbriquées ===============================================
}

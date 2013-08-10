package fr.upyourbizz.web.dto;

import java.util.Date;

public class ProduitPacOptionDto {

    // ===== Attributs statiques ==============================================

    // ===== Méthodes statiques ===============================================

    // ===== Attributs ========================================================

    private int idProduitPacOption;

    private int idProduitPac;

    private Date dateRealisation;

    private int duree;

    private float prixCalcule;

    // ===== Constructeurs ====================================================

    public ProduitPacOptionDto(int idProduitPacOption, int idProduitPac, Date dateRealisation,
            int duree, float prixCalcule) {
        super();
        this.idProduitPacOption = idProduitPacOption;
        this.idProduitPac = idProduitPac;
        this.dateRealisation = dateRealisation;
        this.duree = duree;
        this.prixCalcule = prixCalcule;
    }

    // ===== Méthodes =========================================================

    // ===== Accesseurs =======================================================

    /**
     * Retourne idProduitPacOption
     * 
     * @return idProduitPacOption
     */
    public int getIdProduitPacOption() {
        return idProduitPacOption;
    }

    /**
     * Affecte idProduitPacOption
     * 
     * @param idProduitPacOption idProduitPacOption à affecter
     */
    public void setIdProduitPacOption(int idProduitPacOption) {
        this.idProduitPacOption = idProduitPacOption;
    }

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
     * Retourne prixCalcule
     * 
     * @return prixCalcule
     */
    public float getPrixCalcule() {
        return prixCalcule;
    }

    /**
     * Affecte prixCalcule
     * 
     * @param prixCalcule prixCalcule à affecter
     */
    public void setPrixCalcule(float prixCalcule) {
        this.prixCalcule = prixCalcule;
    }

    // ===== Classes imbriquées ===============================================
}

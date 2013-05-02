package fr.upyourbizz.web.dto;

public class ProductInfo {

    // ===== Attributs statiques ==============================================

    // ===== Méthodes statiques ===============================================

    // ===== Attributs ========================================================

    private final int productId;

    private final String productName;

    private final int imageId;

    private final boolean isImgModified;

    // ===== Constructeurs ====================================================

    public ProductInfo(int productId, String productName, int imageId, boolean isImgModified) {
        super();
        this.productId = productId;
        this.productName = productName;
        this.imageId = imageId;
        this.isImgModified = isImgModified;
    }

    // ===== Méthodes =========================================================

    // ===== Accesseurs =======================================================
    /**
     * Retourne productId
     * 
     * @return productId
     */
    public int getProductId() {
        return productId;
    }

    /**
     * Retourne productName
     * 
     * @return productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Retourne imageId
     * 
     * @return imageId
     */
    public int getImageId() {
        return imageId;
    }

    /**
     * Retourne isImgModified
     * 
     * @return isImgModified
     */
    public boolean isImgModified() {
        return isImgModified;
    }

    // ===== Classes imbriquées ===============================================
}

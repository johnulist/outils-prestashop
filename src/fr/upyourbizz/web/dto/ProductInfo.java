package fr.upyourbizz.web.dto;

public class ProductInfo {

    // ===== Attributs statiques ==============================================

    // ===== Méthodes statiques ===============================================

    // ===== Attributs ========================================================

    private final int productId;

    private final String productName;

    private final String categoryName;

    private final int imageId;

    // ===== Constructeurs ====================================================

    public ProductInfo(int productId, String productName, String categoryName, int imageId) {
        super();
        this.productId = productId;
        this.productName = productName;
        this.categoryName = categoryName;
        this.imageId = imageId;
    }

    // ===== Méthodes =========================================================

    public String getUrl() {
        String imgIdStr = String.valueOf(imageId);
        StringBuilder url = new StringBuilder();
        url.append("http://10.211.55.5/relaisduson/img/p/");
        int compteur = 0;
        while (compteur < imgIdStr.length()) {
            url.append(imgIdStr.charAt(compteur) + "/");
            compteur++;
        }
        url.append(imgIdStr + ".jpg");
        return url.toString();
    }

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
     * Retourne categoryName
     * 
     * @return categoryName
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * Retourne imageId
     * 
     * @return imageId
     */
    public int getImageId() {
        return imageId;
    }
    // ===== Classes imbriquées ===============================================
}

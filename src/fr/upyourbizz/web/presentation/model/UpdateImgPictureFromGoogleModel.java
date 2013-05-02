package fr.upyourbizz.web.presentation.model;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.upyourbizz.web.dto.ProductInfo;

public class UpdateImgPictureFromGoogleModel {

    // ===== Attributs statiques ==============================================

    @SuppressWarnings("unused")
    private final Logger logger = LoggerFactory.getLogger(UpdateImgPictureFromGoogleModel.class);

    // ===== Méthodes statiques ===============================================

    // ===== Attributs ========================================================

    private List<ProductInfoPresentation> productInfoList = new ArrayList<ProductInfoPresentation>();

    private int firstProductOffset = 0;

    private int goToIdProduct = 0;

    private ProductInfoPresentation selectedProduct;

    private String selectedImg = "www.empty.com";

    private String urlNewImg = "";

    // ===== Constructeurs ====================================================

    // ===== Méthodes =========================================================

    /**
     * Affecte productInfoList
     * 
     * @param productInfoList productInfoList à affecter
     */
    public void addNewProductsInfo(List<ProductInfo> productsInfo) {
        productInfoList = new ArrayList<ProductInfoPresentation>();
        for (ProductInfo productInfo : productsInfo) {
            productInfoList.add(new ProductInfoPresentation(productInfo));
        }
        selectedProduct = productInfoList.get(0);
    }

    // ===== Accesseurs =======================================================

    /**
     * Retourne productInfoList
     * 
     * @return productInfoList
     */
    public List<ProductInfoPresentation> getProductInfoList() {
        return productInfoList;
    }

    /**
     * Retourne firstProductOffset
     * 
     * @return firstProductOffset
     */
    public int getFirstProductOffset() {
        return firstProductOffset;
    }

    /**
     * Affecte firstProductOffset
     * 
     * @param firstProductOffset firstProductOffset à affecter
     */
    public void setFirstProductOffset(int firstProductOffset) {
        this.firstProductOffset = firstProductOffset;
    }

    /**
     * Retourne goToIdProduct
     * 
     * @return goToIdProduct
     */
    public int getGoToIdProduct() {
        return goToIdProduct;
    }

    /**
     * Affecte goToIdProduct
     * 
     * @param goToIdProduct goToIdProduct à affecter
     */
    public void setGoToIdProduct(int goToIdProduct) {
        this.goToIdProduct = goToIdProduct;
    }

    /**
     * Retourne selectedProduct
     * 
     * @return selectedProduct
     */
    public ProductInfoPresentation getSelectedProduct() {
        return selectedProduct;
    }

    /**
     * Affecte selectedProduct
     * 
     * @param selectedProduct selectedProduct à affecter
     */
    public void setSelectedProduct(ProductInfoPresentation selectedProduct) {
        this.selectedProduct = selectedProduct;
    }

    /**
     * Retourne selectedImg
     * 
     * @return selectedImg
     */
    public String getSelectedImg() {
        return selectedImg;
    }

    /**
     * Affecte selectedImg
     * 
     * @param selectedImg selectedImg à affecter
     */
    public void setSelectedImg(String selectedImg) {
        this.selectedImg = selectedImg;
    }

    /**
     * Retourne urlNewImg
     * 
     * @return urlNewImg
     */
    public String getUrlNewImg() {
        return urlNewImg;
    }

    /**
     * Affecte urlNewImg
     * 
     * @param urlNewImg urlNewImg à affecter
     */
    public void setUrlNewImg(String urlNewImg) {
        this.urlNewImg = urlNewImg;
    }

    // ===== Classes imbriquées ===============================================
    public class ProductInfoPresentation {

        // ===== Attributs statiques ==========================================

        // ===== Méthodes statiques ===========================================

        // ===== Attributs ====================================================

        private final int productId;

        private final String productName;

        private final int imageId;

        private boolean imgModified;

        private List<String> googleImgUrls = new ArrayList<String>();

        // ===== Constructeurs ===============================================

        public ProductInfoPresentation(int productId, String productName, String categoryName,
                int imageId, boolean imgModified) {
            super();
            this.productId = productId;
            this.productName = productName;
            this.imageId = imageId;
            this.imgModified = imgModified;
        }

        public ProductInfoPresentation(ProductInfo productInfo) {
            this.productId = productInfo.getProductId();
            this.productName = productInfo.getProductName();
            this.imageId = productInfo.getImageId();
            this.imgModified = productInfo.isImgModified();
        }

        // ===== Méthodes ===================================================

        public String getUrl() {
            String imgIdStr = String.valueOf(imageId);
            StringBuilder url = new StringBuilder();
            url.append("http://mikael.upyourbizz.biz/img/p/");
            int compteur = 0;
            while (compteur < imgIdStr.length()) {
                url.append(imgIdStr.charAt(compteur) + "/");
                compteur++;
            }
            url.append(imgIdStr + ".jpg");
            return url.toString();
        }

        /**
         * @return the style
         */
        public String getStyle() {
            String result = "";
            if (imgModified) {
                result = ";background-color: #8FCF3C;";
            }
            return result;
        }

        // ===== Accesseurs ================================================
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
         * Affecte googleImgUrls
         * 
         * @param googleImgUrls googleImgUrls à affecter
         */
        public void setGoogleImgUrls(List<String> googleImgUrls) {
            this.googleImgUrls = googleImgUrls;
        }

        /**
         * Retourne googleImgUrls
         * 
         * @return googleImgUrls
         */
        public List<String> getGoogleImgUrls() {
            return googleImgUrls;
        }

        /**
         * Retourne imgModified
         * 
         * @return imgModified
         */
        public boolean isImgModified() {
            return imgModified;
        }

        /**
         * Affecte imgModified
         * 
         * @param imgModified imgModified à affecter
         */
        public void setImgModified(boolean imgModified) {
            this.imgModified = imgModified;
        }

        // ===== Classes imbriquées =========================================
    }
}

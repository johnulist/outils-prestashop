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

    // ===== Classes imbriquées ===============================================
    public class ProductInfoPresentation {

        // ===== Attributs statiques ==========================================

        // ===== Méthodes statiques ===========================================

        // ===== Attributs ====================================================

        private final int productId;

        private final String productName;

        private final String categoryName;

        private final int imageId;

        private List<String> googleImgUrls = new ArrayList<String>();

        // ===== Constructeurs ===============================================

        public ProductInfoPresentation(int productId, String productName, String categoryName,
                int imageId) {
            super();
            this.productId = productId;
            this.productName = productName;
            this.categoryName = categoryName;
            this.imageId = imageId;
        }

        public ProductInfoPresentation(ProductInfo productInfo) {
            this.productId = productInfo.getProductId();
            this.productName = productInfo.getProductName();
            this.categoryName = productInfo.getCategoryName();
            this.imageId = productInfo.getImageId();
            googleImgUrls.add("http://www.aevas-sono.com/evas/images/formule-pack-light-sono.jpg");
            googleImgUrls.add("http://animation-location-sonorisation.scenic-14.com/sono-caen/sono-caen.jpg");
            googleImgUrls.add("http://image1.trefle.com/images/service-divers/full/sonorisation-mariage-dj-sono-animation-pro-lumiere.21817554-80645017.jpg");
            googleImgUrls.add("http://www.tuningfever.fr/pics-med-13307-277046-sono-alpine.jpg");
            googleImgUrls.add("http://www.eveniums-concept.com/IMG/jpg/sono-plage2.jpg");
            /*
             * googleImgUrls.add(
             * "http://animation.francisco.pagesperso-orange.fr/image/sono3.JPG"
             * ); googleImgUrls.add(
             * "http://www.sono-energie.com/Files/29805/Img/21/stroboscope-kool-light-strobe-1000-1.jpg"
             * ); googleImgUrls.add(
             * "http://benoit.cara.free.fr/sonorisation/location_sono_100.gif");
             * googleImgUrls.add(
             * "http://perlbal.hi-pi.com/blog-images/246724/gd/1252110911/sono.jpg"
             * ); googleImgUrls.add(
             * "http://www.espacemusical.fr/images/Image/systeme%20son/YAMAHA+STAGEPAS+300+SONO+COMPACTE.JPG"
             * );
             */
        }

        // ===== Méthodes ===================================================

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

        // ===== Classes imbriquées =========================================
    }
}

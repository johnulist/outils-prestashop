package fr.upyourbizz.web.coordination;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.upyourbizz.web.dto.ProductInfo;
import fr.upyourbizz.web.service.GoogleImageService;
import fr.upyourbizz.web.service.ProductManagementService;

public class UpdateImgPictureFromGoogleCoordinator {

    // ===== Attributs statiques ==============================================

    @SuppressWarnings("unused")
    private final Logger logger = LoggerFactory.getLogger(UpdateImgPictureFromGoogleCoordinator.class);

    // ===== Méthodes statiques ===============================================

    // ===== Attributs ========================================================

    private ProductManagementService productManagementService;

    private GoogleImageService googleImageService;

    // ===== Constructeurs ====================================================

    // ===== Méthodes =========================================================

    /**
     * Return the list of products informations
     * 
     * @param idFirstProduct Id of the fist product
     * @param nbMaxProducts The maximum number of items returned
     * @return the list of products informations
     */
    public List<ProductInfo> getProductsInformation(int idFirstProduct, int nbMaxProducts) {
        return productManagementService.getProductsInformation(idFirstProduct, nbMaxProducts);
    }

    public List<String> searchProductImages(String productName) throws IOException {
        return googleImageService.searchProductImages(productName);
    }

    // ===== Accesseurs =======================================================

    /**
     * Affecte productManagementService
     * 
     * @param productManagementService productManagementService à affecter
     */
    public void setProductManagementService(ProductManagementService productManagementService) {
        this.productManagementService = productManagementService;
    }

    /**
     * Affecte googleImageService
     * 
     * @param googleImageService googleImageService à affecter
     */
    public void setGoogleImageService(GoogleImageService googleImageService) {
        this.googleImageService = googleImageService;
    }

    // ===== Classes imbriquées ===============================================
}

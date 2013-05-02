package fr.upyourbizz.web.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.upyourbizz.web.dto.ProductInfo;
import fr.upyourbizz.web.persistence.ProductDao;

public class ProductManagementService {

    // ===== Attributs statiques ==============================================

    @SuppressWarnings("unused")
    private final Logger logger = LoggerFactory.getLogger(ProductManagementService.class);

    // ===== Méthodes statiques ===============================================

    // ===== Attributs ========================================================

    private ProductDao productDao;

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
        return productDao.getProductsInformation(idFirstProduct, nbMaxProducts);
    }

    /**
     * Database update to indicate image modification
     * 
     * @param imageId The image id
     */
    public void imageModificationNotification(int imageId) {
        productDao.imageModificationNotification(imageId);
    }

    // ===== Accesseurs =======================================================

    /**
     * Affecte productDao
     * 
     * @param productDao productDao à affecter
     */
    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    // ===== Classes imbriquées ===============================================
}

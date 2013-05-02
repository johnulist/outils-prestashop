package fr.upyourbizz.web.coordination;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.upyourbizz.web.dto.ProductInfo;
import fr.upyourbizz.web.service.FileManagementService;
import fr.upyourbizz.web.service.GoogleImageService;
import fr.upyourbizz.web.service.ProductManagementService;

/**
 * UpdateImgPictureFromGoogleCoordinator
 */
public class UpdateImgPictureFromGoogleCoordinator {

    // ===== Attributs statiques ==============================================

    @SuppressWarnings("unused")
    private final Logger logger = LoggerFactory.getLogger(UpdateImgPictureFromGoogleCoordinator.class);

    // ===== Méthodes statiques ===============================================

    // ===== Attributs ========================================================

    private ProductManagementService productManagementService;

    private GoogleImageService googleImageService;

    private FileManagementService fileManagementService;

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

    /**
     * Save the file from internet to the disk.
     * 
     * @param url The file url
     * @param fileName The name given to the new image
     * @throws IOException
     * @throws MalformedURLException
     */
    public void saveFileOnDiskFromUrl(String url, String fileName) throws MalformedURLException,
            IOException {
        fileManagementService.saveFileOnDiskFromUrl(url, fileName);
    }

    /**
     * Notifie database about the image modification
     * 
     * @param imageId The image id
     */
    public void imageModificationNotification(int imageId) {
        productManagementService.imageModificationNotification(imageId);
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

    /**
     * Affecte fileManagementService
     * 
     * @param fileManagementService fileManagementService à affecter
     */
    public void setFileManagementService(FileManagementService fileManagementService) {
        this.fileManagementService = fileManagementService;
    }

    // ===== Classes imbriquées ===============================================
}

package fr.upyourbizz.web.presentation.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.event.ActionEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.upyourbizz.web.coordination.UpdateImgPictureFromGoogleCoordinator;
import fr.upyourbizz.web.dto.ProductInfo;
import fr.upyourbizz.web.presentation.GrowlBean;
import fr.upyourbizz.web.presentation.model.UpdateImgPictureFromGoogleModel;
import fr.upyourbizz.web.presentation.model.UpdateImgPictureFromGoogleModel.ProductInfoPresentation;

public class UpdateImgPictureFromGoogleController extends AbstractController {

    // ===== Attributs statiques ==============================================

    @SuppressWarnings("unused")
    private final Logger logger = LoggerFactory.getLogger(UpdateImgPictureFromGoogleController.class);

    // ===== Méthodes statiques ===============================================

    // ===== Attributs ========================================================

    private UpdateImgPictureFromGoogleModel updateImgPictureFromGoogleModel;

    private UpdateImgPictureFromGoogleCoordinator updateImgPictureFromGoogleCoordinator;

    private GrowlBean growlBean;

    // ===== Constructeurs ====================================================

    // ===== Méthodes =========================================================

    public void init() {
        if (!isPostback()) {
            int newOffset = 1;
            int nbMaxProducts = 20;
            initialiseProducts(newOffset, nbMaxProducts);

            // updateImgPictureFromGoogleModel.set
        }
    }

    private void initialiseProducts(int newOffset, int nbMaxProducts) {
        updateImgPictureFromGoogleModel.addNewProductsInfo(getProductsInfo(newOffset, nbMaxProducts));
        List<ProductInfoPresentation> productsList = updateImgPictureFromGoogleModel.getProductInfoList();
        if (!productsList.isEmpty()) {
            updateImgPictureFromGoogleModel.setFirstProductOffset(productsList.get(0).getProductId());
            for (ProductInfoPresentation product : productsList) {
                List<String> urlsImg = new ArrayList<String>();
                try {
                    urlsImg = updateImgPictureFromGoogleCoordinator.searchProductImages(product.getProductName());
                    product.setGoogleImgUrls(urlsImg);
                }
                catch (IOException e) {
                    logger.debug("Problem while searching product image");
                    e.printStackTrace();
                }
            }
        }
    }

    public void nextProducts(ActionEvent actionEvent) {
        int newOffset = updateImgPictureFromGoogleModel.getFirstProductOffset() + 20;
        initialiseProducts(newOffset, 20);
    }

    public void goToProducts(ActionEvent actionEvent) {
        int newOffset = updateImgPictureFromGoogleModel.getGoToIdProduct();
        initialiseProducts(newOffset, 20);
    }

    public void previousProducts(ActionEvent actionEvent) {
        int newOffset = updateImgPictureFromGoogleModel.getFirstProductOffset() - 20;
        if (newOffset < 0) {
            newOffset = 0;
        }
        initialiseProducts(newOffset, 20);
    }

    public void useNewImage() {
        logger.debug("New image selected. Product id:"
                + updateImgPictureFromGoogleModel.getSelectedProduct().getProductId());
        logger.debug("Url:" + updateImgPictureFromGoogleModel.getSelectedImg());
        try {
            updateImgPictureFromGoogleCoordinator.saveFileOnDiskFromUrl(
                    updateImgPictureFromGoogleModel.getSelectedImg(),
                    String.valueOf(updateImgPictureFromGoogleModel.getSelectedProduct().getImageId())
                            + ".jpg");
            updateImgPictureFromGoogleCoordinator.imageModificationNotification(updateImgPictureFromGoogleModel.getSelectedProduct().getImageId());
            updateImgPictureFromGoogleModel.getSelectedProduct().setImgModified(true);
            growlBean.setText("La nouvelle image a été enregistrée avec succès");
            growlBean.display();
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
            logger.debug("Error while attemping to save the image on disk");
            growlBean.setText("La nouvelle image n'a pas été enregistrée");
            growlBean.display();
        }
        catch (IOException e) {
            e.printStackTrace();
            logger.debug("Error while attemping to save the image on disk");
            growlBean.setText("La nouvelle image n'a pas été enregistrée");
            growlBean.display();
        }
    }

    public void addNewUrl() {
        if (!updateImgPictureFromGoogleModel.getUrlNewImg().isEmpty()
                && updateImgPictureFromGoogleModel.getSelectedProduct() != null) {
            updateImgPictureFromGoogleModel.getSelectedProduct().getGoogleImgUrls().add(
                    updateImgPictureFromGoogleModel.getUrlNewImg());
        }
    }

    /**
     * Return the list of products informations
     * 
     * @param idFirstProduct Id of the fist product
     * @param nbMaxProduct The maximum number of items returned
     * @return
     */
    private List<ProductInfo> getProductsInfo(int idFirstProduct, int nbMaxProducts) {
        return updateImgPictureFromGoogleCoordinator.getProductsInformation(idFirstProduct,
                nbMaxProducts);
    }

    // ===== Accesseurs =======================================================

    /**
     * Affecte updateImgPictureFromGoogleModel
     * 
     * @param updateImgPictureFromGoogleModel updateImgPictureFromGoogleModel à
     *            affecter
     */
    public void setUpdateImgPictureFromGoogleModel(
            UpdateImgPictureFromGoogleModel updateImgPictureFromGoogleModel) {
        this.updateImgPictureFromGoogleModel = updateImgPictureFromGoogleModel;
    }

    /**
     * Affecte updateImgPictureFromGoogleCoordinator
     * 
     * @param updateImgPictureFromGoogleCoordinator
     *            updateImgPictureFromGoogleCoordinator à affecter
     */
    public void setUpdateImgPictureFromGoogleCoordinator(
            UpdateImgPictureFromGoogleCoordinator updateImgPictureFromGoogleCoordinator) {
        this.updateImgPictureFromGoogleCoordinator = updateImgPictureFromGoogleCoordinator;
    }

    /**
     * Affecte growlBean
     * 
     * @param growlBean growlBean à affecter
     */
    public void setGrowlBean(GrowlBean growlBean) {
        this.growlBean = growlBean;
    }

    // ===== Classes imbriquées ===============================================
}

package fr.upyourbizz.web.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.upyourbizz.web.dto.ProductInfo;

public class ProductDao {

    // ===== Attributs statiques ==============================================

    private final Logger logger = LoggerFactory.getLogger(ProductDao.class);

    // ===== Méthodes statiques ===============================================

    // ===== Attributs ========================================================

    private DataSource ds;

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
        List<ProductInfo> productsInformation = new ArrayList<ProductInfo>();
        try {

            Connection connection = ds.getConnection();
            StringBuilder requete = new StringBuilder();
            requete.append(" select distinct prod.id_product as idProd, img.id_image as idImage, updateinfo.id_update as idUpdate, ");
            requete.append(" lang.name as ProdName from relaisduson.relaisdu_product prod  ");
            requete.append(" inner join relaisduson.relaisdu_image img  ");
            requete.append(" on prod.id_product = img.id_product  ");
            requete.append(" inner join relaisduson.relaisdu_product_lang lang ");
            requete.append(" on lang.id_product = img.id_product  ");
            requete.append(" inner join relaisduson.relaisdu_category_product catprod ");
            requete.append(" on catprod.id_product = prod.id_product ");
            requete.append(" inner join relaisduson.relaisdu_category_lang catlang ");
            requete.append(" on catlang.id_category = catprod.id_category ");
            requete.append(" left join relaisduson.relaisdu_image_update_info updateinfo");
            requete.append(" on img.id_image = updateinfo.id_image ");
            requete.append(" where prod.id_product>? limit 0,? ");

            PreparedStatement preStatement = connection.prepareStatement(requete.toString());
            preStatement.setInt(1, idFirstProduct);
            preStatement.setInt(2, nbMaxProducts);

            ResultSet result = preStatement.executeQuery();

            while (result.next()) {
                Integer idUpdate = result.getInt("idUpdate");
                productsInformation.add(new ProductInfo(result.getInt("idProd"),
                        result.getString("ProdName"), result.getInt("idImage"), idUpdate != 0));
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
            logger.error("Erreur Sql" + e.getMessage());
        }
        return productsInformation;
    }

    /**
     * Database update to indicate image modification
     * 
     * @param imageId The image id
     */
    public void imageModificationNotification(int imageId) {
        try {

            Connection connection = ds.getConnection();
            StringBuilder requete = new StringBuilder();
            requete.append(" INSERT INTO `relaisdu_image_update_info` (id_image) VALUES(?) ");

            PreparedStatement preStatement = connection.prepareStatement(requete.toString());
            preStatement.setInt(1, imageId);

            int result = preStatement.executeUpdate();
            if (result > 0) {
                logger.debug("One row update");
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
            logger.error("Erreur Sql" + e.getMessage());
        }
    }

    // ===== Accesseurs =======================================================

    /**
     * Affecte ds
     * 
     * @param ds ds à affecter
     */
    public void setDs(DataSource ds) {
        this.ds = ds;
    }

    // ===== Classes imbriquées ===============================================
}

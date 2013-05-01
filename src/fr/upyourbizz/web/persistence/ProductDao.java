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
        // get database connection
        List<ProductInfo> productsInformation = new ArrayList<ProductInfo>();
        try {

            // // Obtain our environment naming context
            // Context initCtx = new InitialContext();
            // Context envCtx = (Context) initCtx.lookup("java:comp/env");
            //
            // // Look up our data source
            // DataSource ds = (DataSource) envCtx.lookup("jdbc/Default");
            //
            // // Allocate and use a connection from the pool
            // Connection conn = ds.getConnection();
            // // ... use this connection to access the database ...
            // conn.close();

            Connection connection = ds.getConnection();
            StringBuilder requete = new StringBuilder();
            requete.append(" select distinct prod.id_product as idProd, catlang.name as CatName,img.id_image as idImage,  ");
            requete.append(" lang.name as ProdName from relaisduson.relaisdu_product prod  ");
            requete.append(" inner join relaisduson.relaisdu_image img  ");
            requete.append(" on prod.id_product = img.id_product  ");
            requete.append(" inner join relaisduson.relaisdu_product_lang lang ");
            requete.append(" on lang.id_product = img.id_product  ");
            requete.append(" inner join relaisduson.relaisdu_category_product catprod ");
            requete.append(" on catprod.id_product = prod.id_product ");
            requete.append(" inner join relaisduson.relaisdu_category_lang catlang ");
            requete.append(" on catlang.id_category = catprod.id_category ");
            requete.append(" where prod.id_product>? limit 0,? ");

            PreparedStatement preStatement = connection.prepareStatement(requete.toString());
            preStatement.setInt(1, idFirstProduct);
            preStatement.setInt(2, nbMaxProducts);

            ResultSet result = preStatement.executeQuery();

            while (result.next()) {
                // System.out.println("Product id: " + result.getInt("idProd"));
                // System.out.println("Category name: " +
                // result.getString("CatName"));
                // System.out.println("Img id: " + result.getInt("idImage"));
                // System.out.println("Product name: " +
                // result.getString("ProdName"));
                productsInformation.add(new ProductInfo(result.getInt("idProd"),
                        result.getString("ProdName"), result.getString("CatName"),
                        result.getInt("idImage")));
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
            logger.error("Erreur Sql" + e.getMessage());
        }
        return productsInformation;
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

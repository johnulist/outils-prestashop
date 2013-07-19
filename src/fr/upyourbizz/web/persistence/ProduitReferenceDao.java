package fr.upyourbizz.web.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.upyourbizz.utils.exception.TechnicalException;
import fr.upyourbizz.web.dto.PrixDegressifProduitDto;
import fr.upyourbizz.web.dto.ProduitFamilleDto;
import fr.upyourbizz.web.dto.ProduitReferenceDto;
import fr.upyourbizz.web.dto.ProduitSousFamilleDto;

public class ProduitReferenceDao {

    // ===== Attributs statiques ==============================================

    @SuppressWarnings("unused")
    private final Logger logger = LoggerFactory.getLogger(ProduitReferenceDao.class);

    // ===== Méthodes statiques ===============================================

    // ===== Attributs ========================================================

    private DataSource ds;

    // ===== Constructeurs ====================================================

    // ===== Méthodes =========================================================

    public ProduitReferenceDto recupererProduitReference(int idProduitReference)
            throws TechnicalException {

        try {

            Connection connection = ds.getConnection();
            StringBuilder requete = new StringBuilder();
            requete.append(" select pr.id_produit_reference, pr.id_produit_famille, pr.id_produit_sous_famille, ");
            requete.append(" pr.reference_produit, pr.nom, pr.description_courte, pr.description_longue, ");
            requete.append(" pr.description_offre, pr.avantages, pr.benefices, pr.url_img_illustration_produit,  ");
            requete.append(" pr.url_img_icone_produit, pr.url_img_processus, pr.cout_nominal, pr.prix_unitaire,  ");
            requete.append(" pr.commentaire, pdp.id_tableau_prix_degressif_produit , pdp.borne_inferieure, ");
            requete.append(" pdp.borne_superieure, pdp.prix_unitaire ");
            requete.append(" from produit_reference pr  ");
            requete.append(" inner join produit_famille pf on pf.id_produit_famille = pr.id_produit_famille ");
            requete.append(" inner join produit_sous_famille psf on psf.id_produit_sous_famille = pr.id_produit_sous_famille ");
            requete.append(" left join prix_degressif_produit pdp on pr.id_produit_reference = pdp.id_produit_reference  ");
            requete.append(" where pr.id_produit_reference = ? ");

            PreparedStatement preStatement = connection.prepareStatement(requete.toString());
            preStatement.setInt(1, idProduitReference);

            ResultSet result = preStatement.executeQuery();

            ProduitReferenceDto resultat = null;
            PrixDegressifProduitDto prixDegressifProduit = new PrixDegressifProduitDto();
            while (result.next()) {
                boolean premierAppel = (resultat == null);
                if (premierAppel) {
                    ProduitFamilleDto famille = new ProduitFamilleDto();
                    ProduitSousFamilleDto sousFamille = new ProduitSousFamilleDto();
                    resultat = new ProduitReferenceDto(result.getInt("id_produit_reference"),
                            famille, sousFamille, result.getString("pr.reference_produit"),
                            result.getString("pr.nom"), result.getString("pr.description_courte"),
                            result.getString("pr.description_longue"),
                            result.getString("pr.description_offre"),
                            result.getString("pr.avantages"), result.getString("pr.benefices"),
                            result.getString("pr.url_img_illustration_produit"),
                            result.getString("pr.url_img_icone_produit"),
                            result.getString("pr.url_img_processus"),
                            result.getFloat("pr.cout_nominal"), result.getString("pr.commentaire"));
                }
                Float prixUnitaire = result.getFloat("pr.prix_unitaire");
                if (prixUnitaire != null && prixUnitaire != 0F) {
                    resultat.setPrixUnitaire(prixUnitaire);
                }
                else {
                    prixDegressifProduit.ajouterPrixDegressif(
                            result.getInt("pdp.id_tableau_prix_degressif_produit"),
                            result.getInt("pdp.borne_inferieure"),
                            result.getInt("pdp.borne_superieure"),
                            result.getFloat("pdp.prix_unitaire"));
                    resultat.setPrixDegressifProduit(prixDegressifProduit);
                }
            }
            return resultat;
        }
        catch (SQLException e) {
            e.printStackTrace();
            logger.error("Erreur Sql" + e.getMessage());
            throw new TechnicalException("Erreur Sql" + e.getMessage());
        }
    }

    public List<ProduitReferenceDto> listerProduitReferenceSousFamille(int idSousFamille) {
        return null;
    }

    public List<String> listerFamille() throws TechnicalException {
        // TODO Ébauche de méthode auto-générée
        return null;
    }

    public List<String> listerSousFamille(String nomFamille) throws TechnicalException {
        // TODO Ébauche de méthode auto-générée
        return null;
    }

    public List<ProduitReferenceDto> listerProduitsReference(String nomSousFamille)
            throws TechnicalException {
        // TODO Ébauche de méthode auto-générée
        return null;
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

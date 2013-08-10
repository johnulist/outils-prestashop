package fr.upyourbizz.web.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import com.mysql.jdbc.Statement;

import fr.upyourbizz.utils.exception.TechnicalException;
import fr.upyourbizz.web.dto.OptionReference;
import fr.upyourbizz.web.dto.PrixDegressif;
import fr.upyourbizz.web.dto.PrixDegressifProduitDto;
import fr.upyourbizz.web.dto.ProduitFamilleDto;
import fr.upyourbizz.web.dto.ProduitReferenceDto;
import fr.upyourbizz.web.dto.ProduitSousFamilleDto;

public class ProduitReferenceDao {

    // ===== Attributs statiques ==============================================

    private final Logger logger = LoggerFactory.getLogger(ProduitReferenceDao.class);

    private final static String REQUETE_SELECT_SOUS_FAMILLE = "(select id_produit_sous_famille from produit_sous_famille where nom = ?)";

    // ===== Méthodes statiques ===============================================

    // ===== Attributs ========================================================

    private DataSource ds;

    // ===== Constructeurs ====================================================

    // ===== Méthodes =========================================================

    /**
     * Récupère le produit référence dont l'id est passé en paramètre
     * 
     * @param idProduitReference L'id du produit de référence
     * @return Le produit de référence
     * @throws TechnicalException
     */
    public ProduitReferenceDto recupererProduitReference(int idProduitReference)
            throws TechnicalException {

        try {

            Connection connection = ds.getConnection();
            StringBuilder requete = new StringBuilder();
            requete.append(" select pr.id_produit_reference, psf.nom, pf.nom, ");
            requete.append(" pr.reference_produit, pr.nom, pr.description_courte, pr.description_longue, ");
            requete.append(" pr.description_offre, pr.avantages, pr.benefices, pr.url_img_illustration_produit,  ");
            requete.append(" pr.url_img_icone_produit, pr.url_img_processus, pr.cout_nominal, pr.prix_unitaire,  ");
            requete.append(" pr.commentaire, pdp.id_tableau_prix_degressif_produit , pdp.borne_inferieure, ");
            requete.append(" pdp.borne_superieure, pdp.prix_unitaire ");
            requete.append(" from produit_reference pr  ");
            requete.append(" inner join produit_sous_famille psf on psf.id_produit_sous_famille = pr.id_produit_sous_famille ");
            requete.append(" inner join produit_famille pf on pf.id_produit_famille = psf.id_produit_famille ");
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
                    famille.setNomFamille(result.getString("pf.nom"));
                    ProduitSousFamilleDto sousFamille = new ProduitSousFamilleDto();
                    sousFamille.setNomFamille(result.getString("psf.nom"));
                    resultat = new ProduitReferenceDto(sousFamille,
                            result.getString("pr.reference_produit"), result.getString("pr.nom"),
                            result.getString("pr.description_courte"),
                            result.getString("pr.description_longue"),
                            result.getString("pr.description_offre"),
                            result.getString("pr.avantages"), result.getString("pr.benefices"),
                            result.getString("pr.url_img_illustration_produit"),
                            result.getString("pr.url_img_icone_produit"),
                            result.getString("pr.url_img_processus"),
                            result.getFloat("pr.cout_nominal"), result.getString("pr.commentaire"));
                    resultat.setIdProduit(result.getInt("id_produit_reference"));
                    resultat.setFamille(famille);
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

    public List<ProduitReferenceDto> listerProduitsReference(String nomSousFamille)
            throws TechnicalException {
        try {

            Connection connection = ds.getConnection();
            StringBuilder requete = new StringBuilder();
            requete.append(" select pr.id_produit_reference, psf.nom, pf.nom, ");
            requete.append(" pr.reference_produit, pr.nom, pr.description_courte, pr.description_longue, ");
            requete.append(" pr.description_offre, pr.avantages, pr.benefices, pr.url_img_illustration_produit,  ");
            requete.append(" pr.url_img_icone_produit, pr.url_img_processus, pr.cout_nominal, pr.prix_unitaire,  ");
            requete.append(" pr.commentaire ");
            requete.append(" from produit_reference pr  ");
            requete.append(" inner join produit_sous_famille psf on psf.id_produit_sous_famille = pr.id_produit_sous_famille ");
            requete.append(" inner join produit_famille pf on pf.id_produit_famille = psf.id_produit_famille ");
            requete.append(" where pr.id_produit_sous_famille = ");
            requete.append(REQUETE_SELECT_SOUS_FAMILLE);

            PreparedStatement preStatement = connection.prepareStatement(requete.toString());
            preStatement.setString(1, nomSousFamille);

            ResultSet result = preStatement.executeQuery();

            List<ProduitReferenceDto> listeProduitsRef = new ArrayList<ProduitReferenceDto>();
            while (result.next()) {
                ProduitFamilleDto famille = new ProduitFamilleDto();
                famille.setNomFamille(result.getString("pf.nom"));
                ProduitSousFamilleDto sousFamille = new ProduitSousFamilleDto();
                sousFamille.setNomFamille(result.getString("psf.nom"));
                ProduitReferenceDto produitReference = new ProduitReferenceDto(sousFamille,
                        result.getString("pr.reference_produit"), result.getString("pr.nom"),
                        result.getString("pr.description_courte"),
                        result.getString("pr.description_longue"),
                        result.getString("pr.description_offre"), result.getString("pr.avantages"),
                        result.getString("pr.benefices"),
                        result.getString("pr.url_img_illustration_produit"),
                        result.getString("pr.url_img_icone_produit"),
                        result.getString("pr.url_img_processus"),
                        result.getFloat("pr.cout_nominal"), result.getString("pr.commentaire"));
                produitReference.setIdProduit(result.getInt("id_produit_reference"));
                produitReference.setFamille(famille);

                listeProduitsRef.add(produitReference);
            }
            return listeProduitsRef;
        }
        catch (SQLException e) {
            e.printStackTrace();
            logger.error("Erreur Sql" + e.getMessage());
            throw new TechnicalException("Erreur Sql" + e.getMessage());
        }
    }

    /**
     * Ajout d'un nouveau produit de référence.
     * 
     * @param nomSousFamille Le nom de la sous famille du produit
     * @param referenceProduit Référence donnée au produit
     * @param nom Le nom du produit
     * @param descriptionCourte La description courte du produit
     * @param descriptionLongue La description longue
     * @param descriptionOffre La description de l'offre associèe
     * @param avantages Les avantages du produit
     * @param benefices Les bénéfices du produit
     * @param coutNominal
     * @param prixUnitaire
     * @param urlImgIllustrationProduit
     * @param urlImgIconeProduit
     * @param urlImgProcessus
     * @return L'id du produit ajouté. -1 s'il le produit n'a pas été ajouté
     * @throws TechnicalException Exception levée en cas d'erreur
     */
    @Transactional(rollbackFor = { TechnicalException.class })
    public int ajouterProduitReference(String nomSousFamille, String referenceProduit, String nom,
            String descriptionCourte, String descriptionLongue, String descriptionOffre,
            String avantages, String benefices, float coutNominal, float prixUnitaire,
            String urlImgIllustrationProduit, String urlImgIconeProduit, String urlImgProcessus)
            throws TechnicalException {
        int nouvelleClefProduit = -1;
        try {
            Connection connection = ds.getConnection();
            StringBuilder requete = new StringBuilder();
            StringBuilder vars = new StringBuilder();
            StringBuilder values = new StringBuilder();

            vars.append(" id_produit_sous_famille, reference_produit, nom, ");
            vars.append(" description_courte, description_longue, description_offre, ");
            vars.append(" avantages, benefices, cout_nominal ");
            values.append(" " + REQUETE_SELECT_SOUS_FAMILLE + ",?,?,?,?,?,?,?,? ");
            if (prixUnitaire != 0F) {
                vars.append(",prix_unitaire ");
                values.append(",?");
            }
            if (urlImgIllustrationProduit != null && !urlImgIllustrationProduit.isEmpty()) {
                vars.append(",url_img_illustration_produit ");
                values.append(",?");
            }

            if (urlImgIconeProduit != null && !urlImgIconeProduit.isEmpty()) {
                vars.append(",url_img_illustration_produit ");
                values.append(",?");
            }

            if (urlImgProcessus != null && !urlImgProcessus.isEmpty()) {
                vars.append(",url_img_illustration_produit ");
                values.append(",?");
            }

            requete.append(" insert into produit_reference ( ");
            requete.append(vars.toString());
            requete.append(" ) value ( ");
            requete.append(values.toString());
            requete.append(") ");

            PreparedStatement preStatement = connection.prepareStatement(requete.toString(),
                    Statement.RETURN_GENERATED_KEYS);
            preStatement.setString(1, nomSousFamille);
            preStatement.setString(2, referenceProduit);
            preStatement.setString(3, nom);
            preStatement.setString(4, descriptionCourte);
            preStatement.setString(5, descriptionLongue);
            preStatement.setString(6, descriptionOffre);
            preStatement.setString(7, avantages);
            preStatement.setString(8, benefices);
            preStatement.setFloat(9, coutNominal);

            int prochainValeurCompteur = 10;
            if (prixUnitaire != 0F) {
                preStatement.setFloat(prochainValeurCompteur, prixUnitaire);
                prochainValeurCompteur++;
            }
            if (urlImgIllustrationProduit != null && !urlImgIllustrationProduit.isEmpty()) {
                preStatement.setString(prochainValeurCompteur, urlImgIllustrationProduit);
                prochainValeurCompteur++;
            }

            if (urlImgIconeProduit != null && !urlImgIconeProduit.isEmpty()) {
                preStatement.setString(prochainValeurCompteur, urlImgIconeProduit);
                prochainValeurCompteur++;
            }

            if (urlImgProcessus != null && !urlImgProcessus.isEmpty()) {
                preStatement.setString(prochainValeurCompteur, urlImgProcessus);
                prochainValeurCompteur++;
            }

            preStatement.executeUpdate();
            ResultSet generatedKeys = preStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                nouvelleClefProduit = generatedKeys.getInt(1);
            }
            logger.debug("Ajout d'un nouveau produit: " + nom);
            return nouvelleClefProduit;
        }
        catch (SQLException e) {
            e.printStackTrace();
            logger.error("Erreur Sql" + e.getMessage());
            throw new TechnicalException("Erreur Sql" + e.getMessage());
        }
    }

    /**
     * Ajout d'un nouveau produit de référence.
     * 
     * @param idProduitReference L'id du produit à mettre à jour
     * @param nomSousFamille Le nom de la sous famille du produit
     * @param referenceProduit Référence donnée au produit
     * @param nom Le nom du produit
     * @param descriptionCourte La description courte du produit
     * @param descriptionLongue La description longue
     * @param descriptionOffre La description de l'offre associèe
     * @param avantages Les avantages du produit
     * @param benefices Les bénéfices du produit
     * @param urlImgIllustrationProduit
     * @param urlImgIconeProduit
     * @param urlImgProcessus
     * @throws TechnicalException Exception levée en cas d'erreur
     */
    @Transactional(rollbackFor = { TechnicalException.class })
    public void modifierProduitReference(int idProduitReference, String nomSousFamille,
            String referenceProduit, String nom, String descriptionCourte,
            String descriptionLongue, String descriptionOffre, String avantages, String benefices,
            float coutNominal, float prixUnitaire, String urlImgIllustrationProduit,
            String urlImgIconeProduit, String urlImgProcessus) throws TechnicalException {
        try {
            String REQUETE_SELECT_SOUS_FAMILLE = "(select id_produit_sous_famille from produit_sous_famille where nom = ?)";

            Connection connection = ds.getConnection();
            StringBuilder requete = new StringBuilder();
            requete.append(" update produit_reference set ");
            requete.append(" id_produit_sous_famille = " + REQUETE_SELECT_SOUS_FAMILLE
                    + ", reference_produit = ?, nom = ?, ");
            requete.append(" description_courte = ?, description_longue = ?, description_offre = ?, ");
            requete.append(" avantages = ?, benefices = ? ");
            if (coutNominal != 0F) {
                requete.append(",cout_nominal = ? ");
            }
            if (prixUnitaire != 0F) {
                requete.append(",prix_unitaire = ? ");
            }
            if (urlImgIllustrationProduit != null && !urlImgIllustrationProduit.isEmpty()) {
                requete.append(",url_img_illustration_produit = ? ");
            }

            if (urlImgIconeProduit != null && !urlImgIconeProduit.isEmpty()) {
                requete.append(",url_img_illustration_produit = ? ");
            }

            if (urlImgProcessus != null && !urlImgProcessus.isEmpty()) {
                requete.append(",url_img_illustration_produit = ? ");
            }
            requete.append(" where id_produit_reference = ?");

            PreparedStatement preStatement = connection.prepareStatement(requete.toString());
            preStatement.setString(1, nomSousFamille);
            preStatement.setString(2, referenceProduit);
            preStatement.setString(3, nom);
            preStatement.setString(4, descriptionCourte);
            preStatement.setString(5, descriptionLongue);
            preStatement.setString(6, descriptionOffre);
            preStatement.setString(7, avantages);
            preStatement.setString(8, benefices);

            int prochainValeurCompteur = 9;
            if (coutNominal != 0F) {
                preStatement.setFloat(prochainValeurCompteur, coutNominal);
                prochainValeurCompteur++;
            }
            if (prixUnitaire != 0F) {
                preStatement.setFloat(prochainValeurCompteur, prixUnitaire);
                prochainValeurCompteur++;
            }
            if (urlImgIllustrationProduit != null && !urlImgIllustrationProduit.isEmpty()) {
                preStatement.setString(prochainValeurCompteur, urlImgIllustrationProduit);
                prochainValeurCompteur++;
            }

            if (urlImgIconeProduit != null && !urlImgIconeProduit.isEmpty()) {
                preStatement.setString(prochainValeurCompteur, urlImgIconeProduit);
                prochainValeurCompteur++;
            }

            if (urlImgProcessus != null && !urlImgProcessus.isEmpty()) {
                preStatement.setString(prochainValeurCompteur, urlImgProcessus);
                prochainValeurCompteur++;
            }

            preStatement.setInt(prochainValeurCompteur, idProduitReference);

            preStatement.executeUpdate();
            logger.debug("Modification du produit: " + nom);
        }
        catch (SQLException e) {
            e.printStackTrace();
            logger.error("Erreur Sql" + e.getMessage());
            throw new TechnicalException("Erreur Sql" + e.getMessage());
        }
    }

    public List<ProduitSousFamilleDto> listerSousFamille(String nomFamille)
            throws TechnicalException {
        try {

            Connection connection = ds.getConnection();
            StringBuilder requete = new StringBuilder();
            requete.append(" select id_produit_sous_famille, id_produit_famille, nom, description, url_img_sous_famille ");
            requete.append(" from produit_sous_famille where id_produit_famille in ");
            requete.append(" (select id_produit_famille from produit_famille where nom = ?) ");

            PreparedStatement preStatement = connection.prepareStatement(requete.toString());
            preStatement.setString(1, nomFamille);

            ResultSet result = preStatement.executeQuery();

            List<ProduitSousFamilleDto> listeFamille = new ArrayList<ProduitSousFamilleDto>();
            while (result.next()) {
                listeFamille.add(new ProduitSousFamilleDto(
                        result.getInt("id_produit_sous_famille"),
                        result.getInt("id_produit_famille"), result.getString("nom"),
                        result.getString("description"), result.getString("url_img_sous_famille")));
            }
            return listeFamille;
        }
        catch (SQLException e) {
            e.printStackTrace();
            logger.error("Erreur Sql" + e.getMessage());
            throw new TechnicalException("Erreur Sql" + e.getMessage());
        }
    }

    /**
     * Liste les différentes familles de produits
     * 
     * @return la liste de famille
     * @throws TechnicalException
     */
    public List<ProduitFamilleDto> listerFamille() throws TechnicalException {
        try {

            Connection connection = ds.getConnection();
            StringBuilder requete = new StringBuilder();
            requete.append(" select id_produit_famille, nom, description, url_img_famille from produit_famille  ");

            PreparedStatement preStatement = connection.prepareStatement(requete.toString());

            ResultSet result = preStatement.executeQuery();

            List<ProduitFamilleDto> listeFamille = new ArrayList<ProduitFamilleDto>();
            while (result.next()) {
                listeFamille.add(new ProduitFamilleDto(result.getInt("id_produit_famille"),
                        result.getString("nom"), result.getString("description"),
                        result.getString("url_img_famille")));
            }
            return listeFamille;
        }
        catch (SQLException e) {
            e.printStackTrace();
            logger.error("Erreur Sql" + e.getMessage());
            throw new TechnicalException("Erreur Sql" + e.getMessage());
        }
    }

    @Transactional(rollbackFor = { TechnicalException.class })
    public void ajouterPrixDegressif(int idProduitRef, PrixDegressif prixDegressif)
            throws TechnicalException {
        try {

            Connection connection = ds.getConnection();
            StringBuilder requete = new StringBuilder();
            requete.append(" insert into prix_degressif_produit  ");
            requete.append(" (borne_inferieure, borne_superieure, prix_unitaire, id_produit_reference)  ");
            requete.append(" value  ");
            requete.append(" (?, ?, ?, ?) ");

            PreparedStatement preStatement = connection.prepareStatement(requete.toString());
            preStatement.setFloat(1, prixDegressif.getBorneInferieure());
            preStatement.setFloat(2, prixDegressif.getBorneSuperieure());
            preStatement.setFloat(3, prixDegressif.getPrixUnitaire());
            preStatement.setFloat(4, idProduitRef);

            preStatement.executeUpdate();

        }
        catch (SQLException e) {
            e.printStackTrace();
            logger.error("Erreur Sql" + e.getMessage());
            throw new TechnicalException("Erreur Sql" + e.getMessage());
        }

    }

    @Transactional(rollbackFor = { TechnicalException.class })
    public void supprimerPrixDegressif(int idProduitRef) throws TechnicalException {
        try {
            Connection connection = ds.getConnection();
            StringBuilder requete = new StringBuilder();
            requete.append(" delete from prix_degressif_produit where id_produit_reference = ? ");

            PreparedStatement preStatement = connection.prepareStatement(requete.toString());
            preStatement.setInt(1, idProduitRef);

            preStatement.executeUpdate();
            logger.debug("Suppression des prix degressifs du produit id=" + idProduitRef
                    + " effective");
        }
        catch (SQLException e) {
            e.printStackTrace();
            logger.error("Erreur Sql" + e.getMessage());
            throw new TechnicalException("Erreur Sql" + e.getMessage());
        }

    }

    @Transactional(rollbackFor = { TechnicalException.class })
    public int ajouterOptionProduit(int idProduitRef, OptionReference nouvelleOption)
            throws TechnicalException {
        try {
            int nouvelleClefOption = -1;
            Connection connection = ds.getConnection();
            StringBuilder requete = new StringBuilder();
            requete.append(" insert into produit_reference_option  ");
            requete.append(" (id_produit_reference, reference_option, nom, obligatoire, prix_unitaire)  ");
            requete.append(" value  ");
            requete.append(" (?, ?, ?, ?, ?) ");

            PreparedStatement preStatement = connection.prepareStatement(requete.toString(),
                    Statement.RETURN_GENERATED_KEYS);
            preStatement.setInt(1, idProduitRef);
            preStatement.setString(2, nouvelleOption.getReference());
            preStatement.setString(3, nouvelleOption.getNom());
            preStatement.setBoolean(4, nouvelleOption.isObligatoire());
            preStatement.setFloat(5, nouvelleOption.getCoutUnitaireFixe());

            preStatement.executeUpdate();
            ResultSet generatedKeys = preStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                nouvelleClefOption = generatedKeys.getInt(1);
            }
            logger.debug("Ajout d'un nouveau produit: " + nouvelleOption.getNom());
            return nouvelleClefOption;

        }
        catch (SQLException e) {
            e.printStackTrace();
            logger.error("Erreur Sql" + e.getMessage());
            throw new TechnicalException("Erreur Sql" + e.getMessage());
        }

    }

    @Transactional(rollbackFor = { TechnicalException.class })
    public void supprimerOptionProduit(int idProduitRef) throws TechnicalException {
        try {
            Connection connection = ds.getConnection();
            StringBuilder requete = new StringBuilder();
            requete.append(" delete from produit_reference_option where id_produit_reference = ? ");

            PreparedStatement preStatement = connection.prepareStatement(requete.toString());
            preStatement.setInt(1, idProduitRef);

            preStatement.executeUpdate();
            logger.debug("Suppression des options du produit id=" + idProduitRef + " effective");
        }
        catch (SQLException e) {
            e.printStackTrace();
            logger.error("Erreur Sql" + e.getMessage());
            throw new TechnicalException("Erreur Sql" + e.getMessage());
        }

    }

    public List<OptionReference> listerOptionProduitReference(int idProduitRef)
            throws TechnicalException {
        try {

            Connection connection = ds.getConnection();
            StringBuilder requete = new StringBuilder();
            requete.append(" select po.id_produit_option, po.reference_option, po.nom, po.obligatoire,   ");
            requete.append(" po.prix_unitaire, pdo.borne_inferieur, pdo.borne_superieur, pdo.prix_unitaire, pdo.id_tableau_prix_degressif_option   ");
            requete.append(" from produit_reference_option po   ");
            requete.append(" left join prix_degressif_option pdo on pdo.id_produit_option = po.id_produit_option  ");
            requete.append(" where po.id_produit_reference = ?   ");

            PreparedStatement preStatement = connection.prepareStatement(requete.toString());
            preStatement.setInt(1, idProduitRef);

            ResultSet result = preStatement.executeQuery();

            Map<Integer, OptionReference> mapOptionRef = new HashMap<Integer, OptionReference>();
            while (result.next()) {

                if (!mapOptionRef.containsKey(result.getInt("po.id_produit_option"))) {
                    OptionReference nouvelleOption = new OptionReference(
                            result.getString("po.nom"), result.getString("po.reference_option"),
                            result.getBoolean("po.obligatoire"));
                    Float prixUnitaire = result.getFloat("po.prix_unitaire");
                    if (prixUnitaire != null && prixUnitaire != 0F) {
                        nouvelleOption.setCoutUnitaireFixe(prixUnitaire);
                    }
                    else {
                        PrixDegressif prixDegressifOption = new PrixDegressif(
                                result.getInt("pdo.id_tableau_prix_degressif_option"),
                                result.getInt("pdo.borne_inferieur"),
                                result.getInt("pdo.borne_superieur"),
                                result.getFloat("pdo.prix_unitaire"));
                        List<PrixDegressif> listePrixDegressif = new ArrayList<PrixDegressif>();
                        listePrixDegressif.add(prixDegressifOption);
                        nouvelleOption.setListePrixDegressif(listePrixDegressif);
                    }
                    mapOptionRef.put(result.getInt("po.id_produit_option"), nouvelleOption);
                }
                else {
                    OptionReference optionExistante = mapOptionRef.get(result.getInt("po.id_produit_option"));
                    PrixDegressif prixDegressifOption = new PrixDegressif(
                            result.getInt("pdo.id_tableau_prix_degressif_option"),
                            result.getInt("pdo.borne_inferieur"),
                            result.getInt("pdo.borne_superieur"),
                            result.getFloat("pdo.prix_unitaire"));
                    optionExistante.getListePrixDegressif().add(prixDegressifOption);
                }
            }
            return new ArrayList<OptionReference>(mapOptionRef.values());
        }
        catch (SQLException e) {
            e.printStackTrace();
            logger.error("Erreur Sql" + e.getMessage());
            throw new TechnicalException("Erreur Sql" + e.getMessage());
        }
    }

    @Transactional(rollbackFor = { TechnicalException.class })
    public void ajouterPrixDegressifOption(int idProduitOption, PrixDegressif prixDegressif)
            throws TechnicalException {
        try {

            Connection connection = ds.getConnection();
            StringBuilder requete = new StringBuilder();
            requete.append(" insert into prix_degressif_option  ");
            requete.append(" (borne_inferieur, borne_superieur, prix_unitaire, id_produit_option)  ");
            requete.append(" value  ");
            requete.append(" (?, ?, ?, ?) ");

            PreparedStatement preStatement = connection.prepareStatement(requete.toString());
            preStatement.setFloat(1, prixDegressif.getBorneInferieure());
            preStatement.setFloat(2, prixDegressif.getBorneSuperieure());
            preStatement.setFloat(3, prixDegressif.getPrixUnitaire());
            preStatement.setFloat(4, idProduitOption);

            preStatement.executeUpdate();

        }
        catch (SQLException e) {
            e.printStackTrace();
            logger.error("Erreur Sql" + e.getMessage());
            throw new TechnicalException("Erreur Sql" + e.getMessage());
        }

    }

    @Transactional(rollbackFor = { TechnicalException.class })
    public void supprimerPrixDegressifOption(int idProduitRef) throws TechnicalException {
        try {
            Connection connection = ds.getConnection();
            StringBuilder requete = new StringBuilder();
            requete.append(" DELETE FROM prix_degressif_option WHERE id_produit_option IN ( ");
            requete.append("         SELECT id_produit_option ");
            requete.append("         FROM produit_reference_option ");
            requete.append("         WHERE id_produit_reference = ?) ");

            PreparedStatement preStatement = connection.prepareStatement(requete.toString());
            preStatement.setInt(1, idProduitRef);

            preStatement.executeUpdate();
            logger.debug("Suppression des prix dégressifs des options liées au produit d'id="
                    + idProduitRef + " effective");
        }
        catch (SQLException e) {
            e.printStackTrace();
            logger.error("Erreur Sql" + e.getMessage());
            throw new TechnicalException("Erreur Sql" + e.getMessage());
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

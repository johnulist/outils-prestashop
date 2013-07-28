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

import fr.upyourbizz.utils.exception.TechnicalException;
import fr.upyourbizz.web.dto.ClientDto;

/**
 * ClientDao
 */
public class ClientDao {

    // ===== Attributs statiques ==============================================

    private final Logger logger = LoggerFactory.getLogger(ClientDao.class);

    // ===== Méthodes statiques ===============================================

    // ===== Attributs ========================================================

    private DataSource ds;

    // ===== Constructeurs ====================================================

    // ===== Méthodes =========================================================

    /**
     * Ajout un client
     * 
     * @param nouveauClient Le client a ajouter
     * @throws TechnicalException Exception technique
     */
    public void ajouterClient(ClientDto nouveauClient) throws TechnicalException {
        try {
            Connection connection = ds.getConnection();
            StringBuilder requete = new StringBuilder();
            StringBuilder vars = new StringBuilder();
            StringBuilder values = new StringBuilder();

            vars.append(" nom_societe, ville, secteur_activite ");
            values.append("?,?,? ");

            if (nouveauClient.getSiret() != null && !nouveauClient.getSiret().isEmpty()) {
                vars.append(",siret ");
                values.append(",?");
            }
            if (nouveauClient.getFormeJuridique() != null
                    && !nouveauClient.getFormeJuridique().isEmpty()) {
                vars.append(",forme_juridique ");
                values.append(",?");
            }
            if (nouveauClient.getTvaIntercommunautaire() != null
                    && nouveauClient.getTvaIntercommunautaire() != 0F) {
                vars.append(",tva ");
                values.append(",?");
            }
            if (nouveauClient.getAdresse() != null && !nouveauClient.getAdresse().isEmpty()) {
                vars.append(",adresse ");
                values.append(",?");
            }
            if (nouveauClient.getCodePostal() != null && !nouveauClient.getCodePostal().isEmpty()) {
                vars.append(",code_postal ");
                values.append(",?");
            }
            if (nouveauClient.getTelephoneFixe() != null
                    && !nouveauClient.getTelephoneFixe().isEmpty()) {
                vars.append(",telephone_fixe ");
                values.append(",?");
            }
            if (nouveauClient.getDirigeantNom() != null
                    && !nouveauClient.getDirigeantNom().isEmpty()) {
                vars.append(",dirigeant_nom ");
                values.append(",?");
            }
            if (nouveauClient.getDirigeantPrenom() != null
                    && !nouveauClient.getDirigeantPrenom().isEmpty()) {
                vars.append(",dirigeant_prenom ");
                values.append(",?");
            }
            if (nouveauClient.getContactNom() != null && !nouveauClient.getContactNom().isEmpty()) {
                vars.append(",contact_nom ");
                values.append(",?");
            }
            if (nouveauClient.getContactPrenom() != null
                    && !nouveauClient.getContactPrenom().isEmpty()) {
                vars.append(",contact_prenom ");
                values.append(",?");
            }
            if (nouveauClient.getContactTelephoneFixe() != null
                    && !nouveauClient.getContactTelephoneFixe().isEmpty()) {
                vars.append(",contact_tel_fixe ");
                values.append(",?");
            }
            if (nouveauClient.getContactTelephonePortable() != null
                    && !nouveauClient.getContactTelephonePortable().isEmpty()) {
                vars.append(",contact_tel_port ");
                values.append(",?");
            }
            if (nouveauClient.getContactFonction() != null
                    && !nouveauClient.getContactFonction().isEmpty()) {
                vars.append(",contact_fonction ");
                values.append(",?");
            }
            if (nouveauClient.getContactEmail() != null
                    && !nouveauClient.getContactEmail().isEmpty()) {
                vars.append(",contact_email ");
                values.append(",?");
            }
            if (nouveauClient.getCommentaire() != null && !nouveauClient.getCommentaire().isEmpty()) {
                vars.append(",commentaire ");
                values.append(",?");
            }

            requete.append(" insert into client ( ");
            requete.append(vars.toString());
            requete.append(" ) value ( ");
            requete.append(values.toString());
            requete.append(") ");

            PreparedStatement preStatement = connection.prepareStatement(requete.toString());
            preStatement.setString(1, nouveauClient.getSocieteNom());
            preStatement.setString(2, nouveauClient.getVille());
            preStatement.setString(3, nouveauClient.getSecteurActiviteSelectionne());

            int prochainValeurCompteur = 4;
            if (nouveauClient.getSiret() != null && !nouveauClient.getSiret().isEmpty()) {
                preStatement.setString(prochainValeurCompteur, nouveauClient.getSiret());
                prochainValeurCompteur++;
            }
            if (nouveauClient.getFormeJuridique() != null
                    && !nouveauClient.getFormeJuridique().isEmpty()) {
                preStatement.setString(prochainValeurCompteur, nouveauClient.getFormeJuridique());
                prochainValeurCompteur++;
            }
            if (nouveauClient.getTvaIntercommunautaire() != null
                    && nouveauClient.getTvaIntercommunautaire() != 0F) {
                preStatement.setFloat(prochainValeurCompteur,
                        nouveauClient.getTvaIntercommunautaire());
                prochainValeurCompteur++;
            }
            if (nouveauClient.getAdresse() != null && !nouveauClient.getAdresse().isEmpty()) {
                preStatement.setString(prochainValeurCompteur, nouveauClient.getAdresse());
                prochainValeurCompteur++;
            }
            if (nouveauClient.getCodePostal() != null && !nouveauClient.getCodePostal().isEmpty()) {
                preStatement.setString(prochainValeurCompteur, nouveauClient.getCodePostal());
                prochainValeurCompteur++;
            }
            if (nouveauClient.getTelephoneFixe() != null
                    && !nouveauClient.getTelephoneFixe().isEmpty()) {
                preStatement.setString(prochainValeurCompteur, nouveauClient.getTelephoneFixe());
                prochainValeurCompteur++;
            }
            if (nouveauClient.getDirigeantNom() != null
                    && !nouveauClient.getDirigeantNom().isEmpty()) {
                preStatement.setString(prochainValeurCompteur, nouveauClient.getDirigeantNom());
                prochainValeurCompteur++;
            }
            if (nouveauClient.getDirigeantPrenom() != null
                    && !nouveauClient.getDirigeantPrenom().isEmpty()) {
                preStatement.setString(prochainValeurCompteur, nouveauClient.getDirigeantPrenom());
                prochainValeurCompteur++;
            }
            if (nouveauClient.getContactNom() != null && !nouveauClient.getContactNom().isEmpty()) {
                preStatement.setString(prochainValeurCompteur, nouveauClient.getContactNom());
                prochainValeurCompteur++;
            }
            if (nouveauClient.getContactPrenom() != null
                    && !nouveauClient.getContactPrenom().isEmpty()) {
                preStatement.setString(prochainValeurCompteur, nouveauClient.getContactPrenom());
                prochainValeurCompteur++;
            }
            if (nouveauClient.getContactTelephoneFixe() != null
                    && !nouveauClient.getContactTelephoneFixe().isEmpty()) {
                preStatement.setString(prochainValeurCompteur,
                        nouveauClient.getContactTelephoneFixe());
                prochainValeurCompteur++;
            }
            if (nouveauClient.getContactTelephonePortable() != null
                    && !nouveauClient.getContactTelephonePortable().isEmpty()) {
                preStatement.setString(prochainValeurCompteur,
                        nouveauClient.getContactTelephonePortable());
                prochainValeurCompteur++;
            }
            if (nouveauClient.getContactFonction() != null
                    && !nouveauClient.getContactFonction().isEmpty()) {
                preStatement.setString(prochainValeurCompteur, nouveauClient.getContactFonction());
                prochainValeurCompteur++;
            }
            if (nouveauClient.getContactEmail() != null
                    && !nouveauClient.getContactEmail().isEmpty()) {
                preStatement.setString(prochainValeurCompteur, nouveauClient.getContactEmail());
                prochainValeurCompteur++;
            }
            if (nouveauClient.getCommentaire() != null && !nouveauClient.getCommentaire().isEmpty()) {
                preStatement.setString(prochainValeurCompteur, nouveauClient.getCommentaire());
                prochainValeurCompteur++;
            }

            preStatement.executeUpdate();

        }
        catch (SQLException e) {
            e.printStackTrace();
            logger.error("Erreur Sql" + e.getMessage());
            throw new TechnicalException("Erreur Sql" + e.getMessage());
        }
    }

    /**
     * Modifie un client existant
     * 
     * @param nouveauClient
     * @throws TechnicalException Exception technique
     */
    public void modifierClient(ClientDto nouveauClient) throws TechnicalException {
        // clientDao.modifierClient(nouveauClient);
    }

    /**
     * Liste tous les clients de l'application
     * 
     * @return La liste des clients
     * @throws TechnicalException Exception technique
     */
    public List<ClientDto> listerClients() throws TechnicalException {
        try {

            Connection connection = ds.getConnection();
            StringBuilder requete = new StringBuilder();

            requete.append(" select id_client , nom_societe , siret , forme_juridique , tva , adresse , code_postal ,  ");
            requete.append(" ville , telephone_fixe , dirigeant_nom , dirigeant_prenom , secteur_activite , contact_nom ,  ");
            requete.append(" contact_prenom , contact_tel_fixe , contact_tel_port , contact_fonction , contact_email , commentaire, url_img ");
            requete.append(" FROM client ");

            PreparedStatement preStatement = connection.prepareStatement(requete.toString());

            ResultSet result = preStatement.executeQuery();

            List<ClientDto> listeClients = new ArrayList<ClientDto>();
            while (result.next()) {
                ClientDto client = new ClientDto(result.getInt("id_client"),
                        result.getString("nom_societe"), result.getString("siret"),
                        result.getString("forme_juridique"), result.getFloat("tva"),
                        result.getString("telephone_fixe"), result.getString("dirigeant_nom"),
                        result.getString("dirigeant_prenom"), result.getString("adresse"),
                        result.getString("ville"), result.getString("code_postal"),
                        result.getString("secteur_activite"), result.getString("contact_nom"),
                        result.getString("contact_prenom"), result.getString("contact_fonction"),
                        result.getString("contact_tel_fixe"), result.getString("contact_tel_port"),
                        result.getString("contact_email"), result.getString("commentaire"),
                        result.getString("url_img"));

                listeClients.add(client);
            }
            return listeClients;
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

package fr.upyourbizz.web.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.upyourbizz.utils.exception.TechnicalException;
import fr.upyourbizz.web.dto.UtilisateurDto;

/**
 * UtilisateurDao
 */
public class UtilisateurDao {

    // ===== Attributs statiques ==============================================

    private final Logger logger = LoggerFactory.getLogger(UtilisateurDao.class);

    // ===== Méthodes statiques ===============================================

    // ===== Attributs ========================================================

    private DataSource ds;

    // ===== Constructeurs ====================================================

    // ===== Méthodes =========================================================

    /**
     * Liste les utilisateurs de l'application
     * 
     * @return La liste de utilisateur
     * @throws TechnicalException Exception technique
     */
    public List<UtilisateurDto> listerUtilisateurs() throws TechnicalException {
        try {

            Connection connection = ds.getConnection();
            StringBuilder requete = new StringBuilder();
            requete.append(" select util.id_utilisateur, util.nom, util.prenom, util.login, util.password, util.email, util.date_creation, util.actif, un.nom, ur.nom  ");
            requete.append(" from utilisateur util ");
            requete.append(" inner join utilisateur_niveau un on util.id_utilisateur_niveau=un.id_utilisateur_niveau ");
            requete.append(" inner join utilisateur_role ur on util.id_utilisateur_role=ur.id_utilisateur_role ");

            PreparedStatement preStatement = connection.prepareStatement(requete.toString());
            ResultSet result = preStatement.executeQuery();

            List<UtilisateurDto> resultat = new ArrayList<UtilisateurDto>();
            while (result.next()) {
                UtilisateurDto utilisateur = new UtilisateurDto(
                        result.getInt("util.id_utilisateur"), result.getString("util.nom"),
                        result.getString("util.prenom"), result.getString("util.login"),
                        result.getString("util.password"), result.getString("util.email"),
                        result.getString("ur.nom"), result.getString("un.nom"),
                        result.getBoolean("util.actif"));
                utilisateur.setDateCreation(new DateTime(result.getDate("util.date_creation")));
                resultat.add(utilisateur);
            }
            return resultat;
        }
        catch (SQLException e) {
            e.printStackTrace();
            logger.error("Erreur Sql" + e.getMessage());
            throw new TechnicalException("Erreur Sql" + e.getMessage());
        }
    }

    /**
     * Ajout d'un nouvel utilisateur
     * 
     * @param nom Nom de l'utilisateur
     * @param prenom Prenom de l'utilisateur
     * @param login Login de l'utilisateur
     * @param password Passpord de l'utilisateur
     * @param email email de l'utilisateur
     * @param role Rôle de l'utilisateur
     * @param niveau Niveau de l'utilisateur
     * @throws TechnicalException Exception technique
     */
    public void ajouterUtilisateur(String nom, String prenom, String login, String password,
            String email, String role, String niveau) throws TechnicalException {
        try {
            String REQUETE_SELECT_ROLE = "(select id_utilisateur_role from utilisateur_role where nom = ?)";
            String REQUETE_SELECT_NIVEAU = "(select id_utilisateur_niveau from utilisateur_niveau where nom = ?)";
            Connection connection = ds.getConnection();
            StringBuilder requete = new StringBuilder();
            requete.append(" insert into utilisateur ");
            requete.append(" (nom, prenom, login, password, email, id_utilisateur_role, id_utilisateur_niveau, date_creation, actif) ");
            requete.append(" values (?, ?, ?,?,?, ");
            requete.append(REQUETE_SELECT_ROLE + ", ");
            requete.append(REQUETE_SELECT_NIVEAU + ", ");
            requete.append("NOW(), true)");

            PreparedStatement preStatement = connection.prepareStatement(requete.toString());
            preStatement.setString(1, nom);
            preStatement.setString(2, prenom);
            preStatement.setString(3, login);
            preStatement.setString(4, password);
            preStatement.setString(5, email);
            preStatement.setString(6, role);
            preStatement.setString(7, niveau);

            preStatement.executeUpdate();
            logger.debug("Ajout d'un nouvel utilisateur: " + nom);
        }
        catch (SQLException e) {
            e.printStackTrace();
            logger.error("Erreur Sql" + e.getMessage());
            throw new TechnicalException("Erreur Sql" + e.getMessage());
        }
    }

    /**
     * Modification d'un utilisateur
     * 
     * @param id
     * @param nom Nom de l'utilisateur
     * @param prenom Prenom de l'utilisateur
     * @param login Login de l'utilisateur
     * @param password Passpord de l'utilisateur
     * @param email email de l'utilisateur
     * @param role Rôle de l'utilisateur
     * @param niveau Niveau de l'utilisateur
     * @throws TechnicalException Exception technique
     */
    public void modifierUtilisateur(int id, String nom, String prenom, String login,
            String password, String email, String role, String niveau) throws TechnicalException {
        try {
            String REQUETE_SELECT_ROLE = "(select id_utilisateur_role from utilisateur_role where nom = ?)";
            String REQUETE_SELECT_NIVEAU = "(select id_utilisateur_niveau from utilisateur_niveau where nom = ?)";
            Connection connection = ds.getConnection();
            StringBuilder requete = new StringBuilder();

            requete.append(" update utilisateur set nom = ?, prenom = ?, login = ?, password = ?, email = ?, ");
            requete.append(" id_utilisateur_role = " + REQUETE_SELECT_ROLE + ", ");
            requete.append(" id_utilisateur_niveau = " + REQUETE_SELECT_NIVEAU);
            requete.append("where id_utilisateur = ?");

            PreparedStatement preStatement = connection.prepareStatement(requete.toString());
            preStatement.setString(1, nom);
            preStatement.setString(2, prenom);
            preStatement.setString(3, login);
            preStatement.setString(4, password);
            preStatement.setString(5, email);
            preStatement.setString(6, role);
            preStatement.setString(7, niveau);
            preStatement.setInt(8, id);

            preStatement.executeUpdate();
            logger.debug("Modification de l'utilisateur: " + nom + " " + prenom);
        }
        catch (SQLException e) {
            e.printStackTrace();
            logger.error("Erreur Sql" + e.getMessage());
            throw new TechnicalException("Erreur Sql" + e.getMessage());
        }
    }

    /**
     * Suppression d'un utilisateur
     * 
     * @param idUtilisateur id de l'utilisateur à supprimer
     * @throws TechnicalException
     */
    public void suppressionUtilisateur(int idUtilisateur) throws TechnicalException {
        try {
            Connection connection = ds.getConnection();
            StringBuilder requete = new StringBuilder();
            requete.append(" delete from utilisateur where id_utilisateur = ? ");

            PreparedStatement preStatement = connection.prepareStatement(requete.toString());
            preStatement.setInt(1, idUtilisateur);

            preStatement.executeUpdate();
            logger.debug("Suppression de l'utilisateur id=" + idUtilisateur + " effective");
        }
        catch (SQLException e) {
            e.printStackTrace();
            logger.error("Erreur Sql" + e.getMessage());
            throw new TechnicalException("Erreur Sql" + e.getMessage());
        }
    }

    /**
     * Liste des rôles que peuvent avoir les utilisateurs
     * 
     * @return La liste des rôles
     * @throws TechnicalException
     */
    public List<String> listerRoles() throws TechnicalException {
        try {
            Connection connection = ds.getConnection();
            StringBuilder requete = new StringBuilder();
            requete.append(" select nom from utilisateur_role ");

            PreparedStatement preStatement = connection.prepareStatement(requete.toString());

            ResultSet result = preStatement.executeQuery();
            List<String> listeRoles = new ArrayList<String>();
            while (result.next()) {
                listeRoles.add(result.getString("nom"));
            }
            logger.debug("Liste des rôles");
            return listeRoles;
        }
        catch (SQLException e) {
            e.printStackTrace();
            logger.error("Erreur Sql" + e.getMessage());
            throw new TechnicalException("Erreur Sql" + e.getMessage());
        }
    }

    /**
     * Liste des niveaux que peuvent avoir les utilisateurs
     * 
     * @return la liste des niveaux
     * @throws TechnicalException
     */
    public List<String> listerNiveaux() throws TechnicalException {
        try {
            Connection connection = ds.getConnection();
            StringBuilder requete = new StringBuilder();
            requete.append(" select nom from utilisateur_niveau ");

            PreparedStatement preStatement = connection.prepareStatement(requete.toString());

            ResultSet result = preStatement.executeQuery();
            List<String> listeNiveaux = new ArrayList<String>();
            while (result.next()) {
                listeNiveaux.add(result.getString("nom"));
            }
            logger.debug("Liste des Niveaux");
            return listeNiveaux;
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

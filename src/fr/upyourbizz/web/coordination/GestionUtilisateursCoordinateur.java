package fr.upyourbizz.web.coordination;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.upyourbizz.utils.exception.TechnicalException;
import fr.upyourbizz.web.dto.UtilisateurDto;
import fr.upyourbizz.web.service.GestionUtilisateurService;

public class GestionUtilisateursCoordinateur {

    // ===== Attributs statiques ==============================================

    @SuppressWarnings("unused")
    private final Logger logger = LoggerFactory.getLogger(GestionUtilisateursCoordinateur.class);

    // ===== Méthodes statiques ===============================================

    // ===== Attributs ========================================================

    private GestionUtilisateurService gestionUtilisateurService;

    // ===== Constructeurs ====================================================

    // ===== Méthodes =========================================================

    /**
     * Liste les utilisateurs de l'application
     * 
     * @return La liste de utilisateur
     * @throws TechnicalException Exception technique
     */
    public List<UtilisateurDto> listerUtilisateurs() throws TechnicalException {
        return gestionUtilisateurService.listerUtilisateurs();
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
        gestionUtilisateurService.ajouterUtilisateur(nom, prenom, login, password, email, role,
                niveau);
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
        gestionUtilisateurService.modifierUtilisateur(id, nom, prenom, login, password, email,
                role, niveau);
    }

    /**
     * Suppression d'un utilisateur
     * 
     * @param idUtilisateur id de l'utilisateur à supprimer
     * @throws TechnicalException
     */
    public void suppressionUtilisateur(int idUtilisateur) throws TechnicalException {
        gestionUtilisateurService.suppressionUtilisateur(idUtilisateur);
    }

    /**
     * Liste des rôles que peuvent avoir les utilisateurs
     * 
     * @return La liste des rôles
     * @throws TechnicalException
     */
    public List<String> listerRoles() throws TechnicalException {
        return gestionUtilisateurService.listerRoles();
    }

    /**
     * Liste des niveaux que peuvent avoir les utilisateurs
     * 
     * @return la liste des niveaux
     * @throws TechnicalException
     */
    public List<String> listerNiveaux() throws TechnicalException {
        return gestionUtilisateurService.listerNiveaux();
    }

    // ===== Accesseurs =======================================================

    /**
     * Affecte gestionUtilisateurService
     * 
     * @param gestionUtilisateurService gestionUtilisateurService à affecter
     */
    public void setGestionUtilisateurService(GestionUtilisateurService gestionUtilisateurService) {
        this.gestionUtilisateurService = gestionUtilisateurService;
    }

    // ===== Classes imbriquées ===============================================
}

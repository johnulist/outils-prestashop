/**
 * © 2013, Upyourbizz - All right reserved
 */
package fr.upyourbizz.web.presentation.controller;

import javax.faces.context.FacesContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.upyourbizz.utils.adaptateur.GestionUtilisateurAdaptateur;
import fr.upyourbizz.utils.exception.TechnicalException;
import fr.upyourbizz.web.coordination.GestionUtilisateursCoordinateur;
import fr.upyourbizz.web.presentation.model.GestionUtilisateursModel;
import fr.upyourbizz.web.presentation.model.GestionUtilisateursModel.Utilisateur;

/**
 * GestionUtilisateursController
 */
public class GestionUtilisateursController {

    // ===== Attributs statiques ==============================================

    @SuppressWarnings("unused")
    private final Logger logger = LoggerFactory.getLogger(GestionUtilisateursController.class);

    // ===== Méthodes statiques ===============================================

    // ===== Attributs ========================================================

    private GestionUtilisateursModel gestionUtilisateursModel;

    private GestionUtilisateursCoordinateur gestionUtilisateurCoordinateur;

    // ===== Constructeurs ====================================================

    // ===== Méthodes =========================================================

    public void init() {
        if (!FacesContext.getCurrentInstance().isPostback()) {
            // Utilisateur eric = gestionUtilisateursModel.new
            // Utilisateur("elegrand", "Eric",
            // "Legrand", "elegrand@upyourbizz.fr", "Responsable", "Master", new
            // Date(), true);
            // gestionUtilisateursModel.getListeUtilisateurs().clear();
            // gestionUtilisateursModel.getListeUtilisateurs().add(eric);
            // gestionUtilisateursModel.getListeRoles().clear();
            // gestionUtilisateursModel.getListeRoles().add(new
            // SelectItem("Administrateur"));
            // gestionUtilisateursModel.getListeRoles().add(new
            // SelectItem("Vendeur"));
            // gestionUtilisateursModel.getListeRoles().add(new
            // SelectItem("Marketeur"));
            // gestionUtilisateursModel.getListeNiveaux().clear();
            // gestionUtilisateursModel.getListeNiveaux().add(new
            // SelectItem("Niveau 1"));
            // gestionUtilisateursModel.getListeNiveaux().add(new
            // SelectItem("Niveau 2"));
            // gestionUtilisateursModel.getListeNiveaux().add(new
            // SelectItem("Niveau 3"));
            try {
                GestionUtilisateurAdaptateur.adapterDonneesDepuisService(
                        gestionUtilisateurCoordinateur.listerUtilisateurs(),
                        gestionUtilisateursModel);
            }
            catch (TechnicalException e) {
                e.printStackTrace();
                // TODO Rediriger vers écran erreur technique
            }
        }
    }

    public void modifierUtilisateur(Utilisateur utilisateur) {

    }

    public void afficherPartieAjoutNouvelUtilisateur() {
        gestionUtilisateursModel.setAfficherPartieNouvelUtilisateur(true);
    }

    public void ajoutNouvelUtilisateur() {

    }

    // ===== Accesseurs =======================================================

    /**
     * Affecte gestionUtilisateursModel
     * 
     * @param gestionUtilisateursModel gestionUtilisateursModel à affecter
     */
    public void setGestionUtilisateursModel(GestionUtilisateursModel gestionUtilisateursModel) {
        this.gestionUtilisateursModel = gestionUtilisateursModel;
    }

    /**
     * Affecte gestionUtilisateurCoordinateur
     * 
     * @param gestionUtilisateurCoordinateur gestionUtilisateurCoordinateur à
     *            affecter
     */
    public void setGestionUtilisateurCoordinateur(
            GestionUtilisateursCoordinateur gestionUtilisateurCoordinateur) {
        this.gestionUtilisateurCoordinateur = gestionUtilisateurCoordinateur;
    }

    // ===== Classes imbriquées ===============================================
}

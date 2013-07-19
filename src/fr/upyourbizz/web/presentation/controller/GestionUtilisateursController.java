/**
 * © 2013, Upyourbizz - All right reserved
 */
package fr.upyourbizz.web.presentation.controller;

import java.util.List;

import javax.faces.application.FacesMessage;
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
            try {
                gestionUtilisateursModel.reinitialiser();
                GestionUtilisateurAdaptateur.adapterDonneesUtilisateursPourVue(
                        gestionUtilisateurCoordinateur.listerUtilisateurs(),
                        gestionUtilisateursModel);
                List<String> roles = gestionUtilisateurCoordinateur.listerRoles();
                GestionUtilisateurAdaptateur.adapterRolesPourVue(roles, gestionUtilisateursModel);
                List<String> niveaux = gestionUtilisateurCoordinateur.listerNiveaux();
                GestionUtilisateurAdaptateur.adapterNiveauxPourVue(niveaux,
                        gestionUtilisateursModel);
            }
            catch (TechnicalException e) {
                e.printStackTrace();
                // TODO Rediriger vers écran erreur technique
            }
        }
    }

    public void modifierUtilisateur(Utilisateur utilisateur) {
        gestionUtilisateursModel.setUtilisateurAvantModification(utilisateur);
        gestionUtilisateursModel.setIdUtilisateur(utilisateur.getIdUtilisateur());
        gestionUtilisateursModel.setUtilisateurNom(utilisateur.getNom());
        gestionUtilisateursModel.setUtilisateurPrenom(utilisateur.getPrenom());
        gestionUtilisateursModel.setUtilisateurEmail(utilisateur.getEmail());
        gestionUtilisateursModel.setUtilisateurLogin(utilisateur.getLogin());
        gestionUtilisateursModel.setRoleSelectionne(utilisateur.getRole());
        gestionUtilisateursModel.setNiveauSelectionne(utilisateur.getNiveau());
        gestionUtilisateursModel.setUtilisateurMdp(utilisateur.getPassword());
        gestionUtilisateursModel.setUtilisateurMdpConfirmation(utilisateur.getPassword());

        gestionUtilisateursModel.setAfficherPartieNouvelUtilisateur(true);

    }

    public void supprimerUtilisateur(Utilisateur utilisateur) {
        try {
            gestionUtilisateurCoordinateur.suppressionUtilisateur(utilisateur.getIdUtilisateur());
            gestionUtilisateursModel.getListeUtilisateurs().clear();
            GestionUtilisateurAdaptateur.adapterDonneesUtilisateursPourVue(
                    gestionUtilisateurCoordinateur.listerUtilisateurs(), gestionUtilisateursModel);
        }
        catch (TechnicalException e) {
            e.printStackTrace();
            // TODO Rediriger vers page erreur
        }
    }

    public void afficherPartieAjoutNouvelUtilisateur() {
        gestionUtilisateursModel.setIdUtilisateur(-1);
        gestionUtilisateursModel.setAfficherPartieNouvelUtilisateur(true);
    }

    public void ajoutNouvelUtilisateur() {
        if (controlerChampsAvantAjoutUtilisateur()) {

            try {
                if (gestionUtilisateursModel.getIdUtilisateur() == -1) {
                    // Ajout d'un utilisateur
                    gestionUtilisateurCoordinateur.ajouterUtilisateur(
                            gestionUtilisateursModel.getUtilisateurNom(),
                            gestionUtilisateursModel.getUtilisateurPrenom(),
                            gestionUtilisateursModel.getUtilisateurLogin(),
                            gestionUtilisateursModel.getUtilisateurMdp(),
                            gestionUtilisateursModel.getUtilisateurEmail(),
                            gestionUtilisateursModel.getRoleSelectionne(),
                            gestionUtilisateursModel.getNiveauSelectionne());
                }
                else {
                    // Modification d'un utilisateur
                    gestionUtilisateurCoordinateur.modifierUtilisateur(
                            gestionUtilisateursModel.getIdUtilisateur(),
                            gestionUtilisateursModel.getUtilisateurNom(),
                            gestionUtilisateursModel.getUtilisateurPrenom(),
                            gestionUtilisateursModel.getUtilisateurLogin(),
                            gestionUtilisateursModel.getUtilisateurMdp(),
                            gestionUtilisateursModel.getUtilisateurEmail(),
                            gestionUtilisateursModel.getRoleSelectionne(),
                            gestionUtilisateursModel.getNiveauSelectionne());
                }
                gestionUtilisateursModel.getListeUtilisateurs().clear();
                GestionUtilisateurAdaptateur.adapterDonneesUtilisateursPourVue(
                        gestionUtilisateurCoordinateur.listerUtilisateurs(),
                        gestionUtilisateursModel);
                gestionUtilisateursModel.reinitialiserChampsUtilisateur();
                gestionUtilisateursModel.setAfficherPartieNouvelUtilisateur(false);
            }
            catch (TechnicalException e) {
                e.printStackTrace();
                // TODO Rediriger vers page erreur
            }

        }
    }

    public void annulerAjoutNouvelUtilisateur() {
        gestionUtilisateursModel.reinitialiserChampsUtilisateur();
        gestionUtilisateursModel.setAfficherPartieNouvelUtilisateur(false);
    }

    // ===== Accesseurs =======================================================

    private boolean controlerChampsAvantAjoutUtilisateur() {
        boolean controleMdpOk = true;
        if (!gestionUtilisateursModel.getUtilisateurMdp().isEmpty()
                && !gestionUtilisateursModel.getUtilisateurMdpConfirmation().isEmpty()
                && !gestionUtilisateursModel.getUtilisateurMdp().equals(
                        gestionUtilisateursModel.getUtilisateurMdpConfirmation())) {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Attention",
                            "Les mots de passe ne correspondent pas!"));
            controleMdpOk = false;

        }
        return (controleMdpOk && (gestionUtilisateursModel.getUtilisateurNom() != null)
                && (gestionUtilisateursModel.getUtilisateurPrenom() != null)
                && (gestionUtilisateursModel.getUtilisateurLogin() != null)
                && (gestionUtilisateursModel.getUtilisateurMdp() != null) && (gestionUtilisateursModel.getUtilisateurMdpConfirmation() != null));

    }

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

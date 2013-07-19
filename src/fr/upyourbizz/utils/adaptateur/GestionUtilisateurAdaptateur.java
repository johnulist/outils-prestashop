/**
 * © 2013, Upyourbizz - All right reserved
 */
package fr.upyourbizz.utils.adaptateur;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.upyourbizz.web.dto.UtilisateurDto;
import fr.upyourbizz.web.presentation.model.GestionUtilisateursModel;
import fr.upyourbizz.web.presentation.model.GestionUtilisateursModel.Utilisateur;

/**
 * GestionUtilisateurAdaptateur
 */
public class GestionUtilisateurAdaptateur {

    // ===== Attributs statiques ==============================================

    @SuppressWarnings("unused")
    private final Logger logger = LoggerFactory.getLogger(GestionUtilisateurAdaptateur.class);

    // ===== Méthodes statiques ===============================================

    /**
     * Adapte les données en provenance du service pour la vue
     * 
     * @param listeUtilisateur
     * @param gestionUtilisateurModel
     */
    public static void adapterDonneesUtilisateursPourVue(List<UtilisateurDto> listeUtilisateur,
            GestionUtilisateursModel gestionUtilisateurModel) {
        for (UtilisateurDto utilisateurDto : listeUtilisateur) {
            Utilisateur utilisateur = gestionUtilisateurModel.new Utilisateur(
                    utilisateurDto.getIdUtilisateur(), utilisateurDto.getLogin(),
                    utilisateurDto.getPassword(), utilisateurDto.getPrenom(),
                    utilisateurDto.getNom(), utilisateurDto.getEmail(), utilisateurDto.getRole(),
                    utilisateurDto.getNiveau(), utilisateurDto.getDateCreation().toDate(),
                    utilisateurDto.isActif());
            gestionUtilisateurModel.getListeUtilisateurs().add(utilisateur);
        }
    }

    /**
     * Adapte la liste de rôle à la vue
     * 
     * @param roles
     * @param gestionUtilisateurModel
     */
    public static void adapterRolesPourVue(List<String> roles,
            GestionUtilisateursModel gestionUtilisateurModel) {
        List<SelectItem> listeRoles = new ArrayList<SelectItem>();
        for (String role : roles) {
            listeRoles.add(new SelectItem(role));
        }
        gestionUtilisateurModel.setListeRoles(listeRoles);
    }

    /**
     * Adapte la liste des niveaux à la vue
     * 
     * @param niveaux
     * @param gestionUtilisateurModel
     */
    public static void adapterNiveauxPourVue(List<String> niveaux,
            GestionUtilisateursModel gestionUtilisateurModel) {
        List<SelectItem> listeNiveaux = new ArrayList<SelectItem>();
        for (String role : niveaux) {
            listeNiveaux.add(new SelectItem(role));
        }
        gestionUtilisateurModel.setListeNiveaux(listeNiveaux);
    }

    // ===== Attributs ========================================================

    // ===== Constructeurs ====================================================

    // ===== Méthodes =========================================================

    // TODO Corps de classe auto-généré

    // ===== Accesseurs =======================================================

    // ===== Classes imbriquées ===============================================
}

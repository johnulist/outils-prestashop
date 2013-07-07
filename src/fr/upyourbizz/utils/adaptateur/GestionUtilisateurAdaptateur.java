/**
 * © 2013, Upyourbizz - All right reserved
 */
package fr.upyourbizz.utils.adaptateur;

import java.util.List;

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
    public static void adapterDonneesDepuisService(List<UtilisateurDto> listeUtilisateur,
            GestionUtilisateursModel gestionUtilisateurModel) {
        for (UtilisateurDto utilisateurDto : listeUtilisateur) {
            Utilisateur utilisateur = gestionUtilisateurModel.new Utilisateur(
                    utilisateurDto.getIdUtilisateur(), utilisateurDto.getLogin(),
                    utilisateurDto.getPrenom(), utilisateurDto.getNom(), utilisateurDto.getEmail(),
                    utilisateurDto.getRole(), utilisateurDto.getNiveau(),
                    utilisateurDto.getDateCreation().toDate(), utilisateurDto.isActif());
            gestionUtilisateurModel.getListeUtilisateurs().add(utilisateur);
        }
    }
    // ===== Attributs ========================================================

    // ===== Constructeurs ====================================================

    // ===== Méthodes =========================================================

    // TODO Corps de classe auto-généré

    // ===== Accesseurs =======================================================

    // ===== Classes imbriquées ===============================================
}

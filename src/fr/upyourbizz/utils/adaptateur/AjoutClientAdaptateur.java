package fr.upyourbizz.utils.adaptateur;

import fr.upyourbizz.web.dto.ClientDto;
import fr.upyourbizz.web.presentation.model.AjoutClientModel;

public class AjoutClientAdaptateur {

    // ===== Attributs statiques ==============================================

    // ===== Méthodes statiques ===============================================

    // ===== Attributs ========================================================

    // ===== Constructeurs ====================================================

    // ===== Méthodes =========================================================

    public static ClientDto preparationEnregistrementModel(AjoutClientModel ajoutClientModel) {
        ClientDto nouveauClient = new ClientDto(0, ajoutClientModel.getSocieteNom(),
                ajoutClientModel.getSiret(), ajoutClientModel.getFormeJuridique(),
                ajoutClientModel.getTvaIntercommunautaire(), ajoutClientModel.getTelephoneFixe(),
                ajoutClientModel.getDirigeantNom(), ajoutClientModel.getDirigeantPrenom(),
                ajoutClientModel.getAdresse(), ajoutClientModel.getVille(),
                ajoutClientModel.getCodePostal(), ajoutClientModel.getSecteurActiviteSelectionne(),
                ajoutClientModel.getContactNom(), ajoutClientModel.getContactPrenom(),
                ajoutClientModel.getContactFonction(), ajoutClientModel.getContactTelephoneFixe(),
                ajoutClientModel.getContactTelephonePortable(), ajoutClientModel.getContactEmail(),
                ajoutClientModel.getCommentaire(), ajoutClientModel.getUrlImg());
        return nouveauClient;
    }

    public static void adapterDonneePourVue(ClientDto utilisateur, AjoutClientModel ajoutClientModel) {
        ajoutClientModel.setSocieteNom(utilisateur.getSocieteNom());
        ajoutClientModel.setSiret(utilisateur.getSiret());
        ajoutClientModel.setFormeJuridique(utilisateur.getFormeJuridique());
        ajoutClientModel.setTvaIntercommunautaire(utilisateur.getTvaIntercommunautaire());
        ajoutClientModel.setTelephoneFixe(utilisateur.getTelephoneFixe());
        ajoutClientModel.setDirigeantNom(utilisateur.getDirigeantNom());
        ajoutClientModel.setDirigeantPrenom(utilisateur.getDirigeantPrenom());
        ajoutClientModel.setAdresse(utilisateur.getAdresse());
        ajoutClientModel.setVille(utilisateur.getVille());
        ajoutClientModel.setCodePostal(utilisateur.getCodePostal());
        ajoutClientModel.setSecteurActiviteSelectionne(utilisateur.getSecteurActiviteSelectionne());
        ajoutClientModel.setContactNom(utilisateur.getContactNom());
        ajoutClientModel.setContactPrenom(utilisateur.getContactPrenom());
        ajoutClientModel.setContactFonction(utilisateur.getContactFonction());
        ajoutClientModel.setContactTelephoneFixe(utilisateur.getContactTelephoneFixe());
        ajoutClientModel.setContactTelephonePortable(utilisateur.getContactTelephonePortable());
        ajoutClientModel.setCommentaire(utilisateur.getCommentaire());
    }

    // ===== Accesseurs =======================================================

    // ===== Classes imbriquées ===============================================
}

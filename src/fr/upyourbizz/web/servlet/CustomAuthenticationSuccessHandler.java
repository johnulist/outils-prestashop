/*
 * © 2013, GEMB - Tous droits réservés
 */
package fr.upyourbizz.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import fr.upyourbizz.web.enums.UserRoles;
import fr.upyourbizz.web.presentation.model.ContexteModel;

/**
 * CustomAuthenticationSuccessHandler. Redéfinition des actions à effectuer une
 * fois que l'utilisateur est connecté. C'est ici qu'est configuré le menu de
 * l'utilisateur
 */
@Component
public class CustomAuthenticationSuccessHandler extends
        SavedRequestAwareAuthenticationSuccessHandler {

    // ===== Attributs statiques ==============================================

    // ===== Méthodes statiques ===============================================

    // ===== Attributs ========================================================

    private final Logger logger = LoggerFactory.getLogger(CustomAuthenticationSuccessHandler.class);

    @Autowired
    private ContexteModel contexteUtilisateur;

    // ===== Constructeurs ====================================================

    // ===== Méthodes =========================================================

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {
        // Il est possible d'effectuer des actions lorsque l'utilisateur viens
        // de s'authentifier.
        // On connait le rôle de l'utilisateur, on peut donc dès à présent
        // initialiser son menu
        logger.debug("Nom de l'utilisateur souhaitant se connecter:"
                + contexteUtilisateur.getName());

        // Il est possible de redéfinir la page sur laquelle l'utilisateur
        // arrive suite à son utilisateur réussie.
        if (contexteUtilisateur.getUtilisateurRoles().contains(UserRoles.ROLE_ADMIN.name())) {
            // setDefaultTargetUrl("/adm/accueil.faces");
        }
        else {
            // setDefaultTargetUrl("/vdr/accueil-vdr.faces");
        }
        super.onAuthenticationSuccess(request, response, authentication);
    }

    // ===== Accesseurs =======================================================
}

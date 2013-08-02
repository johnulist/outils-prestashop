/*
 * © 2013, GEMB - Tous droits réservés
 */
package fr.upyourbizz.web.servlet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import fr.upyourbizz.web.enums.UserRoles;
import fr.upyourbizz.web.presentation.model.ContexteModel;

/**
 * CustomAuthenticationProvider
 */
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    // ===== Attributs statiques ==============================================

    // ===== Méthodes statiques ===============================================

    // ===== Attributs ========================================================

    @SuppressWarnings("unused")
    private final Logger logger = LoggerFactory.getLogger(CustomAuthenticationProvider.class);

    @Autowired
    private ContexteModel contexte;

    private static Map<String, String> SIMPLE_USERS = new HashMap<String, String>(2) {

        {
            put("admin", "admin");
            put("vendeur", "vendeur");
        }
    };

    // ===== Constructeurs ====================================================

    // ===== Méthodes =========================================================

    /*
     * (non-Javadoc)
     * @see org.springframework.security.authentication.AuthenticationProvider#
     * authenticate(org.springframework.security.core.Authentication)
     */
    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();
        contexte.getUtilisateurRoles().clear();
        if (SIMPLE_USERS.containsKey(name) && SIMPLE_USERS.get(name).equals(password)) {
            List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
            grantedAuths.add(new SimpleGrantedAuthority(UserRoles.ROLE_USER.name()));
            contexte.setName(name);
            contexte.getUtilisateurRoles().add(UserRoles.ROLE_USER.name());
            if (name.equals("admin")) {
                grantedAuths.add(new SimpleGrantedAuthority(UserRoles.ROLE_ADMIN.name()));
                contexte.getUtilisateurRoles().add(UserRoles.ROLE_ADMIN.name());
            }
            else {
                grantedAuths.add(new SimpleGrantedAuthority(UserRoles.ROLE_VENDEUR.name()));
                contexte.getUtilisateurRoles().add(UserRoles.ROLE_VENDEUR.name());
            }

            Authentication auth = new UsernamePasswordAuthenticationToken(name, password,
                    grantedAuths);
            return auth;
        }
        else {
            throw new BadCredentialsException("Nom d'utilisateur ou mot de passe incorrect pour: "
                    + name);
        }
    }

    /*
     * (non-Javadoc)
     * @see
     * org.springframework.security.authentication.AuthenticationProvider#supports
     * (java.lang.Class)
     */
    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

    // ===== Accesseurs =======================================================

}

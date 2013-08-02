package fr.upyourbizz.web.enums;

/**
 * UserRoles. Enumération de tous les rôles que peuvent avoir les utilisateurs
 * de l'application.
 */
public enum UserRoles {

    // ===== Enumérations ====================================================

    /**
     * Rôle attribué aux administrateur
     */
    ROLE_ADMIN("ADMIN"),

    /**
     * Rôle attribué aux vendeurs
     */
    ROLE_VENDEUR("VENDEUR"),

    /**
     * Rôle attribué aux personnes du marketing
     */
    ROLE_MARKETING("MARKETING"),

    /**
     * Rôle par défaut attribué à tous les utilisateurs authentifiés
     */
    ROLE_USER("USER");

    // ===== Attributs ========================================================

    private final String stringVal;

    // ===== Constructeurs ====================================================

    UserRoles(final String stringVal) {
        this.stringVal = stringVal;
    }

    // ===== Méthodes =========================================================

    /**
     * @return le nom de la colonne sous forme textuelle
     */
    @Override
    public String toString() {
        return stringVal;
    }

    /**
     * Fonction permettant de récupérer l'enum à partir de sa valeur textuelle.
     * En cas d'erreur, l'exception IllegalArgumentException est levée
     * 
     * @param nomElement La valeur textuelle de la colonne que l'on souhaite
     *            obtenir sous forme d'enum
     * @return L'enum correspondant au déclencheur entré en paramètre
     */
    public static UserRoles fromString(final String nomElement) {
        if (nomElement != null) {
            for (final UserRoles b : UserRoles.values()) {
                if (nomElement.equalsIgnoreCase(b.toString())) {
                    return b;
                }
            }
        }
        throw new IllegalArgumentException("Pas de colonne " + nomElement + " trouvée");
    }
}

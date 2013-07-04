package fr.upyourbizz.utils.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * TechnicalException
 */
public class TechnicalException extends Exception {

    // ===== Attributs statiques ==============================================

    @SuppressWarnings("unused")
    private final Logger logger = LoggerFactory.getLogger(TechnicalException.class);

    // ===== Méthodes statiques ===============================================

    // ===== Attributs ========================================================

    // ===== Constructeurs ====================================================

    /**
     * @param message
     */
    public TechnicalException(String message) {
        super("Erreur technique: " + message);
    }

    // ===== Méthodes =========================================================

    // ===== Accesseurs =======================================================
}

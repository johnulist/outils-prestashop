package fr.upyourbizz.utils.adaptateur;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.upyourbizz.web.dto.OptionReference;
import fr.upyourbizz.web.dto.ProduitReferenceDto;
import fr.upyourbizz.web.presentation.model.ProduitPac;
import fr.upyourbizz.web.presentation.model.ProduitPacOption;

public class CreerPacAdaptateur {

    // ===== Attributs statiques ==============================================

    @SuppressWarnings("unused")
    private final Logger logger = LoggerFactory.getLogger(CreerPacAdaptateur.class);

    // ===== Méthodes statiques ===============================================

    // ===== Attributs ========================================================

    // ===== Constructeurs ====================================================

    // ===== Méthodes =========================================================

    public static ProduitPac adapterProduitsReferencePourAffichage(ProduitReferenceDto produitRef) {
        ProduitPac resultat = new ProduitPac(produitRef.getNom() + " 0", 0, "", 0, 0F);
        List<ProduitPacOption> listeOptionsPac = new ArrayList<ProduitPacOption>();
        List<ProduitPacOption> listeOptions = new ArrayList<ProduitPacOption>();
        if (produitRef.getListeOption() != null && !produitRef.getListeOption().isEmpty()) {
            List<OptionReference> listeOptionRef = produitRef.getListeOption();

            for (OptionReference option : listeOptionRef) {
                listeOptionsPac.add(new ProduitPacOption(option.getNom(), 0, 0F,
                        option.isObligatoire(), option.isObligatoire() ? true : false, option));
            }
        }
        resultat.setListeOptions(listeOptionsPac);
        return resultat;
    }
    // ===== Accesseurs =======================================================

    // ===== Classes imbriquées ===============================================
}

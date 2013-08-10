package fr.upyourbizz.web.presentation.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.upyourbizz.utils.adaptateur.CreerPacAdaptateur;
import fr.upyourbizz.utils.exception.TechnicalException;
import fr.upyourbizz.web.coordination.CreerPacCoordinateur;
import fr.upyourbizz.web.dto.ProduitReferenceDto;
import fr.upyourbizz.web.presentation.model.CreerPacModele;
import fr.upyourbizz.web.presentation.model.ProduitPac;

@Component
public class CreerPacController extends AbstractController {

    // ===== Attributs statiques ==============================================

    @SuppressWarnings("unused")
    private final Logger logger = LoggerFactory.getLogger(CreerPacController.class);

    // ===== Méthodes statiques ===============================================

    // ===== Attributs ========================================================
    @Autowired
    private CreerPacModele creerPacModele;

    @Autowired
    private CreerPacCoordinateur creerPacCoordinateur;

    // ===== Constructeurs ====================================================

    // ===== Méthodes =========================================================

    public void init() {
        try {
            // int clientId = Integer.parseInt(creerPacModele.getClientId());
            // int produitId = Integer.parseInt(creerPacModele.getProduitId());

            // 1 - Récupérer en base de données les infos complétes des produits
            // On les récupère du contexte
            List<Integer> listeIdProduitsReferences = new ArrayList<Integer>();
            listeIdProduitsReferences.add(1);
            try {
                List<ProduitReferenceDto> listeProduitRef = creerPacCoordinateur.recupererListeProduitsComplete(listeIdProduitsReferences);
                for (ProduitReferenceDto produitRef : listeProduitRef) {
                    if (!creerPacModele.getListeProduitsPac().containsKey(produitRef.getIdProduit())) {
                        ProduitPac nouveauProduit = CreerPacAdaptateur.adapterProduitsReferencePourAffichage(produitRef);
                        List<ProduitPac> nouvelleListeProduit = new ArrayList<ProduitPac>();
                        nouvelleListeProduit.add(nouveauProduit);
                        creerPacModele.getListeProduitsPac().put(produitRef.getIdProduit(),
                                nouvelleListeProduit);
                    }
                }
            }
            catch (TechnicalException e) {
                e.printStackTrace();
                redirectionVersPageErreurTechnique(e.getMessage(), "");
            }
            // 2 - On regarde si la liste des

        }
        catch (NumberFormatException ex) {

        }

    }

    public void selectionProduitReference() {
        // creerPacModele.set
    }

    /**
     * Ajoute un nouveau produit au Pac
     * 
     * @param idProduitRef L'id du produit référence associé que l'on souhaite
     *            rajouter
     */
    private void ajouterNouveauProduitAuPac(int idProduitRef) {
        // if(creerPacModele.get)
    }

    // ===== Accesseurs =======================================================

    // ===== Classes imbriquées ===============================================
}

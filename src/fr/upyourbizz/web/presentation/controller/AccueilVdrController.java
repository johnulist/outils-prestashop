package fr.upyourbizz.web.presentation.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.faces.context.FacesContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.upyourbizz.web.dto.AnnonceDto;
import fr.upyourbizz.web.dto.DerniereVenteDto;
import fr.upyourbizz.web.dto.HistoClientDto;
import fr.upyourbizz.web.presentation.model.AccueilVdrModele;

@Component
public class AccueilVdrController {

    // ===== Attributs statiques ==============================================

    @SuppressWarnings("unused")
    private final Logger logger = LoggerFactory.getLogger(AccueilVdrController.class);

    // ===== Méthodes statiques ===============================================

    // ===== Attributs ========================================================

    @Autowired
    private AccueilVdrModele accueilVdrModele;

    // ===== Constructeurs ====================================================

    // ===== Méthodes =========================================================

    public void init() {
        if (!FacesContext.getCurrentInstance().isPostback()) {
            AnnonceDto annonce1 = new AnnonceDto("Les ventes sont en hausse, continuez comme ça!!",
                    new Date(), "info", "Eric Legrand");
            AnnonceDto annonce2 = new AnnonceDto("Nouvelle version d'upyoursoft disponible!!",
                    new Date(), "info", "Mikael Thibault");
            AnnonceDto annonce3 = new AnnonceDto(
                    "A 25 ventes cette semaine, c'est apéro pour tout le monde", new Date(),
                    "info", "Eric Legrand");
            AnnonceDto annonce4 = new AnnonceDto("Promotion sur le emailing", new Date(), "info",
                    "Eric Legrand");
            accueilVdrModele.getListeAnnonces().clear();
            accueilVdrModele.getListeAnnonces().add(annonce1);
            accueilVdrModele.getListeAnnonces().add(annonce2);
            accueilVdrModele.getListeAnnonces().add(annonce3);
            accueilVdrModele.getListeAnnonces().add(annonce4);

            HistoClientDto histoClient1 = new HistoClientDto(1, "BMW", "Le Mans");
            accueilVdrModele.getListeHistoClient().clear();
            accueilVdrModele.getListeHistoClient().add(histoClient1);

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.FRENCH);
            Date date = new Date();
            try {
                date = simpleDateFormat.parse("16-04-2013");
            }
            catch (ParseException e) {
                e.printStackTrace();
            }

            accueilVdrModele.getListeDerniereVentes().clear();
            DerniereVenteDto derniereVente = new DerniereVenteDto("BMW", "Emailing", date, 320F);
            accueilVdrModele.getListeDerniereVentes().add(derniereVente);
        }
    }
    // ===== Accesseurs =======================================================

    // ===== Classes imbriquées ===============================================
}

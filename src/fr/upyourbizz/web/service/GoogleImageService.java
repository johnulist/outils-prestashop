package fr.upyourbizz.web.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GoogleImageService {

    // ===== Attributs statiques ==============================================

    @SuppressWarnings("unused")
    private final Logger logger = LoggerFactory.getLogger(GoogleImageService.class);

    private final String GOOGLE_SEARCH_URL = "http://www.google.fr/search?q=%s&safe=off&tbm=isch&biw=1440&bih=755&resnum=10";

    private final String USER_AGENT = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:20.0) Gecko/20100101 Firefox/20.0";

    // ===== Méthodes statiques ===============================================

    // ===== Attributs ========================================================

    // ===== Constructeurs ====================================================

    // ===== Méthodes =========================================================

    public List<String> searchProductImages(String productName) throws IOException {
        List<String> result = new ArrayList<String>();
        productName = productName.replace(" ", "+");
        String searchUrl = String.format(GOOGLE_SEARCH_URL, productName);
        Document googleImgResult = Jsoup.connect(searchUrl).userAgent(USER_AGENT).get();
        if (googleImgResult != null) {
            result = seekImgProduct(googleImgResult);
        }
        return result;
    }

    private List<String> seekImgProduct(Document googleImgResult) {
        List<String> urls = new ArrayList<String>();
        Elements rgDi = googleImgResult.select("div.rg_di");
        if (rgDi != null) {
            Iterator<Element> it = rgDi.iterator();
            int nbElements = 0;
            while (it.hasNext() && nbElements < 10) {
                Element rgL = it.next().select("a.rg_l").first();
                String navigationItemLinkUrl = rgL.attributes().get("href");
                Pattern p = Pattern.compile("&imgurl=(.*)&w");
                Matcher m = p.matcher(navigationItemLinkUrl);
                while (m.find()) {
                    urls.add(m.group(1));
                }
                nbElements++;
            }

        }

        return urls;
    }
    // ===== Accesseurs =======================================================

    // ===== Classes imbriquées ===============================================
}

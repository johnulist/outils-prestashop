package fr.upyourbizz.web.service;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileManagementService {

    // ===== Attributs statiques ==============================================

    private final Logger logger = LoggerFactory.getLogger(FileManagementService.class);

    // ===== Méthodes statiques ===============================================

    // ===== Attributs ========================================================

    // ===== Constructeurs ====================================================

    // ===== Méthodes =========================================================

    /**
     * Save the file from internet to the disk.
     * 
     * @param url The file url
     * @param fileName The name given to the new image
     * @throws IOException
     * @throws MalformedURLException
     */
    public void saveFileOnDiskFromUrl(String url, String fileName) throws MalformedURLException,
            IOException {
        String destinationPatch = "/Users/mykelkel/Pictures/relaisduson/" + fileName;
        saveFileToDisk(url, destinationPatch);

    }

    /**
     * Save the file from internet to the disk.
     * 
     * @param urlFile The file url
     * @param destinationPath The destination path
     * @return The new file
     * @throws MalformedURLException
     * @throws IOException
     */
    private File saveFileToDisk(String urlFile, String destinationPath)
            throws MalformedURLException, IOException {
        URL url = new URL(urlFile);
        File destination = new File(destinationPath);

        FileUtils.copyURLToFile(url, destination);
        return destination;
    }

    // ===== Accesseurs =======================================================

    // ===== Classes imbriquées ===============================================
}

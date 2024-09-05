package efisp.efispecommerce.models;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

/**
 * Class to upload images to the server
 */
public class ImageUploader {
    private static final String UPLOAD_DIR =  "images";

    /**
     * Upload an image to the server, saving it in the specified directory.
     * @param req the HttpServletRequest
     * @param filePart the Part containing the image
     * @param directory the directory where the image will be saved
     * @return the path to the uploaded image
     * @throws IOException if an I/O error occurs
     * @throws URISyntaxException if an error occurs while creating the path
     */
    public static String upload(HttpServletRequest req, Part filePart, String directory) throws IOException, URISyntaxException {
        UUID randomImageId = UUID.randomUUID();
        String originalFileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();

        String fileNameWithoutExtension = removeImageExtension(originalFileName);
        String extension = getImageExtension(originalFileName);

        String fileNameWithUUID = fileNameWithoutExtension + "-" + randomImageId + "." + extension;

        String uploadFilePath = Util.IMAGES_PATH.value() + File.separator + UPLOAD_DIR + File.separator + directory;
        String serverFilePath = req.getServletContext().getRealPath("/") + UPLOAD_DIR + File.separator + directory;

        File uploadDir = new File(uploadFilePath);
        File serverUploadDir = new File(serverFilePath);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }
        if (!serverUploadDir.exists()) {
            serverUploadDir.mkdirs();
        }

        Path filePath = Paths.get(uploadFilePath, fileNameWithUUID);

        Files.copy(filePart.getInputStream(), filePath);
        // copia para o /out também para mostrar imagem sem necessidade de redeploy
        Files.copy(filePart.getInputStream()
                , Paths.get(serverFilePath, fileNameWithUUID));

        return "images/" + directory + "/" + fileNameWithUUID;
    }

    private static String removeImageExtension(String fileName) {
        return fileName.substring(0, fileName.lastIndexOf("."));
    }

    private static String getImageExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }
}
package com.BlogSphere.Spring_boot_project.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
public class FileStorageService {

    @Value("${file.upload-dir}")
    private String baseUploadDir;
    public String saveFile(MultipartFile file) throws IOException {
        String contentType = file.getContentType();
        String folder;

        if (contentType == null) {
            throw new IOException("Invalid file type");
        }

        if (contentType.startsWith("image/")) {
            folder = "image";
        } else if (contentType.startsWith("video/")) {
            folder = "video";
        } else if (contentType.startsWith("audio/")) {
            folder = "audio";
        } else {
            throw new IOException("Unsupported file type: " + contentType);
        }

        String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
        Path uploadPath = Paths.get(System.getProperty("user.dir"), baseUploadDir, folder);



        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        Path filePath = uploadPath.resolve(fileName);
        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

        return  "http://localhost:8188/files/" + folder + "/" + fileName;
    }
}


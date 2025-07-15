package com.BlogSphere.Spring_boot_project.controller;


import com.BlogSphere.Spring_boot_project.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class FileController {

    @Autowired
    private FileStorageService storageService;

    private final String baseDir = System.getProperty("user.dir") + "/uploads/";


    @PostMapping("/api/upload")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            String fileUrl = storageService.saveFile(file);
            return ResponseEntity.ok(fileUrl);
        } catch (Exception e) {
             return ResponseEntity.badRequest().body("Upload failed: " + e.getMessage());
        }
    }

    @GetMapping("/files/{type}/{filename:.+}")
    public ResponseEntity<Resource> serveFile(@PathVariable String type, @PathVariable String filename) throws IOException {
        Path filePath = Paths.get(baseDir + type + "/" + filename);
        if (!Files.exists(filePath)) {
            return ResponseEntity.notFound().build();
        }

        Resource fileResource = new UrlResource(filePath.toUri());

        String contentType = Files.probeContentType(filePath);
        if (contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .body(fileResource);
    }
}




package com.picture.service.config;

import java.io.*;
import java.nio.file.*;

import com.picture.service.service.util.StaticContextAccessor;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadConfig {

    public static void saveFile( String fileName, MultipartFile multipartFile) throws IOException {

        PropertyConfig properties = StaticContextAccessor.getBean(PropertyConfig.class);

        Path uploadPath = Paths.get(properties.getBaseDirectory());

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        try (InputStream inputStream = multipartFile.getInputStream()) {

            Path filePath = uploadPath.resolve(fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);

        } catch (IOException exception) {
            throw new IOException("un able to save this image: " + fileName);
        }
    }
}

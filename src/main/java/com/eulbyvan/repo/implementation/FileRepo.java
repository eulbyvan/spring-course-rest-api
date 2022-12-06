package com.eulbyvan.repo.implementation;

import com.eulbyvan.repo.IFileRepo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 06/12/2022
 */

@Repository
public class FileRepo implements IFileRepo {
    private final Path root;

    public FileRepo(@Value("${FILE_PATH}") String rootPath) {
        this.root = Paths.get(rootPath);
    }

    @Override
    public void store(MultipartFile file) {
        try {
            Files.copy(file.getInputStream(), root.resolve(file.getOriginalFilename()));
        } catch (Exception e) {
            throw new RuntimeException("Couldn't store the file. Error: " + e.getMessage());
        }
    }

    @Override
    public Resource load(String filename) {
        try {
            Path file = root.resolve(filename);
            Resource resource = new UrlResource(file.toUri());

            if (resource.exists()) {
                return resource;
            } else {
                throw new RuntimeException("Could'nt read the file");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error " + e.getMessage());
        }
    }


}

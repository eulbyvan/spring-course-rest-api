package com.eulbyvan.repo.implementation;

import com.eulbyvan.repo.IFileRepo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
        } catch (IOException e) {
            throw new RuntimeException("Couldn't store the file. Error: " + e.getMessage());
        }
    }
}

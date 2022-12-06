package com.eulbyvan.repo;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 06/12/2022
 */
public interface IFileRepo {
    void store(MultipartFile file);

    Resource load(String filename);
}

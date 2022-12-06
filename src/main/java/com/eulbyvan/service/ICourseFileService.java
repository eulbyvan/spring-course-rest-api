package com.eulbyvan.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 06/12/2022
 */

public interface ICourseFileService {
    void uploadMaterial(MultipartFile multipartFile);
}

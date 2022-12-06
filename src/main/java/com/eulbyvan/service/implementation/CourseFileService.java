package com.eulbyvan.service.implementation;

import com.eulbyvan.repo.IFileRepo;
import com.eulbyvan.service.ICourseFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 06/12/2022
 */

@Service
public class CourseFileService implements ICourseFileService {
    private IFileRepo fileRepo;

    public CourseFileService(@Autowired IFileRepo fileRepo) {
        this.fileRepo = fileRepo;
    }

    @Override
    public void uploadMaterial(MultipartFile multipartFile) {
        fileRepo.store(multipartFile);
    }

    @Override
    public Resource downloadMaterial(String filename) {
        return fileRepo.load(filename);
    }
}

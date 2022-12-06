package com.eulbyvan.api;

import com.eulbyvan.model.dto.request.FormDataWithFile;
import com.eulbyvan.model.dto.response.CommonRes;
import com.eulbyvan.model.dto.response.SuccessRes;
import com.eulbyvan.service.ICourseFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 06/12/2022
 */

@RestController
@RequestMapping("/course-file")
public class CourseFileController {
    private ICourseFileService courseFileService;

    public CourseFileController(ICourseFileService courseFileService) {
        this.courseFileService = courseFileService;
    }

    @PostMapping
    public ResponseEntity<CommonRes> upload(FormDataWithFile req) {
        MultipartFile file = req.getFile();

        courseFileService.uploadMaterial(file);

        SuccessRes<MultipartFile> res = new SuccessRes<>("00", "OK", "mantap", List.of(req.getFile()));

        return ResponseEntity.status(HttpStatus.CREATED).body(res);
    }
}

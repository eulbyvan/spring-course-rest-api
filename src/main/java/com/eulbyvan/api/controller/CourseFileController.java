package com.eulbyvan.api.controller;

import com.eulbyvan.model.dto.request.FormDataWithFile;
import com.eulbyvan.model.dto.response.CommonRes;
import com.eulbyvan.model.dto.response.SuccessRes;
import com.eulbyvan.service.ICourseFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    public ResponseEntity upload(FormDataWithFile req) {
        MultipartFile file = req.getFile();

        courseFileService.uploadMaterial(file);

        SuccessRes<String> res = new SuccessRes<>("00", "OK", "mantap", List.of(req.getFile().getName().toString()));

        return ResponseEntity.status(HttpStatus.CREATED).body(res);
    }

    @GetMapping
    public ResponseEntity download(@RequestParam String filename) {
        Resource file = courseFileService.downloadMaterial(filename);

        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }
}

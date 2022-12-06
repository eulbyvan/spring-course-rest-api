package com.eulbyvan.model.dto.request;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 06/12/2022
 */

@Data
public class CourseFileReq {
    @NotNull(message = "filenya gaboleh kosong bang")
    private MultipartFile file;
}

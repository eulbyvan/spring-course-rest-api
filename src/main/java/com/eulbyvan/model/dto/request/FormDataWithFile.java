package com.eulbyvan.model.dto.request;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 06/12/2022
 */

@Data
public class FormDataWithFile {
    private MultipartFile file;
}

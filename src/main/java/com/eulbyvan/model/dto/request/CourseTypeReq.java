package com.eulbyvan.model.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 03/12/22
 */

@Data
public class CourseTypeReq {
	@NotBlank
	private String name;
}

package com.eulbyvan.model.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 03/12/22
 */

@Data
public class CourseReq {
	@NotBlank(message = "Title cannot be empty")
	private String title;
	@NotBlank(message = "Description cannot be empty")
	private String description;
	@NotBlank(message = "Link cannot be empty")
	private String link;

	@NotNull(message = "Course Type cannot be empty")
	private CourseTypeReq courseType;

	@NotNull(message = "Course Info cannot be empty")
	private CourseInfoReq courseInfo;
}

package com.eulbyvan.model.dto.request;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 03/12/22
 */

@Data
public class CourseInfoReq {
	@NotNull(message = "durasinya gaboleh kosong")
	@Min(value = 10, message = "durasinya kurang lama mas, minimal 10 menit")
	private Integer duration;

	@NotNull(message = "levelnya gaboleh kosong")
	@Min(value = 1, message = "levelnya minimal 1")
	private Integer level;
}

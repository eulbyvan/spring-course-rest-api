package com.eulbyvan.model.dto.response;

import lombok.Data;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 04/12/22
 */

@Data
public abstract class CommonResponse {
	private Integer code;
	private String msg;
	private String status;
}

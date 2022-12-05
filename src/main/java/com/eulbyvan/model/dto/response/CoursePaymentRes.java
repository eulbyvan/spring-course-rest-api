package com.eulbyvan.model.dto.response;

import lombok.Data;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 05/12/22
 */

@Data
public class CoursePaymentRes {
	private Boolean status;
	private String trxId;
}

package com.eulbyvan.model.dto.request;

import lombok.Data;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 05/12/22
 */

@Data
public class CoursePaymentReq {
	private String customerId;
	private String trxId;
	private String trxType;
}

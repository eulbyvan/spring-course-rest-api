package com.eulbyvan.model.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 04/12/22
 */

@Data
@NoArgsConstructor
//@AllArgsConstructor
public class ErrorResponse<T> extends CommonResponse {
//	private T reason;

	public ErrorResponse(Integer code, String status, String msg) {
		super.setCode(code);
		super.setStatus(status);
		super.setMsg(msg);
	}

//	public ErrorResponse(Integer code, String status, String msg, T reason) {
//		super.setCode(code);
//		super.setStatus(status);
//		super.setMsg(msg);
//		this.reason = reason;
//	}
}

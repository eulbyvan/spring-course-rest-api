package com.eulbyvan.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 04/12/22
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SuccessRes<T> extends CommonRes {
	private List<T> data;

	public SuccessRes(String code, String status, String msg, List<T> data) {
		super.setCode(code);
		super.setStatus(status);
		super.setMsg(msg);
		this.data = data;
	}
}

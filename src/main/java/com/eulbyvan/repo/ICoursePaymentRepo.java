package com.eulbyvan.repo;

import com.eulbyvan.model.dto.request.CoursePaymentReq;
import com.eulbyvan.model.dto.response.CoursePaymentRes;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 05/12/22
 */

public interface ICoursePaymentRepo {
	CoursePaymentRes callPaymentAPI(CoursePaymentReq req);
}

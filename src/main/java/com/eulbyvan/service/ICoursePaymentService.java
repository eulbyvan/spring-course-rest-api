package com.eulbyvan.service;

import com.eulbyvan.model.dto.request.CoursePaymentReq;
import com.eulbyvan.model.dto.response.CoursePaymentRes;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 06/12/2022
 */
public interface ICoursePaymentService {
    CoursePaymentRes pay(CoursePaymentReq req) throws Exception;
}

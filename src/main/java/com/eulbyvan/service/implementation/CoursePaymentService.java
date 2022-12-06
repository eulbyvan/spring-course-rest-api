package com.eulbyvan.service.implementation;

import com.eulbyvan.model.dto.request.CoursePaymentReq;
import com.eulbyvan.model.dto.response.CoursePaymentRes;
import com.eulbyvan.repo.ICoursePaymentRepo;
import com.eulbyvan.service.ICoursePaymentService;
import org.springframework.stereotype.Service;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 06/12/2022
 */

@Service
public class CoursePaymentService implements ICoursePaymentService {
    private final ICoursePaymentRepo coursePaymentRepo;

    public CoursePaymentService(ICoursePaymentRepo coursePaymentRepo) {
        this.coursePaymentRepo = coursePaymentRepo;
    }

    @Override
    public CoursePaymentRes pay(CoursePaymentReq req) throws Exception {
        return coursePaymentRepo.callPaymentAPI(req);
    }
}

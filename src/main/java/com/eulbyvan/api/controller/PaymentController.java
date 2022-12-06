package com.eulbyvan.api.controller;

import com.eulbyvan.model.dto.request.CoursePaymentReq;
import com.eulbyvan.model.dto.response.CommonRes;
import com.eulbyvan.model.dto.response.CoursePaymentRes;
import com.eulbyvan.model.dto.response.ErrorRes;
import com.eulbyvan.model.dto.response.SuccessRes;
import com.eulbyvan.service.ICoursePaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 06/12/2022
 */

@RestController
@RequestMapping("/wallet-payment")
public class PaymentController {
    private final ICoursePaymentService coursePaymentService;

    public PaymentController(ICoursePaymentService coursePaymentService) {
        this.coursePaymentService = coursePaymentService;
    }

    @PostMapping
    public ResponseEntity<CommonRes> pay(@RequestBody CoursePaymentReq coursePaymentReq) throws Exception {
        CoursePaymentRes paymentRes = coursePaymentService.pay(coursePaymentReq);

        if (paymentRes.getStatus()) {
            List<String> data = Optional.of(paymentRes.getTrxId()).stream().collect(Collectors.toList());

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new SuccessRes<>("00", "OK", "mantap", data));
        } else {
            return ResponseEntity
                    .status(HttpStatus.UNPROCESSABLE_ENTITY)
                    .body(new ErrorRes<>(
                            "X01",
                            "Payment Failed",
                            paymentRes.getTrxId()
                    ));
        }
    }
}

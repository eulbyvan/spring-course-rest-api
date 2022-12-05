package com.eulbyvan.repo;

import com.eulbyvan.model.dto.request.CoursePaymentReq;
import com.eulbyvan.model.dto.response.CoursePaymentRes;
import com.eulbyvan.model.dto.response.SuccessRes;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 05/12/22
 */

public class CoursePaymentRepo implements ICoursePaymentRepo {

	@Value("${PAYMENT_SVC}")
	String paymentServiceURI;
	private RestTemplate restTemplate;

	public CoursePaymentRepo(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Override
	public CoursePaymentRes callPaymentAPI(CoursePaymentReq req) {
		ResponseEntity<SuccessRes> res = restTemplate.postForEntity(paymentServiceURI, req, SuccessRes.class);
		SuccessRes<String> paymentRes = res.getBody();
		CoursePaymentRes coursePaymentRes = new CoursePaymentRes();

		if (!paymentRes.getStatus().equals("OK")) {
			coursePaymentRes.setStatus(false);
			coursePaymentRes.setTrxId("");

			return coursePaymentRes;
		}

		coursePaymentRes.setStatus(true);
		coursePaymentRes.setTrxId(paymentRes.getData().toString());

		return coursePaymentRes;
	}
}

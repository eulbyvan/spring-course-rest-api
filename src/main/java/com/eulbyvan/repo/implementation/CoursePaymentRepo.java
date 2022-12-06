package com.eulbyvan.repo.implementation;

import com.eulbyvan.model.dto.request.CoursePaymentReq;
import com.eulbyvan.model.dto.response.CoursePaymentRes;
import com.eulbyvan.model.dto.response.ErrorRes;
import com.eulbyvan.model.dto.response.SuccessRes;
import com.eulbyvan.model.exception.RestTemplateException;
import com.eulbyvan.repo.ICoursePaymentRepo;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 05/12/22
 */

@Repository
public class CoursePaymentRepo implements ICoursePaymentRepo {

	private final RestTemplate restTemplate;
	private final ObjectMapper objectMapper;
	@Value("${service.payment.url}")
	private String url;

	public CoursePaymentRepo(RestTemplate restTemplate, ObjectMapper objectMapper) {
		this.restTemplate = restTemplate;
		this.objectMapper = objectMapper;
	}

	@Override
	public CoursePaymentRes callPaymentAPI(CoursePaymentReq coursePaymentRequest) throws Exception {
		try {
			ResponseEntity<SuccessRes> response = restTemplate.postForEntity(url, coursePaymentRequest, SuccessRes.class);

			SuccessRes<String> responseBody = response.getBody();
			CoursePaymentRes coursePaymentResponse = new CoursePaymentRes();

			if (!responseBody.getCode().equals("OK")) {
				coursePaymentResponse.setStatus(true);
				coursePaymentResponse.setTrxId(responseBody.getData().toString());
			} else {
				coursePaymentResponse.setStatus(false);
				coursePaymentResponse.setTrxId("");
			}

			return coursePaymentResponse;
		} catch (HttpClientErrorException e) {
			if (e.getStatusCode() == HttpStatus.BAD_REQUEST) {
				ErrorRes<String> errorResponse = objectMapper.readValue(
						Objects.requireNonNull(e.getMessage()).substring(7, e.getMessage().length() - 1),
						new TypeReference<>() {}
				);
				throw new RestTemplateException(url, HttpStatus.BAD_REQUEST, errorResponse.getMsg());
			}

			throw e;
		}
	}
}

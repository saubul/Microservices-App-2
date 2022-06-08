package ru.saubul.fraud.controller;

import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import ru.saubul.fraud.controller.response.FraudCheckResponse;
import ru.saubul.fraud.dto.FraudDTO;
import ru.saubul.fraud.service.FraudService;

@RestController
@RequestMapping("/api/v1/fraud-check")
@RequiredArgsConstructor
public class FraudController {

	private final FraudService fraudService;
	
	@GetMapping("/{customerId}")
	public HttpEntity<FraudCheckResponse> isFraudster(@PathVariable("customerId") Long customerId) {
		return new ResponseEntity<>(new FraudCheckResponse(fraudService.isFraudulentCustomer(customerId)), HttpStatus.OK);
	}
	
}

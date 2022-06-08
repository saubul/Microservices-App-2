package ru.saubul.customer.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;
import ru.saubul.customer.controller.FraudCheckResponse;
import ru.saubul.customer.dto.CustomerDTO;
import ru.saubul.customer.entity.CustomerEntity;
import ru.saubul.customer.exception.CustomerNotFoundException;
import ru.saubul.customer.repository.CustomerRepository;
import ru.saubul.customer.service.CustomerService;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService{

	private final CustomerRepository customerRepository;
	private final RestTemplate restTemplate;
	
	@Override
	public CustomerEntity findById(Long id) {
		CustomerEntity customer = customerRepository.findById(id).get();
		if(customer == null) {
			throw new CustomerNotFoundException(String.format("Customer %s not found!", id));
		}
		return customer;
	}

	@Override
	public CustomerEntity save(CustomerDTO customerDTO) {
		CustomerEntity customerEntity = CustomerEntity.builder()
													  .name(customerDTO.getName())
													  .email(customerDTO.getEmail())
													  .build();
		customerRepository.saveAndFlush(customerEntity);
		FraudCheckResponse fraudCheckResponse = restTemplate.getForEntity("http://FRAUD/api/v1/fraud-check/{customerId}", 
																		  						FraudCheckResponse.class, 
																		  						customerEntity.getId()).getBody();
		if(fraudCheckResponse.isFraudster()) {
			throw new IllegalStateException("Fraudster");
		}
		
		return customerEntity;
	}

	@Override
	public List<CustomerEntity> findAll() {
		return customerRepository.findAll();
	}
	
}

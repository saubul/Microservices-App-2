package ru.saubul.customer.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ru.saubul.customer.dto.CustomerDTO;
import ru.saubul.customer.entity.CustomerEntity;
import ru.saubul.customer.exception.CustomerNotFoundException;
import ru.saubul.customer.repository.CustomerRepository;
import ru.saubul.customer.service.CustomerService;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService{

	private final CustomerRepository customerRepository;

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
		return customerRepository.save(customerEntity);
	}

	@Override
	public List<CustomerEntity> findAll() {
		return customerRepository.findAll();
	}
	
}

package ru.saubul.customer.service;

import java.util.List;

import ru.saubul.customer.dto.CustomerDTO;
import ru.saubul.customer.entity.CustomerEntity;

public interface CustomerService {

	CustomerEntity findById(Long id);
	CustomerEntity save(CustomerDTO customerDTO);
	List<CustomerEntity> findAll();
}

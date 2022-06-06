package ru.saubul.customer.service;

import ru.saubul.customer.dto.CustomerDTO;
import ru.saubul.customer.entity.CustomerEntity;

public interface CustomerService {

	CustomerEntity findById(Long id);
	CustomerEntity save(CustomerDTO customerDTO);
}

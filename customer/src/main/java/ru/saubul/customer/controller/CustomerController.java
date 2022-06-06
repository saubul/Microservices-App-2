package ru.saubul.customer.controller;

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
import lombok.extern.slf4j.Slf4j;
import ru.saubul.customer.dto.CustomerDTO;
import ru.saubul.customer.entity.CustomerEntity;
import ru.saubul.customer.model.CustomerModel;
import ru.saubul.customer.model.CustomerModelAssembler;
import ru.saubul.customer.service.CustomerService;

@Slf4j
@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {
	
	private final CustomerService customerService;
	private final CustomerModelAssembler customerModelAssembler;
	
	@PostMapping
	public HttpEntity<CustomerModel> saveCustomer(@RequestBody CustomerDTO customerDTO) {
		log.info("Saving new customer {}.", customerDTO);
		return new ResponseEntity<>(customerModelAssembler.toModel(customerService.save(customerDTO)), HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public HttpEntity<CustomerModel> getUser(@PathVariable("id") Long id) {
		return new ResponseEntity<>(customerModelAssembler.toModel(customerService.findById(id)) , HttpStatus.OK);
	}
	
}

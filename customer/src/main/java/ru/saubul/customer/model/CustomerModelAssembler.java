package ru.saubul.customer.model;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import ru.saubul.customer.controller.CustomerController;
import ru.saubul.customer.entity.CustomerEntity;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class CustomerModelAssembler extends RepresentationModelAssemblerSupport<CustomerEntity, CustomerModel>{

	public CustomerModelAssembler() {
		super(CustomerController.class, CustomerModel.class);
	}
	
	@Override
	public CustomerModel toModel(CustomerEntity customerEntity) {
		
		CustomerModel customerModel = CustomerModel.builder()
													   .id(customerEntity.getId())
												       .name(customerEntity.getName())
												   .build();
		
		Link link = linkTo(methodOn(CustomerController.class).getUser(customerEntity.getId())).withSelfRel();
		customerModel.add(link);
		
		return customerModel;
	}

}

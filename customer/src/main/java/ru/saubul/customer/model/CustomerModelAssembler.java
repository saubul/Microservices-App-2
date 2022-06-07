package ru.saubul.customer.model;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import ru.saubul.customer.controller.CustomerController;
import ru.saubul.customer.entity.CustomerEntity;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.CollectionModel;

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
												       .email(customerEntity.getEmail())
												   .build();
		
		Link link = linkTo(methodOn(CustomerController.class).getCustomer(customerEntity.getId())).withSelfRel();
		customerModel.add(link);
		customerModel.add(linkTo(methodOn(CustomerController.class).getCustomers()).withRel("customers"));
		
		return customerModel;
	}
	
	@Override
	public CollectionModel<CustomerModel> toCollectionModel(Iterable<? extends CustomerEntity> customerEntities) {
		CollectionModel<CustomerModel> customerModels = super.toCollectionModel(customerEntities);
		customerModels.add(linkTo(methodOn(CustomerController.class).getCustomers()).withSelfRel());
		return customerModels;
	}

}

package ru.saubul.kafkalog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerEntity {
	
	private Long id;
	private String name;
	private String email;
	
}

package ru.saubul.customer.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "customers", uniqueConstraints = {@UniqueConstraint(name = "email_unique_constraint", columnNames = "email")})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerEntity {
	
	@Id
	@SequenceGenerator(name = "customer_id_sequence", sequenceName = "customer_id_sequence")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_id_sequence")
	private Long id;
	
	private String name;
	private String email;
	
}

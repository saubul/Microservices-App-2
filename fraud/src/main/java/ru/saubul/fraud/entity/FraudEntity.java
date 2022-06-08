package ru.saubul.fraud.entity;

import java.time.LocalDateTime;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "frauds")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FraudEntity {
	
	@Id
	@SequenceGenerator(name = "fraud_id_sequence", sequenceName = "fraud_id_sequence")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fraud_id_sequence")
	private Long id;
	
	private Long customerId;
	private boolean isFraudster;
	
	@CreationTimestamp
	@Column(name = "date_creation")
	private LocalDateTime createdAt;
	
	
}

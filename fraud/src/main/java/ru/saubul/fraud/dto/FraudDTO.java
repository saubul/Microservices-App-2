package ru.saubul.fraud.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FraudDTO {
	
	private Long id;
	private Long customerId;
	private boolean isFraudster;
	private LocalDateTime createdAt;
	
}

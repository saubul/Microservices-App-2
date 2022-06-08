package ru.saubul.customer.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FraudCheckResponse {
	
	private boolean isFraudster;
	
}

package ru.saubul.fraud.service;

import java.util.List;

import ru.saubul.fraud.dto.FraudDTO;
import ru.saubul.fraud.entity.FraudEntity;

public interface FraudService {
	
	FraudEntity findById(Long id);
	List<FraudEntity> findAll();
	FraudEntity save(FraudDTO fraudDTO);
	boolean isFraudulentCustomer(Long customerId);
}

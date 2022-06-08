package ru.saubul.fraud.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ru.saubul.fraud.dto.FraudDTO;
import ru.saubul.fraud.entity.FraudEntity;
import ru.saubul.fraud.exception.FraudNotFoundException;
import ru.saubul.fraud.repository.FraudRepository;
import ru.saubul.fraud.service.FraudService;

@Service
@RequiredArgsConstructor
public class FraudServiceImpl implements FraudService{

	private final FraudRepository fraudRepository;
	
	@Override
	public FraudEntity findById(Long id) {
		FraudEntity fraudEntity = fraudRepository.findById(id).get();
		
		if(fraudEntity == null) {
			throw new FraudNotFoundException(String.format("Fraud %s not found.", id));
		}
		return fraudEntity;
	}

	@Override
	public List<FraudEntity> findAll() {
		return fraudRepository.findAll();
	}

	@Override
	public FraudEntity save(FraudDTO fraudDTO) {
		FraudEntity fraudEntity = FraudEntity.builder()
											     .id(fraudDTO.getId())
											     .customerId(fraudDTO.getCustomerId())
											     .isFraudster(fraudDTO.isFraudster())
											     .createdAt(fraudDTO.getCreatedAt())
											 .build();
		return fraudRepository.save(fraudEntity);
	}

	@Override
	public boolean isFraudulentCustomer(Long customerId) {
		fraudRepository.save(FraudEntity.builder()
											.customerId(customerId)
											.isFraudster(false)
											.createdAt(LocalDateTime.now())
										.build());
		return false;
	}

}

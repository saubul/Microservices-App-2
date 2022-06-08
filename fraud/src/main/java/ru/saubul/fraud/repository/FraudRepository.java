package ru.saubul.fraud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ru.saubul.fraud.entity.FraudEntity;

@Repository
public interface FraudRepository extends JpaRepository<FraudEntity, Long>{

}

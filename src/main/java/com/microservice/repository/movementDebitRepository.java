package com.microservice.repository;

import com.microservice.model.MovementDebit;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface movementDebitRepository extends ReactiveCrudRepository<MovementDebit, String>{
}

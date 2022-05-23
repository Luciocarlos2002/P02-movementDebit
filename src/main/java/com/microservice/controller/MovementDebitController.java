package com.microservice.controller;

import com.microservice.model.MovementDebit;
import com.microservice.service.MovementDebitService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movementDebit")
public class MovementDebitController {

    private final MovementDebitService movementDebitService;

    private static final String MOVEMENTDEBIT = "movementdebit";

    @GetMapping(value = "/allMovementDebits")
    public Flux<MovementDebit> getAllMovementDebits(){
        return movementDebitService.getAllMovementDebit();
    }

    @GetMapping(value = "/{id}")
    public Mono<MovementDebit> getByIdMovementDebit(@PathVariable String id){
        return movementDebitService.getByIdMovementDebit(id);
    }

    @PostMapping(value = "/create")
    @CircuitBreaker(name = MOVEMENTDEBIT, fallbackMethod = "movementdebit")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<MovementDebit> createMovementDebit(@RequestBody MovementDebit movementDebit){
        return movementDebitService.createMovementDebit(movementDebit);
    }

    @PutMapping(value = "/update/{id}")
    @CircuitBreaker(name = MOVEMENTDEBIT, fallbackMethod = "movementdebit")
    public Mono<MovementDebit> updateMovementDebit(@PathVariable String id, @RequestBody MovementDebit movementDebit){
        return movementDebitService.updateMovementDebit(id, movementDebit);
    }

    @DeleteMapping(value = "/delete/{id}")
    public Mono<Void> deleteMovementDebit(@PathVariable String id){
        return movementDebitService.deleteMovementDebit(id);
    }

}

package com.microservices.currencyexchangeservices.repository;

import com.microservices.currencyexchangeservices.model.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {



}

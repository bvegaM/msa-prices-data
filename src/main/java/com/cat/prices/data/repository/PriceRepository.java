package com.cat.prices.data.repository;

import com.cat.prices.data.domain.Price;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepository extends JpaRepository<Price, Integer> {

}

package com.cat.prices.data.service;

import com.cat.prices.data.domain.Price;
import jakarta.persistence.criteria.CriteriaBuilder.In;
import java.util.List;

public interface PriceService {

  Price create(Price price);

  Price findById(Integer id);

  Price update(Price price,Integer id);

  Price updatePriceProduct(Price price, Integer id);

  List<Price> getAll();

  void deleteById(Integer id);


}

package com.cat.prices.data.service.impl;

import com.cat.prices.data.domain.Price;
import com.cat.prices.data.repository.PriceRepository;
import com.cat.prices.data.service.PriceService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PriceServiceImpl implements PriceService {

  private final PriceRepository priceRepository;
  public PriceServiceImpl(PriceRepository priceRepository) {
    this.priceRepository = priceRepository;
  }

  @Override
  public Price create(Price price) {
    return priceRepository.save(price);
  }

  @Override
  public Price findById(Integer id) {
    return priceRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Price not found"));
  }

  @Override
  public Price update(Price price, Integer id) {
    Price priceToUpdate = this.findById(id);
    priceToUpdate.update(price);
    return priceRepository.save(priceToUpdate);
  }

  @Override
  public Price updatePriceProduct(Price price, Integer id) {
    Price priceToUpdate = this.findById(id);
    priceToUpdate.updatePriceProduct(price);
    return priceRepository.save(priceToUpdate);
  }

  @Override
  public List<Price> getAll() {
    return priceRepository.findAll();
  }

  @Override
  public void deleteById(Integer id) {
    this.findById(id);
    priceRepository.deleteById(id);
  }


}

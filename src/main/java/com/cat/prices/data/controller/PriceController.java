package com.cat.prices.data.controller;

import com.cat.prices.data.controller.api.PriceApi;
import com.cat.prices.data.domain.Price;
import com.cat.prices.data.service.PriceService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PriceController implements PriceApi {

  private final PriceService priceService;

  public PriceController(PriceService priceService) {
    this.priceService = priceService;
  }


  @Override
  public ResponseEntity<Price> save(Price price) {
    Price savedPrice = priceService.create(price);
    return new ResponseEntity<>(savedPrice, HttpStatus.CREATED);
  }

  @Override
  public ResponseEntity<List<Price>> findAll() {
    List<Price> prices = priceService.getAll();
    return new ResponseEntity<>(prices, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<Price> findById(Integer id) {
    Price price = priceService.findById(id);
    return new ResponseEntity<>(price, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<Price> update(Price price, Integer id) {
    Price updatedPrice = priceService.update(price, id);
    return new ResponseEntity<>(updatedPrice, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<Price> updatePriceProduct(Price price, Integer id) {
    Price updatedPrice = priceService.updatePriceProduct(price, id);
    return new ResponseEntity<>(updatedPrice, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<Void> deleteById(Integer id) {
    priceService.deleteById(id);
    return ResponseEntity.ok().build();
  }
}

package com.cat.prices.data.controller.api;

import com.cat.prices.data.domain.Price;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/v1/prices")
public interface PriceApi {

  @PostMapping
  ResponseEntity<Price> save(@RequestBody Price price);

  @GetMapping
  ResponseEntity<List<Price>> findAll();

  @GetMapping("/{id}")
  ResponseEntity<Price> findById(@PathVariable Integer id);

  @PutMapping("/{id}")
  ResponseEntity<Price> update(@RequestBody Price price,
      @PathVariable Integer id);

  @PatchMapping("/{id}")
  ResponseEntity<Price> updatePriceProduct(@RequestBody Price price,
      @PathVariable Integer id);


  @DeleteMapping("/{id}")
  ResponseEntity<Void> deleteById(@PathVariable Integer id);
}

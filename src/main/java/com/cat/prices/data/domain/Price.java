package com.cat.prices.data.domain;

import com.cat.prices.data.enums.CurrencyEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.function.Consumer;
import java.util.function.Supplier;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "T_PRICES")
public class Price {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
  private LocalDateTime startDate;

  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
  private LocalDateTime endDate;

  private BigDecimal priceProduct;

  @Enumerated(EnumType.STRING)
  private CurrencyEnum currency;


  public void update(Price price){
    if(price == null){
      throw new RuntimeException("Price to update cannot be null");
    }
    updateIfDifferent(this::getStartDate, this::setStartDate, price.getStartDate());
    updateIfDifferent(this::getEndDate, this::setEndDate, price.getEndDate());
    updateIfDifferent(this::getPriceProduct, this::setPriceProduct, price.getPriceProduct());
    updateIfDifferent(this::getCurrency, this::setCurrency, price.getCurrency());
  }

  public void updatePriceProduct(Price price){
    if(price == null){
      throw new RuntimeException("Price to update cannot be null");
    }
    updateIfDifferent(this::getPriceProduct, this::setPriceProduct, price.getPriceProduct());
  }

  private <T> void updateIfDifferent(Supplier<T> getter, Consumer<T> setter, T newValue){
    T currentValue = getter.get();
    if((currentValue == null && newValue != null) ||
        (currentValue!= null && !currentValue.equals(newValue))){
      setter.accept(newValue);
    }
  }

}

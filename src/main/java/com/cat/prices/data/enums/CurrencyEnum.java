package com.cat.prices.data.enums;

public enum CurrencyEnum {

  EUR("EUR"),
  USD("USD"),
  GBP("GBP");

  private String code;

  CurrencyEnum(String code) {
    this.code = code;
  }

  public String getCode() {
    return code;
  }
}

package com.dhnhan.level2.oop.dtos;

/**
 * @author Nhan Dinh
 * @since 1/12/22
 **/
public abstract class BaseProduct extends BaseRecord {

  private String name;

  private Integer number;

  private Integer price;

  public BaseProduct(Integer id, String name, Integer number, Integer price) {
    super(id);
    this.name = name;
    this.number = number;
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public Integer getNumber() {
    return number;
  }

  public Integer getPrice() {
    return price;
  }
}

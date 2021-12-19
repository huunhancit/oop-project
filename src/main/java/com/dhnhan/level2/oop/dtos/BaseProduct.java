package com.dhnhan.level2.oop.dtos;

/**
 * @author Nhan Dinh
 * @since 12/19/21
 **/
public class BaseProduct {

  private Integer id;

  private String name;

  private Integer number;

  private Integer price;

  public BaseProduct(Integer id, String name, Integer number, Integer price) {
    this.id = id;
    this.name = name;
    this.number = number;
    this.price = price;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getNumber() {
    return number;
  }

  public void setNumber(Integer number) {
    this.number = number;
  }

  public Integer getPrice() {
    return price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }
}

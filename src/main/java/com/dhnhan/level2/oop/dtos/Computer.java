package com.dhnhan.level2.oop.dtos;

/**
 * @author Nhan Dinh
 * @since 1/12/22
 **/
public class Computer extends BaseProduct {

  private Integer yearOfManufacture;

  public Computer(Integer id, String name, Integer number, Integer price, Integer yearOfManufacture) {
    super(id, name, number, price);
    this.yearOfManufacture = yearOfManufacture;
  }
}

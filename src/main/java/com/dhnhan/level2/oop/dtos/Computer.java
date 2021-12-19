package com.dhnhan.level2.oop.dtos;

public class Computer extends BaseProduct {

  private Integer yearOfManufacture;

  public Computer(Integer id, String name, Integer number, Integer price, Integer yearOfManufacture) {
    super(id, name, number, price);
    this.yearOfManufacture = yearOfManufacture;
  }

  public Integer getYearOfManufacture() {
    return yearOfManufacture;
  }

  public void setYearOfManufacture(Integer yearOfManufacture) {
    this.yearOfManufacture = yearOfManufacture;
  }

  public void printInfo() {
    System.out.printf("Product id: %d - product name: %s%n", this.getId(), this.getName());
  }
}

package com.dhnhan.level2.nhan.dtos;

public class Computer {
  private Integer id;
  private String name;
  private Integer number;
  private Integer price;
  private Integer yearOfManufacture;

  public Computer(Integer id, String name, Integer number, Integer price, Integer yearOfManufacture) {
    this.id = id;
    this.name = name;
    this.number = number;
    this.price = price;
    this.yearOfManufacture = yearOfManufacture;
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

  public Integer getYearOfManufacture() {
    return yearOfManufacture;
  }

  public void setYearOfManufacture(Integer yearOfManufacture) {
    this.yearOfManufacture = yearOfManufacture;
  }

  public void printInfo() {
    System.out.println(String.format("Product id: %d - product name: %s", this.id, this.name));
  }
}

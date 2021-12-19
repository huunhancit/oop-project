package com.dhnhan.level2.nhan.dtos;

/**
 * @author Nhan Dinh
 * @since 12/19/21
 **/
public class Phone {
  private Integer id;
  private String name;
  private Integer number;
  private Integer price;
  private String color;

  public Phone(Integer id, String name, Integer number, Integer price, String color) {
    this.id = id;
    this.name = name;
    this.number = number;
    this.price = price;
    this.color = color;
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

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public void printInfo() {
    System.out.println(String.format("Product id: %d - product name: %s", this.id, this.name));
  }
}

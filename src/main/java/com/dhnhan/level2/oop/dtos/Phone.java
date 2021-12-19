package com.dhnhan.level2.oop.dtos;

/**
 * @author Nhan Dinh
 * @since 12/19/21
 **/
public class Phone extends BaseProduct {
  private String color;

  public Phone(Integer id, String name, Integer number, Integer price, String color) {
    super(id, name, number, price);
    this.color = color;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public void printInfo() {
    System.out.printf("Product id: %d - product name: %s%n", this.getId(), this.getName());
  }
}

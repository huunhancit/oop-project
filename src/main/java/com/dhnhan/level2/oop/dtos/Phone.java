package com.dhnhan.level2.oop.dtos;

/**
 * @author Nhan Dinh
 * @since 1/12/22
 **/
public class Phone extends BaseProduct {

  private String color;

  public Phone(Integer id, String name, Integer number, Integer price, String color) {
    super(id, name, number, price);
    this.color = color;
  }
}

package com.dhnhan.level1.oop.dtos;

/**
 * @author Nhan Dinh
 * @since 12/19/21
 **/
public class Shop {

  private Integer id;

  private String name;

  private String address;

  private ShopStatus status;

  private Integer number;

  public Shop(Integer id, String name, String address, ShopStatus status, Integer number) {
    this.id = id;
    this.name = name;
    this.address = address;
    this.status = status;
    this.number = number;
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

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public ShopStatus getStatus() {
    return status;
  }

  public void setStatus(ShopStatus status) {
    this.status = status;
  }

  public Integer getNumber() {
    return number;
  }

  public void setNumber(Integer number) {
    this.number = number;
  }

  public void printInfo() {
    System.out.printf("ID: %d - name: %s - status: %s%n", this.id, this.name, this.status.name());
  }
}

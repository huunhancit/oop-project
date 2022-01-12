package com.dhnhan.level1.oop.dtos;

import java.util.Objects;

/**
 * @author Nhan Dinh
 * @since 1/5/22
 **/
public class ShopInfo {

  private Integer id;

  private String name;

  private String address;

  private ShopStatus status;

  private Integer number;

  public ShopInfo(Integer id, String name, String address, ShopStatus status, Integer number) {
    this.id = id;
    this.name = name;
    this.address = address;
    this.status = status;
    this.number = number;
  }

  public Integer getId() {
    return id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ShopInfo shopInfo = (ShopInfo) o;
    return Objects.equals(id, shopInfo.id) && Objects.equals(name, shopInfo.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name);
  }
}

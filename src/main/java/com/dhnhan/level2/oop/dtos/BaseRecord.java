package com.dhnhan.level2.oop.dtos;

/**
 * @author Nhan Dinh
 * @since 1/12/22
 **/
public abstract class BaseRecord {

  private Integer id;

  public BaseRecord(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }
}

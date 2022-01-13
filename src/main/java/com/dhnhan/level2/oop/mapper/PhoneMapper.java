package com.dhnhan.level2.oop.mapper;

import com.dhnhan.level2.oop.CSVMapper;
import com.dhnhan.level2.oop.dtos.Phone;

/**
 * @author Nhan Dinh
 * @since 1/12/22
 **/
public class PhoneMapper implements CSVMapper<Phone> {

  @Override
  public Phone map(String[] fields) {
    Integer id = Integer.parseInt(fields[0]);
    String name = fields[1];
    String color = fields[2];
    Integer number = Integer.parseInt(fields[3]);
    Integer price = Integer.parseInt(fields[4]);
    return new Phone(id, name, number, price, color);
  }
}

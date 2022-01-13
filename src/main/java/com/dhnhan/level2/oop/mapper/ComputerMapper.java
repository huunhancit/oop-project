package com.dhnhan.level2.oop.mapper;

import com.dhnhan.level2.oop.CSVMapper;
import com.dhnhan.level2.oop.dtos.Computer;

/**
 * @author Nhan Dinh
 * @since 1/12/22
 **/
public class ComputerMapper implements CSVMapper<Computer> {

  @Override
  public Computer map(String[] fields) {
    Integer id = Integer.parseInt(fields[0]);
    String name = fields[1];
    Integer year = Integer.parseInt(fields[2]);
    Integer number = Integer.parseInt(fields[3]);
    Integer price = Integer.parseInt(fields[4]);
    return new Computer(id, name, number, price, year);
  }
}

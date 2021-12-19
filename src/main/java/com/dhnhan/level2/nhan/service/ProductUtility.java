package com.dhnhan.level2.nhan.service;

import com.dhnhan.level2.nhan.dtos.Computer;
import com.dhnhan.level2.nhan.dtos.Phone;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Nhan Dinh
 * @since 12/19/21
 **/
public class ProductUtility {

  public static List<Phone> findPhone(List<Phone> phones, String name, Integer price) {
    List<Phone> phoneList = new ArrayList<>();
    for (Phone phone : phones) {
      if (name != null && price != null) {
        boolean isFound = phone.getName().contains(name) && phone.getPrice() <= price;
        if (isFound) {
          phoneList.add(phone);
        }
      } else {
        if (name != null && phone.getName().contains(name)) {
          phoneList.add(phone);
        }
        if (price != null && phone.getPrice() <= price) {
          phoneList.add(phone);
        }
      }
    }
    return phoneList;
  }

  public static List<Computer> findComputer(List<Computer> computers, String name, Integer price) {
    List<Computer> computerList = new ArrayList<>();
    for (Computer computer : computers) {
      if (name != null && price != null) {
        boolean isFound = computer.getName().contains(name) && computer.getPrice() <= price;
        if (isFound) {
          computerList.add(computer);
        }
      } else {
        if (name != null && computer.getName().contains(name)) {
          computerList.add(computer);
        }
        if (price != null && computer.getPrice() <= price) {
          computerList.add(computer);
        }
      }
    }
    return computerList;
  }
}

package com.dhnhan.level2.oop;

import com.dhnhan.level2.oop.dtos.Computer;
import com.dhnhan.level2.oop.dtos.Phone;
import com.dhnhan.level2.oop.mapper.ComputerMapper;
import com.dhnhan.level2.oop.mapper.PhoneMapper;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

/**
 * @author Nhan Dinh
 * @since 1/12/22
 **/
public class AppMain {

  public static void main(String[] args) {
    try {
      CSVDataSource<Phone> phoneCSVDataSource = new CSVDataSource<>("product/phones.csv", new PhoneMapper());
      CSVDataSource<Computer> computerCSVDataSource = new CSVDataSource<>("product/computers.csv", new ComputerMapper());

      List<Phone> phones = phoneCSVDataSource.page(1, 10, "a");
      List<Computer> computers = computerCSVDataSource.page(1, 10, "a");
      Phone phone = phoneCSVDataSource.findById(1);
      Computer computer = computerCSVDataSource.findById(1);
//      ProductUtility.filter(phone);
//      ProductUtility.filter(computer);

    } catch (IllegalAccessException | IOException | URISyntaxException e) {
      e.printStackTrace();
    }
  }
}

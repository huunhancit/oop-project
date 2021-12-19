package com.dhnhan.level2.nhan;

import com.dhnhan.level2.nhan.dtos.Computer;
import com.dhnhan.level2.nhan.dtos.Phone;
import com.dhnhan.level2.nhan.service.ProductService;

import java.util.List;

/**
 * @author Nhan Dinh
 * @since 12/19/21
 **/
public class NhanAppMain {

  public static void main(String[] args) {
    try {
      ProductService productService = new ProductService();
      List<Computer> computerList = productService.searchComputer(1, 5, "Vaio");
      computerList.forEach(Computer::printInfo);
      List<Phone> phoneList = productService.searchPhone(1, 5, "Sam");
      phoneList.forEach(Phone::printInfo);
      System.out.println();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

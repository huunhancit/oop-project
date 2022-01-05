package com.dhnhan.level2.oop;

import com.dhnhan.level2.oop.dtos.Computer;
import com.dhnhan.level2.oop.service.ProductService;
import com.dhnhan.level2.oop.service.ProductServiceImpl;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

/**
 * @author Nhan Dinh
 * @since 12/21/21
 **/
public class ProductAppMain {

  public static void main(String[] args) {
    ProductService productService = null;
    try {
      productService = new ProductServiceImpl();
      List<Computer> computers = productService.getComputers(2, 5);
      computers.forEach(Computer::printInfo);
    } catch (IllegalAccessException | IOException | URISyntaxException e) {
      e.printStackTrace();
    }

  }
}

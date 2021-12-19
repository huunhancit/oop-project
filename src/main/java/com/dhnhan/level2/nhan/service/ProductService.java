package com.dhnhan.level2.nhan.service;

import com.dhnhan.level2.nhan.dtos.Computer;
import com.dhnhan.level2.nhan.dtos.Phone;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Nhan Dinh
 * @since 12/19/21
 **/
public class ProductService {

  private List<Phone> phones;

  private List<Computer> computers;

  public ProductService() throws IllegalAccessException, IOException, URISyntaxException {
    this.phones = this.loadPhones();
    this.computers = this.loadComputers();
  }

  private List<Phone> loadPhones() throws IllegalAccessException, IOException, URISyntaxException {
    List<String> phoneStrs = this.loadFile("product/phones.csv");
    List<Phone> phones = new ArrayList<>();
    for (String phone : phoneStrs) {
      String[] array = phone.split(",");
      Integer id = Integer.parseInt(array[0]);
      String name = array[1];
      String color = array[2];
      Integer number = Integer.parseInt(array[3]);
      Integer price = Integer.parseInt(array[4]);
      phones.add(new Phone(id, name, number, price, color));
    }
    return phones;
  }

  private List<Computer> loadComputers() throws IllegalAccessException, IOException, URISyntaxException {
    List<String> computerStrs = this.loadFile("product/computers.csv");
    List<Computer> computers = new ArrayList<>();
    for (String computerStr : computerStrs) {
      String[] array = computerStr.split(",");
      Integer id = Integer.parseInt(array[0]);
      String name = array[1];
      Integer year = Integer.parseInt(array[2]);
      Integer number = Integer.parseInt(array[3]);
      Integer price = Integer.parseInt(array[4]);
      computers.add(new Computer(id, name, year, number, price));
    }
    return computers;
  }

  private List<String> loadFile(String fileName) throws IOException, URISyntaxException, IllegalAccessException {
    URL resource = this.getClass().getClassLoader().getResource(fileName);
    if (resource != null) {
      File csv = new File(resource.toURI());
      try (BufferedReader br = new BufferedReader(new FileReader(csv))) {
        List<String> products = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) {
          products.add(line);
        }
        return products;
      }
    } else {
      throw new IllegalAccessException("Access file failed");
    }
  }

  public List<Phone> searchPhone(int page, int pageSize, String name) {
    List<Phone> result = new ArrayList<>();
    for (Phone phone : this.phones) {
      if (phone.getName().contains(name)) {
        result.add(phone);
      }
    }
    int from = (page - 1) * pageSize;
    int to = Math.min((page * pageSize), result.size());
    return from > to ? Collections.emptyList() : result.subList(from, to);
  }

  public List<Computer> searchComputer(int page, int pageSize, String name) {
    List<Computer> result = new ArrayList<>();
    for (Computer computer : this.computers) {
      if (computer.getName().contains(name)) {
        result.add(computer);
      }
    }
    int from = (page - 1) * pageSize;
    int to = Math.min((page * pageSize), result.size());
    return from > to ? Collections.emptyList() : result.subList(from, to);
  }

  public List<Computer> findComputer(String name, Integer price) {
    return ProductUtility.findComputer(this.computers, name, price);
  }

  public List<Phone> findPhone(String name, Integer price) {
    return ProductUtility.findPhone(this.phones, name, price);
  }
}

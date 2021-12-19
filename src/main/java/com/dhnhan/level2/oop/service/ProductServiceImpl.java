package com.dhnhan.level2.oop.service;

import com.dhnhan.level2.oop.CSVDataSource;
import com.dhnhan.level2.oop.dtos.Computer;
import com.dhnhan.level2.oop.dtos.Phone;
import com.dhnhan.level2.oop.mapper.ComputerMapper;
import com.dhnhan.level2.oop.mapper.PhoneMapper;
import com.dhnhan.level2.oop.utils.AppUtility;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * @author Nhan Dinh
 * @since 12/19/21
 **/
public class ProductServiceImpl implements ProductService {

  private static final String PHONE_CSV_FILE_NAME = "product/phones.csv";

  private static final String COMPUTER_CSV_FILE_NAME = "product/computers.csv";

  private final CSVDataSource<Computer> computerCSVDataSource;

  private final CSVDataSource<Phone> phoneCSVDataSource;

  public ProductServiceImpl() throws IllegalAccessException, IOException, URISyntaxException {
    this.computerCSVDataSource = new CSVDataSource<>(COMPUTER_CSV_FILE_NAME, new ComputerMapper());
    this.phoneCSVDataSource = new CSVDataSource<>(PHONE_CSV_FILE_NAME, new PhoneMapper());
  }

  @Override
  public List<Computer> searchComputer(String name, Integer price) {
    List<Computer> computers = this.computerCSVDataSource.getContent(1, this.computerCSVDataSource.count());
    return AppUtility.search(computers, name, price);
  }

  @Override
  public List<Phone> searchPhone(String name, Integer price) {
    List<Phone> phones = this.phoneCSVDataSource.getContent(1, this.phoneCSVDataSource.count());
    return AppUtility.search(phones, name, price);
  }

  @Override
  public List<Computer> getComputers(int page, int pageSize) {
    return this.computerCSVDataSource.getContent(page, pageSize);
  }

  @Override
  public List<Phone> getPhones(int page, int pageSize) {
    return this.phoneCSVDataSource.getContent(page, pageSize);
  }

  @Override
  public Optional<Phone> findPhone(Integer id) {
    List<Phone> phones = this.phoneCSVDataSource.getContent(0, this.phoneCSVDataSource.count());
    return AppUtility.findById(phones, id);
  }

  @Override
  public Optional<Computer> findComputer(Integer id) {
    List<Computer> computers = this.computerCSVDataSource.getContent(1, this.computerCSVDataSource.count());
    return AppUtility.findById(computers, id);
  }
}

package com.dhnhan.level2.oop.service;

import com.dhnhan.level2.oop.CSVDataSource;
import com.dhnhan.level2.oop.dtos.BaseProduct;
import com.dhnhan.level2.oop.dtos.Computer;
import com.dhnhan.level2.oop.dtos.Phone;
import com.dhnhan.level2.oop.mapper.ComputerMapper;
import com.dhnhan.level2.oop.mapper.PhoneMapper;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Nhan Dinh
 * @since 1/12/22
 **/
public class ProductService {

  private static final String FILE_NAME_PHONE = "product/phone.csv";
  private static final String FILE_NAME_COMPUTER = "product/computer.csv";

  private CSVDataSource<Computer> computerCSVDataSource;

  private CSVDataSource<Phone> phoneCSVDataSource;

  private List<CSVDataSource<? extends BaseProduct>> dataSources = new ArrayList<>();

  public ProductService() throws IllegalAccessException, IOException, URISyntaxException {
    this.computerCSVDataSource = new CSVDataSource<>(FILE_NAME_COMPUTER, new ComputerMapper());
    this.phoneCSVDataSource = new CSVDataSource<>(FILE_NAME_PHONE, new PhoneMapper());
    dataSources.add(this.computerCSVDataSource);
    dataSources.add(this.phoneCSVDataSource);
  }

  public List<BaseProduct> searchByPrice(Integer price) {
    List<BaseProduct> products = new ArrayList<>();
    for (CSVDataSource<? extends BaseProduct> dataSource : this.dataSources) {
      products.addAll(dataSource.search(price));
    }
    return products;
  }
}

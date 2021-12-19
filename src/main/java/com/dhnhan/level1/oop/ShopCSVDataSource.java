package com.dhnhan.level1.oop;

import com.dhnhan.level1.oop.dtos.Shop;
import com.dhnhan.level1.oop.dtos.ShopStatus;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Nhan Dinh
 * @since 12/19/21
 **/
public class ShopCSVDataSource {

  private static final String FILE_NAME_SHOPS = "shops.csv";

  private List<Shop> shops;

  public ShopCSVDataSource() throws IllegalAccessException, IOException, URISyntaxException {
    this.loadShops();
  }

  private void loadShops() throws IllegalAccessException, IOException, URISyntaxException {
    this.shops = new ArrayList<>();
    List<String> shopStrs = this.loadFile(FILE_NAME_SHOPS);
    for (String shopStr : shopStrs) {
      String[] strs = shopStr.split(",");
      Integer id = Integer.parseInt(strs[0]);
      String name = strs[1];
      String address = strs[2];
      ShopStatus status = ShopStatus.valueOf(strs[3]);
      Integer number = Integer.parseInt(strs[4]);
      this.shops.add(new Shop(id, name, address, status, number));
    }
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

  public List<Shop> paging(int page, int pageSize) {
    int from = (page - 1) * pageSize;
    int to = Math.min((page * pageSize), this.shops.size());
    return this.shops.subList(from, to);
  }

  public int total() {
    int total = 0;
    for (Shop shop : this.shops) {
      total += shop.getNumber();
    }
    return total;
  }
}

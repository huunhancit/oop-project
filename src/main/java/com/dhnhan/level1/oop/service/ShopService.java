package com.dhnhan.level1.oop.service;

import com.dhnhan.level1.nhan.Shop;
import com.dhnhan.level1.oop.dtos.ShopInfo;
import com.dhnhan.level1.oop.dtos.ShopStatus;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Nhan Dinh
 * @since 1/5/22
 **/
public class ShopService {

  private final List<ShopInfo> shops;

  private static final String CSV_SEPARATOR = ",";

  private static final String FILE_NAME_SHOP = "shops.csv";

  private static final int PAGE_SIZE_DEFAULT = 10;

  public ShopService() throws URISyntaxException, IOException {
    this.shops = new ArrayList<>();
    this.load();
  }

  private void load() throws URISyntaxException, IOException {
    URL resource = Shop.class.getClassLoader().getResource(FILE_NAME_SHOP);
    if (resource != null) {
      File csv = new File(resource.toURI());
      try (BufferedReader br = new BufferedReader(new FileReader(csv))) {
        String line;
        while ((line = br.readLine()) != null) {
          String[] fields = line.split(CSV_SEPARATOR);
          Integer id = Integer.parseInt(fields[0]);
          String name = fields[1];
          String address = fields[2];
          ShopStatus status = ShopStatus.valueOf(fields[3]);
          Integer number = Integer.parseInt(fields[4]);
          ShopInfo shopInfo = new ShopInfo(
              id, name, address, status, number
          );
          this.shops.add(shopInfo);
        }
      }
    }
  }

  public List<ShopInfo> page(int page, int pageSize) {
    int indexFrom = (page - 1) * pageSize;
    int indexTo = Math.min(page * pageSize, this.shops.size());
    return this.shops.subList(indexFrom, indexTo);
  }

  public List<ShopInfo> page() {
    return this.page(1, this.shops.size());
  }

  public List<ShopInfo> page(int page) {
    return this.page(page, PAGE_SIZE_DEFAULT);
  }

}

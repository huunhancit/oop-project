package com.dhnhan.level1.oop;


import com.dhnhan.level1.oop.dtos.Shop;

import java.util.List;

/**
 * @author Nhan Dinh
 * @since 12/19/21
 **/
public class ShopAppMain {

  public static void main(String[] args) {
    try {
      ShopCSVDataSource csvDataSource = new ShopCSVDataSource();
      List<Shop> shops = csvDataSource.paging(1, 5);
      shops.forEach(Shop::printInfo);
      Integer shopId = 1;
      System.out.printf("Finding shop id: %d...\n", shopId);
      Shop shop = ShopUtility.findById(shops, shopId);
      if (shop != null) {
        shop.printInfo();
      } else {
        System.out.println("Shop not found");
      }
      System.out.printf("Total: %d\n", csvDataSource.total());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

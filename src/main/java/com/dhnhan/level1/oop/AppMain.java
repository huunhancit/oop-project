package com.dhnhan.level1.oop;

import com.dhnhan.level1.oop.dtos.ShopInfo;
import com.dhnhan.level1.oop.service.ShopService;
import com.dhnhan.level1.oop.utils.AppUtility;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

/**
 * @author Nhan Dinh
 * @since 1/5/22
 **/
public class AppMain {
  private int ab;

  private Integer c;

  public static void main(String[] args) {
    try {
      ShopService shopService = new ShopService();
      int page = 1;

      List<ShopInfo> shopInfoList = shopService.page(page, 3);
      System.out.println("Shop: " + shopInfoList.get(0));
      ShopInfo shopInfo = AppUtility.findById(shopInfoList, 1);
    } catch (URISyntaxException | IOException e) {
      System.out.println("error " + e.getMessage());
    }
//    System.out.println(new Test().a);
//    System.out.println(new Test().b);
  }
}

package com.dhnhan.level1.oop.utils;

import com.dhnhan.level1.oop.dtos.ShopInfo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author Nhan Dinh
 * @since 1/5/22
 **/
public final class AppUtility {

  private AppUtility() {
  }

  public static ShopInfo findById(List<ShopInfo> shops, Integer id) {
    for (ShopInfo shopInfo : shops) {
      if (shopInfo.getId().equals(id)) {
        return shopInfo;
      }
    }
    return null;
  }

  public static String formatDate(Date date) {
    return new SimpleDateFormat("dd/MM/yyyy").format(date);
  }
}

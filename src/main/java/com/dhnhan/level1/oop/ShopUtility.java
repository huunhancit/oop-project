package com.dhnhan.level1.oop;

import com.dhnhan.level1.oop.dtos.Shop;

import java.util.List;

/**
 * @author Nhan Dinh
 * @since 12/19/21
 **/
public final class ShopUtility {

  private ShopUtility() {
  }

  public static Shop findById(List<Shop> shops, Integer id) {
    for (Shop s : shops) {
      if (s.getId().equals(id)) return s;
    }
    return null;
  }

}

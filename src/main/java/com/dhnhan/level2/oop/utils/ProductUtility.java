package com.dhnhan.level2.oop.utils;

import com.dhnhan.level2.oop.dtos.BaseProduct;
import com.dhnhan.level2.oop.dtos.BaseRecord;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Nhan Dinh
 * @since 12/19/21
 **/
public final class ProductUtility {

  private ProductUtility() {
  }

  public static <T extends BaseProduct> List<T> find(List<T> content, String name, Integer price) {
    List<T> result = new ArrayList<>();
    for (T t : content) {
      if (name != null && price != null) {
        boolean isFound = t.getName().contains(name) && t.getPrice() <= price;
        if (isFound) {
          result.add(t);
        }
      } else {
        if (name != null && t.getName().contains(name)) {
          result.add(t);
        }
        if (price != null && t.getPrice() <= price) {
          result.add(t);
        }
      }
    }
    return result;
  }

  public static <T extends BaseRecord> T findById(List<T> content, Integer id) {
    return content.stream().filter(it -> it.getId().equals(id)).findFirst().orElse(null);
  }

  public static <T extends BaseProduct> List<T> filter(List<T> content, BaseProduct baseProduct) {
    return content.stream().filter(it -> it.getName().contains(baseProduct.getName())).collect(Collectors.toList());
  }
}

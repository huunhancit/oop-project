package com.dhnhan.level2.oop.utils;

import com.dhnhan.level2.oop.dtos.BaseProduct;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Nhan Dinh
 * @since 12/19/21
 **/
public final class AppUtility {

  private AppUtility() {
  }

  public static <T extends BaseProduct> Optional<T> findById(List<T> content, Integer id) {
    return content.stream()
        .filter(it -> it.getId().equals(id))
        .findFirst();
  }

  public static <T extends BaseProduct> List<T> search(List<T> content, String name, Integer price) {
    return content.stream()
        .filter(it -> {
          if (name != null && price != null) {
            return it.getName().contains(name) && it.getPrice() <= price;
          } else {
            if (name != null) {
              return it.getName().contains(name);
            } else {
              return it.getPrice() <= price;
            }
          }
        }).collect(Collectors.toList());
  }
}

package com.dhnhan.level1.nhan;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class Shop {

  public static String[] read_file_csv() {
    URL resource = Shop.class.getClassLoader().getResource("shops.csv");
    if (resource != null) {
      File csv = null;
      try {
        csv = new File(resource.toURI());
      } catch (URISyntaxException e) {
        e.printStackTrace();
      }
      try (BufferedReader br = new BufferedReader(new FileReader(csv))) {
        String line;
        String[] lines = new String[10];
        int i = 0;
        while ((line = br.readLine()) != null) {
          lines[i] = line;
          i++;
        }
        return lines;
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return null;
  }

  public static void print_shop_info() {
    String[] abc = read_file_csv();
    for (int i = 0; i < abc.length; i++) {
      String[] s = abc[i].split(",");
      String name = s[1];
      String address = s[2];
      String status = s[3];
      System.out.println("Name: " + name + " - address: " + address + " - status: " + status);
    }
  }

  public static void print_paging(int page, int pageSize) {
    int a = (page - 1) * pageSize;
    int b = page * pageSize;
    String[] abc = read_file_csv();
    if (b > abc.length) {
      b = abc.length;
    }
    for (int i = a; i < b; i++) {
      String[] s = abc[i].split(",");
      String name = s[1];
      String address = s[2];
      String status = s[3];
      System.out.println("Name: " + name + " - address: " + address + " - status: " + status);
    }
  }

  public static void totalProducts() {
    String[] abc = read_file_csv();
    int total = 0;
    for (int i = 0; i < abc.length; i++) {
      total += Integer.parseInt(abc[i].split(",")[4]);
    }
    System.out.println("Total products: " + total);
  }

  public static void main(String[] args) {
//    print_shop_info();
    System.out.println("Page : 1");
    print_paging(1, 3);
    System.out.println("==========================");
    System.out.println("Page : 2");
    print_paging(2, 3);
    System.out.println("==========================");
    System.out.println("Page : 3");
    print_paging(3, 3);
    System.out.println("==========================");
    System.out.println("Page : 4");
    print_paging(4, 3);
    System.out.println("==========================");
    totalProducts();
  }
}

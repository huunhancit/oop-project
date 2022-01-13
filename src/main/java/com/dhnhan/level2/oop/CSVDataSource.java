package com.dhnhan.level2.oop;

import com.dhnhan.level2.oop.dtos.BaseProduct;
import com.dhnhan.level2.oop.utils.ProductUtility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Nhan Dinh
 * @since 1/12/22
 **/
public class CSVDataSource<T extends BaseProduct> {

  private static final String COMMA = ",";

  protected List<T> content;

  private CSVMapper<T> mapper;

  public CSVDataSource(String fileName, CSVMapper<T> mapper) throws IllegalAccessException, IOException, URISyntaxException {
    this.mapper = mapper;
    this.content = this.loadFile(fileName);
  }

  private List<T> loadFile(String fileName) throws IOException, URISyntaxException, IllegalAccessException {
    URL resource = this.getClass().getClassLoader().getResource(fileName);
    if (resource != null) {
      File csv = new File(resource.toURI());
      try (BufferedReader br = new BufferedReader(new FileReader(csv))) {
        List<T> entities = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) {
          String[] fields = line.split(COMMA);
          T entity = this.mapper.map(fields);
          entities.add(entity);
        }
        return entities;
      }
    } else {
      throw new IllegalAccessException("Access file failed");
    }
  }

  public List<T> page(int page, int pageSize, String name) {
    List<T> result = new ArrayList<>();
    for (T t : this.content) {
      if (t.getName().equals(name)) {
        result.add(t);
      }
    }
    int from = (page - 1) * pageSize;
    int to = Math.min((page * pageSize), result.size());
    return from > to ? Collections.emptyList() : result.subList(from, to);
  }

  public T findById(Integer id) {
    return ProductUtility.findById(this.content, id);
  }



  public List<T> search(String name, Integer price) {
    return ProductUtility.find(this.content, name, price);
  }

  public List<T> search(Integer price) {
    return ProductUtility.find(this.content, null, price);
  }
}

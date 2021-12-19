package com.dhnhan.level2.oop;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Nhan Dinh
 * @since 12/19/21
 **/
public class CSVDataSource<T> {

  private static final String CSV_SEPARATOR = ",";

  private List<T> content;

  private final String fileName;

  private final CSVMapper<T> mapper;

  public CSVDataSource(String fileName, CSVMapper<T> mapper) throws IllegalAccessException, IOException, URISyntaxException {
    this.fileName = fileName;
    this.mapper = mapper;
    this.load();
  }

  private List<String> loadFile() throws IOException, URISyntaxException, IllegalAccessException {
    URL resource = this.getClass().getClassLoader().getResource(this.fileName);
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

  private void load() throws IllegalAccessException, IOException, URISyntaxException {
    List<String> lines = this.loadFile();
    this.content = lines.stream()
        .map(it -> this.mapper.map(it.split(CSV_SEPARATOR)))
        .collect(Collectors.toList());
  }

  public int count() {
    return this.content.size();
  }

  public List<T> getContent(int page, int pageSize) {
    int from = (page - 1) * pageSize;
    int to = Math.min((page * pageSize), this.content.size());
    return this.content.subList(from, to);
  }
}

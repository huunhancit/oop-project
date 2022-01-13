package com.dhnhan.level2.oop;

import com.dhnhan.level2.oop.dtos.Phone;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * @author Nhan Dinh
 * @since 1/12/22
 **/
public class CSVPhone extends CSVDataSource<Phone> {

  public CSVPhone(String fileName, CSVMapper<Phone> mapper) throws IllegalAccessException, IOException, URISyntaxException {
    super(fileName, mapper);
  }

  @Override
  public Phone findById(Integer id) {
    Phone phone = this.findById(id);
    return phone.getName().equals("iphone13") ? phone : null;
  }

  public Phone findIdAndName(Integer id,String name) {
    Phone phone = this.findById(id);
    return phone.getName().equals(name) ? phone : null;
  }
}

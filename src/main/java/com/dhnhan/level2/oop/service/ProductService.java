package com.dhnhan.level2.oop.service;

import com.dhnhan.level2.oop.dtos.Computer;
import com.dhnhan.level2.oop.dtos.Phone;

import java.util.List;
import java.util.Optional;

public interface ProductService {

  List<Computer> searchComputer(String name, Integer price);

  List<Phone> searchPhone(String name, Integer price);

  List<Computer> getComputers(int page, int pageSize);

  List<Phone> getPhones(int page, int pageSize);

  Optional<Phone> findPhone(Integer id);

  Optional<Computer> findComputer(Integer id);
}

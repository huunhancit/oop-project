package com.dhnhan.level2.oop;

public interface CSVMapper<T> {

  T map(String []fields);
}

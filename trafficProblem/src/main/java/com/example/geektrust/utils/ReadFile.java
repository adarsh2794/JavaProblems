package com.example.geektrust.utils;

import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadFile {

  public String readFileAsString(String fileName)throws Exception {
    String data = "";
    try {
      data = new String(Files.readAllBytes(Paths.get(fileName)));

    } catch (Exception e) {
      System.out.println("Cannot find file");
      System.exit(0);
    }
    return data;
  }
}

package com.example.geektrust.utils;

import com.example.geektrust.models.InputData;
import com.example.geektrust.models.WeatherType;

public class ProcessInput {

  public InputData getProcessedInput(String input)
  {
    InputData inputData = new InputData();
    try
    {

      String[] arr = input.split(" ");
      inputData.setWeatherType(WeatherType.valueOf(arr[0]));
      inputData.setTrafficSpeedOrbit1(Integer.parseInt(arr[1]));
      inputData.setTrafficSpeedOrbit2(Integer.parseInt(arr[2]));
    }catch (Exception e)
    {
      System.out.println("Unable to read input");
      System.exit(0);
    }
    return inputData;
  }

}

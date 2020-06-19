package com.example.geektrust.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InputData {

  public WeatherType weatherType;
  public Integer trafficSpeedOrbit1;
  public Integer trafficSpeedOrbit2;

}

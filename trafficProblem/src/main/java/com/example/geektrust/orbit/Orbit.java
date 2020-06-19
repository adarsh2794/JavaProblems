package com.example.geektrust.orbit;

import com.example.geektrust.models.OrbitType;
import lombok.Data;

@Data
public class Orbit {

  Integer trafficSpeed;
  Integer distance;// in mm
  Integer craters;
  OrbitType orbitType;

  public Orbit(Integer trafficSpeed,Integer distance,Integer craters,OrbitType orbitType)
  {
    this.trafficSpeed = trafficSpeed;
    this.craters = craters;
    this.distance = distance;
    this.orbitType = orbitType;
  }

}

package com.example.geektrust.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehicleOrbitType {

  public VehicleType vehicleType;
  public OrbitType orbitType;

}
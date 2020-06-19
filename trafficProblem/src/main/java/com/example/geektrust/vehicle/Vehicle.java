package com.example.geektrust.vehicle;

import com.example.geektrust.models.VehicleType;
import java.util.HashMap;
import lombok.Data;

@Data
public class Vehicle {

  public VehicleType type;
  public Integer speed;
  public Integer timeToCrossCrater;

  public Vehicle(VehicleType type,Integer speed,Integer timeToCrossCrater)
  {
    this.speed = speed;
    this.timeToCrossCrater = timeToCrossCrater;
    this.type = type;
  }
  public HashMap<VehicleType,Vehicle> getVehicleTypeMap()
  {
    HashMap<VehicleType,Vehicle> vehicleTypeVehicleHashMap = new HashMap<>();
    vehicleTypeVehicleHashMap.put(VehicleType.BIKE,new Bike());
    vehicleTypeVehicleHashMap.put(VehicleType.TUKTUK,new TukTuk());
    vehicleTypeVehicleHashMap.put(VehicleType.CAR,new SuperCar());
    return vehicleTypeVehicleHashMap;
  }
}

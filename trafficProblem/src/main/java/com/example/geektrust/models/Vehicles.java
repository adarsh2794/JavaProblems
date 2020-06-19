package com.example.geektrust.models;

import com.example.geektrust.vehicle.Bike;
import com.example.geektrust.vehicle.TukTuk;
import com.example.geektrust.vehicle.Vehicle;
import com.example.geektrust.vehicle.SuperCar;
import java.util.HashMap;

public class Vehicles {

  public HashMap<VehicleType, Vehicle> getVehicleTypeMap()
  {
    HashMap<VehicleType,Vehicle> vehicleTypeVehicleHashMap = new HashMap<>();
    vehicleTypeVehicleHashMap.put(VehicleType.BIKE,new Bike());
    vehicleTypeVehicleHashMap.put(VehicleType.TUKTUK,new TukTuk());
    vehicleTypeVehicleHashMap.put(VehicleType.CAR,new SuperCar());
    return vehicleTypeVehicleHashMap;
  }

}

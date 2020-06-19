package com.example.geektrust.helpers;

import com.example.geektrust.models.VehicleOrbitType;
import com.example.geektrust.models.VehicleType;
import com.example.geektrust.orbit.Orbit;
import com.example.geektrust.vehicle.Vehicle;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TrafficTimeHelper {


  public String getBestTimeData(HashMap<VehicleOrbitType, Double> vehicleOrbitTimeMap) {
    Double minTime = 0.0;
    int initialPrecedence = 0;
    VehicleOrbitType output;
    String data = "Something went wrong";
    for (Map.Entry<VehicleOrbitType, Double> vehicleOrbitTypeIntegerEntry : vehicleOrbitTimeMap
        .entrySet()) {
      Map.Entry mapElement = vehicleOrbitTypeIntegerEntry;
      Double timeTaken = (Double) mapElement.getValue();
      VehicleOrbitType vehicleOrbitType = (VehicleOrbitType) mapElement.getKey();
      int vehiclePrecedence = Arrays.asList(VehicleType.values())
          .indexOf(vehicleOrbitType.getVehicleType());
      if ((minTime == 0 && initialPrecedence == 0) || (timeTaken <= minTime)) {
        if (timeTaken.equals(minTime) && vehiclePrecedence > initialPrecedence) {
          continue;
        }
        initialPrecedence = vehiclePrecedence;
        minTime = timeTaken;
        data = vehicleOrbitType.getVehicleType().toString() + " " + vehicleOrbitType.getOrbitType()
            .toString();
      }
    }

    return data;

  }

  private Integer getTotalCrater(Orbit orbit, Integer craterOffset) {
    return ((100 + craterOffset) * orbit.getCraters()) / 100;
  }

  public Double timeTakenByOrbit(Orbit orbit, Vehicle vehicle, Integer craterOffset) {
    Integer totalCraters = getTotalCrater(orbit, craterOffset);
    Integer currentSpeed = vehicle.getSpeed();
    if (vehicle.getSpeed() > orbit.getTrafficSpeed()) {
      currentSpeed = orbit.getTrafficSpeed();
    }
    Double timeTakenToCrossCrater = (double) totalCraters * vehicle.getTimeToCrossCrater();
    Double timeTakenOnRoad = (double) (orbit.getDistance() * 60) / currentSpeed;
    return timeTakenOnRoad + timeTakenToCrossCrater;
  }

}

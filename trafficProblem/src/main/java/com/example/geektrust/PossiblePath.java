package com.example.geektrust;

import com.example.geektrust.helpers.TrafficTimeHelper;
import com.example.geektrust.models.InputData;
import com.example.geektrust.models.VehicleOrbitType;
import com.example.geektrust.models.VehicleType;
import com.example.geektrust.models.Vehicles;
import com.example.geektrust.models.Weather;
import com.example.geektrust.orbit.Orbit1;
import com.example.geektrust.orbit.Orbit2;
import com.example.geektrust.utils.ProcessInput;
import com.example.geektrust.vehicle.Vehicle;
import java.util.ArrayList;
import java.util.HashMap;

class PossiblePath {

  private Weather weather;
  private ProcessInput processInput;
  private Orbit1 orbit1;
  private Orbit2 orbit2;
  private Vehicles vehicles;
  private TrafficTimeHelper trafficTimeHelper;

  PossiblePath(Weather weather, ProcessInput processInput, Orbit1 orbit1, Orbit2 orbit2,
      Vehicles vehicles, TrafficTimeHelper trafficTimeHelper) {
    this.weather = weather;
    this.processInput = processInput;
    this.orbit1 = orbit1;
    this.orbit2 = orbit2;
    this.vehicles = vehicles;
    this.trafficTimeHelper = trafficTimeHelper;
  }

  /**
   *
   * @param data
   * @return
   */

  public String getPossiblePath(String data) {
    InputData inputData = processInput.getProcessedInput(data);

    ArrayList<VehicleType> allowedVehicles = weather.getWeatherVehicleTypeMap()
        .get(inputData.getWeatherType());
    HashMap<VehicleOrbitType, Double> vehicleOrbitTimeMap = new HashMap<>();
    Integer craterOffset = weather.getWeatherCraterMap().get(inputData.getWeatherType());
    orbit1.setTrafficSpeed(inputData.getTrafficSpeedOrbit1());
    orbit2.setTrafficSpeed(inputData.getTrafficSpeedOrbit2());
    for (VehicleType vehicleType : allowedVehicles) {
      Vehicle vehicle = vehicles.getVehicleTypeMap().get(vehicleType);
      Double timeTakenByOrbit1 = trafficTimeHelper.timeTakenByOrbit(orbit1, vehicle, craterOffset);
      Double timeTakenByOrbit2 = trafficTimeHelper.timeTakenByOrbit(orbit2, vehicle, craterOffset);

      if (timeTakenByOrbit1 < timeTakenByOrbit2) {
        vehicleOrbitTimeMap.put(new VehicleOrbitType(vehicleType, orbit1.getOrbitType()),
            trafficTimeHelper.timeTakenByOrbit(orbit1, vehicle, craterOffset));
      } else {
        vehicleOrbitTimeMap.put(new VehicleOrbitType(vehicleType, orbit2.getOrbitType()),
            trafficTimeHelper.timeTakenByOrbit(orbit2, vehicle, craterOffset));
      }
    }
    return trafficTimeHelper.getBestTimeData(vehicleOrbitTimeMap);
  }

}

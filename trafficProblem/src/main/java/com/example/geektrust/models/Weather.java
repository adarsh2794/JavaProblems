package com.example.geektrust.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


public class Weather {


  private HashMap<WeatherType, ArrayList<VehicleType>> weatherVehicleTypeMap = new HashMap<>();
  private HashMap<WeatherType, Integer> weatherCraterMap = new HashMap<>();

  public HashMap<WeatherType, Integer> getWeatherCraterMap() {
    this.weatherCraterMap.put(WeatherType.SUNNY, -10);
    this.weatherCraterMap.put(WeatherType.RAINY, 20);
    this.weatherCraterMap.put(WeatherType.WINDY, 0);
    return this.weatherCraterMap;
  }

  public HashMap<WeatherType, ArrayList<VehicleType>> getWeatherVehicleTypeMap() {

    this.weatherVehicleTypeMap.put(WeatherType.SUNNY,
        new ArrayList<>(Arrays.asList(VehicleType.BIKE, VehicleType.CAR, VehicleType.TUKTUK)));
    this.weatherVehicleTypeMap.put(WeatherType.RAINY,
        new ArrayList<>(Arrays.asList(VehicleType.CAR, VehicleType.TUKTUK)));
    this.weatherVehicleTypeMap.put(WeatherType.WINDY,
        new ArrayList<>(Arrays.asList(VehicleType.BIKE, VehicleType.CAR)));
    return this.weatherVehicleTypeMap;

  }
}

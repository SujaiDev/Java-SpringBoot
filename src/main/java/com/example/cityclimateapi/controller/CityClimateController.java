package com.example.cityclimateapi.controller;

import org.springframework.web.bind.annotation.*;
import org.json.simple.JSONObject;
import com.example.cityclimateapi.service.*;

@RestController
@RequestMapping("/api/climate")
public class CityClimateController {

	private final CityClimateService climateService;

	public CityClimateController(CityClimateService climateService){
		this.climateService = climateService;
	}

	@GetMapping("/weather")
	public String getCityWeather(@RequestParam String city){
		try{
			JSONObject cityLocationData = climateService.getLocationData(city);
			if (cityLocationData == null) {
				return "City not found!";
			}
			double latitude = (double) cityLocationData.get("latitude");
			double longitude = (double) cityLocationData.get("longitude");

			return climateService.getWeatherData(latitude, longitude);
		}catch (Exception e){
			e.printStackTrace();
			return "Error occurred while fetching weather data!";
		}
    }

}

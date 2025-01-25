package com.example.cityclimateapi.service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CityClimateService {
	private final RestTemplate restTemplate;

	public CityClimateService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public JSONObject getLocationData(String city){
		city=city.replaceAll(" ","+");
		String url = "https://geocoding-api.open-meteo.com/v1/search?name=" + city + "&count=1&language=en&format=json";
		System.out.println(url);
		try{
			String response = restTemplate.getForObject(url, String.class);
			if(response == null) return null;

			JSONParser parser = new JSONParser();
			JSONObject resultJsonObj = (JSONObject) parser.parse(response);
			JSONArray locationData = (JSONArray) resultJsonObj.get("results");

			if(locationData == null || locationData.isEmpty()) return null;
			return (JSONObject) locationData.get(0);

		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	public String getWeatherData(double latitude, double longitude) {
		String url = "https://api.open-meteo.com/v1/forecast?latitude=" + latitude +
				"&longitude=" + longitude + "&current=temperature_2m,relative_humidity_2m,is_day,weather_code,wind_speed_10m";

		try {
			String response = restTemplate.getForObject(url, String.class);
			if (response == null) return "No weather data available!";

			JSONParser parser = new JSONParser();
			JSONObject resultJsonObj = (JSONObject) parser.parse(response);
			JSONObject currentWeatherJson = (JSONObject) resultJsonObj.get("current");

			StringBuilder weatherReport = new StringBuilder();
			String time = (String) currentWeatherJson.get("time");
			weatherReport.append("Current Time: ").append(time).append("\n");

			double temp = (double) currentWeatherJson.get("temperature_2m");
			weatherReport.append("Temperature: ").append(temp).append("°C\n");

			long humidity = (long) currentWeatherJson.get("relative_humidity_2m");
			weatherReport.append("Humidity: ").append(humidity).append("%\n");

			double windSpeed = (double) currentWeatherJson.get("wind_speed_10m");
			weatherReport.append("Wind Speed: ").append(windSpeed).append(" km/h\n");

			long isDay = (long) currentWeatherJson.get("is_day");
			weatherReport.append("Day/Night: ").append(isDay == 1 ? "Day" : "Night");

			return weatherReport.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return "Error occurred while fetching weather data!";
		}
	}
}
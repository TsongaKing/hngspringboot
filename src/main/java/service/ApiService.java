/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import location.GeoLocationResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.RestClientException;
import weather.WeatherResponse;

/**
 * Service class for handling geolocation and weather API calls.
 * 
 * @author phang
 */
@Service
public class ApiService {

    private final RestTemplate restTemplate = new RestTemplate();

    @Value("e5936e4175a8469db3726831d9ec961b") // Load from application.properties or environment variable
    private String apiKeyGeoLocation;

    @Value("7ca544b95dd848dfb1581153240707") // Load from application.properties or environment variable
    private String apiKeyWeather;

    // API URLs with placeholders for parameters
    private static final String GEO_LOCATION_URL_TEMPLATE = "https://ipgeolocation.abstractapi.com/v1/?api_key=e5936e4175a8469db3726831d9ec961b&ip_address=105.224.59.18";
    private static final String WEATHER_URL_TEMPLATE = "https://api.weatherapi.com/v1/current.json?key=7ca544b95dd848dfb1581153240707&q=-25.7599,28.2604&aqi=no";

    /**
     * Calls the geolocation API to get latitude and longitude based on IP address.
     * 
     * @param ipAddress The IP address to get geolocation data for.
     * @return GeoLocationResponse containing geolocation data.
     */
    public GeoLocationResponse getGeoLocation(String ipAddress) {
        try {
            return restTemplate.getForObject(GEO_LOCATION_URL_TEMPLATE, GeoLocationResponse.class, apiKeyGeoLocation, ipAddress);
        } catch (RestClientException e) {
            // Handle errors appropriately
            System.err.println("Error calling geolocation API: " + e.getMessage());
            return null;
        }
    }

    /**
     * Calls the weather API to get weather data based on latitude and longitude.
     * 
     * @param lat The latitude.
     * @param lon The longitude.
     * @return WeatherResponse containing weather data.
     */
    public WeatherResponse getWeatherUpdate(double lat, double lon) {
        try {
            return restTemplate.getForObject(WEATHER_URL_TEMPLATE, WeatherResponse.class, apiKeyWeather, lat, lon);
        } catch (RestClientException e) {
            // Handle errors appropriately
            System.err.println("Error calling weather API: " + e.getMessage());
            return null;
        }
    }
}
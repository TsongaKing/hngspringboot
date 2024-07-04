/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import location.GeoLocationResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import weather.WeatherResponse;

/**
 *
 * @author phang
 */

@Service
public class ApiService {
    private RestTemplate restTemplate = new RestTemplate();
    
    //run the app now
    
    public static final String YOUR_API_KEY_IP_GEOLOCATION = "e5936e4175a8469db3726831d9ec961b";
    private static final String YOUR_WEATHER_API_KEY= "6da7e177dbb22021087f1b2405de39bd";
    
    //use this api to get the lattitude an longitude from the ipaddress, sign up to get the api key...
    private static final String GEO_LOCATION_URL_TEMPLATE = "https://ipgeolocation.abstractapi.com/v1/?api_key=" + YOUR_API_KEY_IP_GEOLOCATION + "&ip_address={ipAddress}";
    //sign up to weatheraip.com to get the api key
    private static final String WEATHER_URL_TEMPLATE = "https://api.weatherapi.com/v1/current.json?key="+ YOUR_WEATHER_API_KEY + "&q={lat},{lon}&aqi=no";
    
    
    
    //call the geo location endpoint
    public GeoLocationResponse getGeoLocation(String ipAddress) {
        
        return restTemplate.getForObject(GEO_LOCATION_URL_TEMPLATE, GeoLocationResponse.class);
        
    }
    
    
    //call the weather api endpoint
    public WeatherResponse getWeatherUpdate(Double lat, Double lon) {
        
        return restTemplate.getForObject(WEATHER_URL_TEMPLATE, WeatherResponse.class, lat, lon);
        
        
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import jakarta.servlet.http.HttpServletRequest;
import location.GeoLocationResponse;
import model.ApiResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.ApiService;
import weather.WeatherResponse;

/**
 *
 * @author phang
 */
@RestController
@RequestMapping("/api")
public class ApiEndpoint {
    
   
    @Autowired
   private ApiService apiService;
    
    
    @GetMapping("/greet")
    public String hello() {
        return "hello word!";
    }
    
    //re run the app
    
    //this is the endpoint that will be expose as the solution
    @GetMapping("/hello")
    public ApiResponseModel helloEndpoint(@RequestParam String visitor_name, @RequestHeader(value = "X-Forwarded-For", required=false) String xForwardedFor, HttpServletRequest request) {
        //this is responsible for the getting the ipaddress of the client's browser
        String ipAddress = "";
        if (xForwardedFor != null && !xForwardedFor.isEmpty()) {
            ipAddress = xForwardedFor.split(",")[0];
        } else {
            ipAddress = request.getRemoteAddr();//this is used in the local host
        }
        
        
        GeoLocationResponse geoLocationResponse = apiService.getGeoLocation(ipAddress);
        //to get the latittude and longitude
        
        double lat = geoLocationResponse.getLatitude();
        double lon = geoLocationResponse.getLongitude();
        
        //these will be used as parameters in the weather api call
        
        WeatherResponse weatherResponse = apiService.getWeatherUpdate(lat, lon);
        //get the city from the response above
        //You got the models wrong. location is an entity on its own not a string
        String city = weatherResponse.getLocation().getName();
        
        System.out.println(city);
        //get the temperature
        double temp = weatherResponse.getCurrent().getTemp_c();
        
        //in the json response provided, you'' not that it uses "Mark", We'll thus need to use some regex to cleanse the leading and trailing "
        if(visitor_name.startsWith("\"") || visitor_name.endsWith("\"")) {
            // Remove leading and trailing double quotes
            visitor_name = visitor_name.replaceAll("^\"|\"$", "");
        }
    
        //edit the greeting
        String greeting = "Hello,  " + visitor_name +"!, the temperature is " + Double.toString(temp) + " degress Celsius " + city;
        System.out.println(greeting);
        //return the json now
        //rerun the app
        return new ApiResponseModel(ipAddress, city, greeting);
}
}

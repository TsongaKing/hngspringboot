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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.ApiService;
import weather.WeatherResponse;

@RestController
public class ApiEndpoint {

    @Autowired
    private ApiService apiService;

    @GetMapping("/api/greet")
    public String hello() {
        return "Hello, World!";
    }

    @GetMapping("/api/hello")
    public ApiResponseModel helloEndpoint(@RequestParam String visitor_name,
                                          @RequestHeader(value = "X-Forwarded-For", required = false) String xForwardedFor,
                                          HttpServletRequest request) {
        // Get the IP address of the client using the utility method
        String ipAddress = getClientIp(request, xForwardedFor);

        // Get the geolocation information based on the IP address
        GeoLocationResponse geoLocationResponse = apiService.getGeoLocation(ipAddress);

        // Handle case where geoLocationResponse is null (error case)
        if (geoLocationResponse == null) {
            // Handle appropriately (throw exception, return error response, etc.)
            return new ApiResponseModel(ipAddress, "Unknown", "Error fetching geolocation data");
        }

        // Extract latitude and longitude from the geolocation response
        double lat = geoLocationResponse.getLatitude();
        double lon = geoLocationResponse.getLongitude();

        // Get the weather information based on the latitude and longitude
        WeatherResponse weatherResponse = apiService.getWeatherUpdate(lat, lon);

        // Handle case where weatherResponse is null (error case)
        if (weatherResponse == null) {
            // Handle appropriately (throw exception, return error response, etc.)
            return new ApiResponseModel(ipAddress, "Unknown", "Error fetching weather data");
        }

        // Extract city and temperature information from the weather response
        String city = weatherResponse.getLocation().getName();
        double temp = weatherResponse.getCurrent().getTemp_c();

        // Cleanse the visitor name from leading and trailing double quotes if present
        if (visitor_name.startsWith("\"") || visitor_name.endsWith("\"")) {
            visitor_name = visitor_name.replaceAll("^\"|\"$", "");
        }

        // Create the greeting message
        String greeting = "Hello, " + visitor_name + "!, the temperature is " + temp + " degrees Celsius in " + city;
        System.out.println(greeting);

        // Return the JSON response
        return new ApiResponseModel(ipAddress, city, greeting);
    }

    // Utility method to get client IP address and convert IPv6 loopback to IPv4
    private String getClientIp(HttpServletRequest request, String xForwardedFor) {
        String ipAddress = "";
        if (xForwardedFor != null && !xForwardedFor.isEmpty()) {
            ipAddress = xForwardedFor.split(",")[0];
        } else {
            ipAddress = request.getRemoteAddr();
        }
        // Convert IPv6 loopback address to IPv4
        if ("0:0:0:0:0:0:0:1".equals(ipAddress)) {
            ipAddress = "127.0.0.1";
        }
        return ipAddress;
    }
}
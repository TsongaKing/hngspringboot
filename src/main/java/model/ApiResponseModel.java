/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 *
 * @author phang
 */
@JsonPropertyOrder({ "client_Ip", "location", "greeting" })
public class ApiResponseModel {
    private String client_ip;
    private String location;
    private String greeting;

    public ApiResponseModel(String client_ip, String location, String greeting) {
        this.client_ip = client_ip;
        this.location = location;
        this.greeting = greeting;
    }

    // Getters
    public String getClientIp() {
        return client_ip;
    }

    public String getLocation() {
        return location;
    }

    public String getGreeting() {
        return greeting;
    }

    // Setters
    public void setClientIp(String clientIp) {
        this.client_ip = clientIp;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    @Override
    public String toString() {
        return "ApiResponseModel{" +
                "client_ip='" + client_ip + '\'' +
                ", location='" + location + '\'' +
                ", greeting='" + greeting + '\'' +
                '}';
    }

    public static void main(String[] args) {
        ApiResponseModel response = new ApiResponseModel("Pretoria", "Hello Mark!", "127.0.0.1");
        System.out.println(response.toString());
    }
}
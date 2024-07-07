/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package location;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class representing the response from a geolocation API.
 * It includes fields for various geolocation details.
 * 
 * @author phang
 */
public class GeoLocationResponse {

    @JsonProperty("ip_address")
    private String ipAddress;

    private String city;
    private int cityGeonameId;
    private String region;
    private String regionIsoCode;
    private int regionGeonameId;
    private String postalCode;
    private String country;
    private String countryCode;
    private int countryGeonameId;
    private boolean countryIsEu;
    private String continent;
    private String continentCode;
    private int continentGeonameId;
    private double longitude;
    private double latitude;
    private Security security;
    private Time timezone;
    private Flag flag;
    private Currency currency;
    private Connect connection;

    // Getters and setters
    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCityGeonameId() {
        return cityGeonameId;
    }

    public void setCityGeonameId(int cityGeonameId) {
        this.cityGeonameId = cityGeonameId;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getRegionIsoCode() {
        return regionIsoCode;
    }

    public void setRegionIsoCode(String regionIsoCode) {
        this.regionIsoCode = regionIsoCode;
    }

    public int getRegionGeonameId() {
        return regionGeonameId;
    }

    public void setRegionGeonameId(int regionGeonameId) {
        this.regionGeonameId = regionGeonameId;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public int getCountryGeonameId() {
        return countryGeonameId;
    }

    public void setCountryGeonameId(int countryGeonameId) {
        this.countryGeonameId = countryGeonameId;
    }

    public boolean isCountryIsEu() {
        return countryIsEu;
    }

    public void setCountryIsEu(boolean countryIsEu) {
        this.countryIsEu = countryIsEu;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getContinentCode() {
        return continentCode;
    }

    public void setContinentCode(String continentCode) {
        this.continentCode = continentCode;
    }

    public int getContinentGeonameId() {
        return continentGeonameId;
    }

    public void setContinentGeonameId(int continentGeonameId) {
        this.continentGeonameId = continentGeonameId;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public Security getSecurity() {
        return security;
    }

    public void setSecurity(Security security) {
        this.security = security;
    }

    public Time getTimezone() {
        return timezone;
    }

    public void setTimezone(Time timezone) {
        this.timezone = timezone;
    }

    public Flag getFlag() {
        return flag;
    }

    public void setFlag(Flag flag) {
        this.flag = flag;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Connect getConnection() {
        return connection;
    }

    public void setConnection(Connect connection) {
        this.connection = connection;
    }
}

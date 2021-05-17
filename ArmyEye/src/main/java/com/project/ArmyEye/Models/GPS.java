package com.project.ArmyEye.Models;

import java.time.ZonedDateTime;
import java.util.Date;

public class GPS {
    public String TimestampUTC;
    public String Timestampms;
    public String GPStime;
    public String Latitude;
    public String Longitude;
    public String Altitude;
    
    public GPS(String timestampUTC, String timestampms, String gPStime, String latitude, String longitude, String altitude) {
		super();
		TimestampUTC = timestampUTC;
		Timestampms = timestampms;
		GPStime = gPStime;
		Latitude = latitude;
		Longitude = longitude;
		Altitude = altitude;
	}

	public GPS() {

	}

	public String getTimestampUTC() {
		return TimestampUTC;
	}
	public void setTimestampUTC(String timestampUTC) {
		TimestampUTC = timestampUTC;
	}
	public String getTimestampms() {
		return Timestampms;
	}
	public void setTimestampms(String timestampms) {
		Timestampms = timestampms;
	}
	public String getGPStime() {
		return GPStime;
	}
	public void setGPStime(String gPStime) {
		GPStime = gPStime;
	}
	public String getLatitude() {
		return Latitude;
	}
	public void setLatitude(String latitude) {
		Latitude = latitude;
	}
	public String getLongitude() {
		return Longitude;
	}
	public void setLongitude(String longitude) {
		Longitude = longitude;
	}
	public String getAltitude() {
		return Altitude;
	}
	public void setAltitude(String altitude) {
		Altitude = altitude;
	}
	
	@Override
	public String toString() {
		return "Comp1 [getTimestampUTC()=" + getTimestampUTC() + ", getTimestampms()=" + getTimestampms()
				+ ", getGPStime()=" + getGPStime() + ", getLatitude()=" + getLatitude() + ", getLongitude()="
				+ getLongitude() + ", getAltitude()=" + getAltitude() + "]";
	}
}

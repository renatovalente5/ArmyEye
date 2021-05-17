package com.project.ArmyEye.Models;

import java.util.Date;

public class GPS {
    public Date TimestampUTC;
    public long Timestampms;
    public Date GPStime;
    public double Latitude;
    public double Longitude;
    public double Altitude;
    
    public GPS(Date timestampUTC, long timestampms, Date gPStime, double latitude, double longitude, double altitude) {
		super();
		TimestampUTC = timestampUTC;
		Timestampms = timestampms;
		GPStime = gPStime;
		Latitude = latitude;
		Longitude = longitude;
		Altitude = altitude;
	}
    
	public Date getTimestampUTC() {
		return TimestampUTC;
	}
	public void setTimestampUTC(Date timestampUTC) {
		TimestampUTC = timestampUTC;
	}
	public long getTimestampms() {
		return Timestampms;
	}
	public void setTimestampms(long timestampms) {
		Timestampms = timestampms;
	}
	public Date getGPStime() {
		return GPStime;
	}
	public void setGPStime(Date gPStime) {
		GPStime = gPStime;
	}
	public double getLatitude() {
		return Latitude;
	}
	public void setLatitude(double latitude) {
		Latitude = latitude;
	}
	public double getLongitude() {
		return Longitude;
	}
	public void setLongitude(double longitude) {
		Longitude = longitude;
	}
	public double getAltitude() {
		return Altitude;
	}
	public void setAltitude(double altitude) {
		Altitude = altitude;
	}
	
	@Override
	public String toString() {
		return "GPS [getTimestampUTC()=" + getTimestampUTC() + ", getTimestampms()=" + getTimestampms()
				+ ", getGPStime()=" + getGPStime() + ", getLatitude()=" + getLatitude() + ", getLongitude()="
				+ getLongitude() + ", getAltitude()=" + getAltitude() + "]";
	}
}

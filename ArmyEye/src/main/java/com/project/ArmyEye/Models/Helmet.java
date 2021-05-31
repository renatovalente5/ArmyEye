package com.project.ArmyEye.Models;

import javax.persistence.*;

@Entity
@Table (name = "Helmet")
public class Helmet
{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;


	public String TimestampUTC;
	public String Timestampms;
	public String Altitude;
	public String CO;
	public String NO2;
	public String Environmentaltemperature;
	public String Atmosphericpressure;
	public String Humidity;
	public String Luminosity;
	public String Battery;


	public Helmet(String timestampUTC, String timestampms, String altitude, String CO, String NO2, String environmentaltemperature, String atmosphericpressure, String humidity, String luminosity, String battery) {
		TimestampUTC = timestampUTC;
		Timestampms = timestampms;
		Altitude = altitude;
		this.CO = CO;
		this.NO2 = NO2;
		Environmentaltemperature = environmentaltemperature;
		Atmosphericpressure = atmosphericpressure;
		Humidity = humidity;
		Luminosity = luminosity;
		Battery = battery;
	}

	public Helmet() {

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

	public String getAltitude() {
		return Altitude;
	}

	public void setAltitude(String altitude) {
		Altitude = altitude;
	}

	public String getCO() {
		return CO;
	}

	public void setCO(String CO) {
		this.CO = CO;
	}

	public String getNO2() {
		return NO2;
	}

	public void setNO2(String NO2) {
		this.NO2 = NO2;
	}

	public String getEnvironmentaltemperature() {
		return Environmentaltemperature;
	}

	public void setEnvironmentaltemperature(String environmentaltemperature) {
		Environmentaltemperature = environmentaltemperature;
	}

	public String getAtmosphericpressure() {
		return Atmosphericpressure;
	}

	public void setAtmosphericpressure(String atmosphericpressure) {
		Atmosphericpressure = atmosphericpressure;
	}

	public String getHumidity() {
		return Humidity;
	}

	public void setHumidity(String humidity) {
		Humidity = humidity;
	}

	public String getLuminosity() {
		return Luminosity;
	}

	public void setLuminosity(String luminosity) {
		Luminosity = luminosity;
	}

	public String getBattery() {
		return Battery;
	}

	public void setBattery(String battery) {
		Battery = battery;
	}

	@Override
	public String toString() {
		return "Helmet{" +
				"TimestampUTC='" + TimestampUTC + '\'' +
				", Timestampms='" + Timestampms + '\'' +
				", Altitude='" + Altitude + '\'' +
				", CO='" + CO + '\'' +
				", NO2='" + NO2 + '\'' +
				", Environmentaltemperature='" + Environmentaltemperature + '\'' +
				", Atmosphericpressure='" + Atmosphericpressure + '\'' +
				", Humidity='" + Humidity + '\'' +
				", Luminosity='" + Luminosity + '\'' +
				", Battery='" + Battery + '\'' +
				'}';
	}
}

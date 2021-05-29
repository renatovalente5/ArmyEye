package com.project.ArmyEye.Models;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "Others")
public class VitalJacket_others
{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	public Date TimestampUTC;
    public long Timestampms;
    public double HR;
    public double RR;
    public double Bodytemperature;
    public double Battery;
	
    
    public VitalJacket_others(Date timestampUTC, long timestampms, double hR, double rR, double bodytemperature,
			double battery) {
		super();
		TimestampUTC = timestampUTC;
		Timestampms = timestampms;
		HR = hR;
		RR = rR;
		Bodytemperature = bodytemperature;
		Battery = battery;
	}

	public VitalJacket_others() {

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


	public double getHR() {
		return HR;
	}


	public void setHR(double hR) {
		HR = hR;
	}


	public double getRR() {
		return RR;
	}


	public void setRR(double rR) {
		RR = rR;
	}


	public double getBodytemperature() {
		return Bodytemperature;
	}


	public void setBodytemperature(double bodytemperature) {
		Bodytemperature = bodytemperature;
	}


	public double getBattery() {
		return Battery;
	}


	public void setBattery(double battery) {
		Battery = battery;
	}


	@Override
	public String toString() {
		return "VitalJacket_others [getTimestampUTC()=" + getTimestampUTC() + ", getTimestampms()=" + getTimestampms()
				+ ", getHR()=" + getHR() + ", getRR()=" + getRR() + ", getBodytemperature()=" + getBodytemperature()
				+ ", getBattery()=" + getBattery() + "]";
	}
    
    
    
}
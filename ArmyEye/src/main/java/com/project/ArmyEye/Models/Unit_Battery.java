package com.project.ArmyEye.Models;

import java.util.Date;

public class Unit_Battery
{
    public Date TimestampUTC;
    public long Timestampms;
    public double Battery;
    
	public Unit_Battery(Date timestampUTC, long timestampms, double battery) {
		super();
		TimestampUTC = timestampUTC;
		Timestampms = timestampms;
		Battery = battery;
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

	public double getBattery() {
		return Battery;
	}

	public void setBattery(double battery) {
		Battery = battery;
	}

	@Override
	public String toString() {
		return "Unit_Battery [getTimestampUTC()=" + getTimestampUTC() + ", getTimestampms()=" + getTimestampms()
				+ ", getBattery()=" + getBattery() + "]";
	}
    
    
}
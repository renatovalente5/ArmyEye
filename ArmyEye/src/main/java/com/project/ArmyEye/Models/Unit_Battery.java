package com.project.ArmyEye.Models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "UnitBattery")
public class Unit_Battery
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	public Date TimestampUTC;
    public long Timestampms;
    public double Battery;
    
	public Unit_Battery(Date timestampUTC, long timestampms, double battery) {
		super();
		TimestampUTC = timestampUTC;
		Timestampms = timestampms;
		Battery = battery;
	}

	public Unit_Battery() {

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
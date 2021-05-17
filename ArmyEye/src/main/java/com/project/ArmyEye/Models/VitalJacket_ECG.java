package com.project.ArmyEye.Models;

public class VitalJacket_ECG
{
    public double ECG;

	public VitalJacket_ECG(double eCG) {
		super();
		ECG = eCG;
	}

	public double getECG() {
		return ECG;
	}

	public void setECG(double eCG) {
		ECG = eCG;
	}

	@Override
	public String toString() {
		return "VitalJacket_ECG [getECG()=" + getECG() + "]";
	}
    
    
}
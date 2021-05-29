package com.project.ArmyEye.Models;

import javax.persistence.*;

@Entity
@Table(name = "ECG")
public class VitalJacket_ECG
{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	public double ECG;

	public VitalJacket_ECG(double eCG) {
		super();
		ECG = eCG;
	}

	public VitalJacket_ECG() {

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
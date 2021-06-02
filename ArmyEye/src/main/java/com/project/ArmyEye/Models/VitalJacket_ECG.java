package com.project.ArmyEye.Models;

import javax.persistence.*;

@Entity
@Table(name = "ECG")
public class VitalJacket_ECG
{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	public String ECG;

	public VitalJacket_ECG(String eCG) {
		super();
		ECG = eCG;
	}

	public VitalJacket_ECG() {

	}

	public String getECG() {
		return ECG;
	}

	public void setECG(String eCG) {
		ECG = eCG;
	}

	@Override
	public String toString() {
		return "VitalJacket_ECG [getECG()=" + getECG() + "]";
	}
    
    
}
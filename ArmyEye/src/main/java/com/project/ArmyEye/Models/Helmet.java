package com.project.ArmyEye.Models;

import javax.persistence.*;

@Entity
@Table (name = "Helmet")
public class Helmet
{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;


	public String Name;
    public String Department;
    public String Manager;
    public int Salary;
    
    
	public Helmet(String name, String department, String manager, int salary) {
		super();
		Name = name;
		Department = department;
		Manager = manager;
		Salary = salary;
	}

	public Helmet() {

	}

	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getDepartment() {
		return Department;
	}
	public void setDepartment(String department) {
		Department = department;
	}
	public String getManager() {
		return Manager;
	}
	public void setManager(String manager) {
		Manager = manager;
	}
	public int getSalary() {
		return Salary;
	}
	public void setSalary(int salary) {
		Salary = salary;
	}
	
	@Override
	public String toString() {
		return "Helmet [getName()=" + getName() + ", getDepartment()=" + getDepartment() + ", getManager()="
				+ getManager() + ", getSalary()=" + getSalary() + "]";
	}

}

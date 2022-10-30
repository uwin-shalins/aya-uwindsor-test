package com.uwindsor.unnovate.aya.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "child_details")
public class ChildDetails {
	
	@Id
	private int id;
	private String Name;
	private String Dob;
	private String Gender;
	private String Doctor_Name;
	private String Doctor_Phone;
	
	
	@Override
    public String toString() {
        return "ChildDetails {" +
                " id= " + id +
                " name= " + Name 
                +" }";
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}

	public String getDob() {
		return Dob;
	}


	public void setDob(String dob) {
		Dob = dob;
	}


	public String getGender() {
		return Gender;
	}


	public void setGender(String gender) {
		Gender = gender;
	}


	public String getDoctor_Name() {
		return Doctor_Name;
	}


	public void setDoctor_Name(String doctor_Name) {
		Doctor_Name = doctor_Name;
	}


	public String getDoctor_Phone() {
		return Doctor_Phone;
	}


	public void setDoctor_Phone(String doctor_Phone) {
		Doctor_Phone = doctor_Phone;
	}

}

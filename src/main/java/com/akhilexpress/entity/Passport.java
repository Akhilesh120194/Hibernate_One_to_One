package com.akhilexpress.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="passport")
public class Passport {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="passport_id")
	private int passport_id;
	
	@Column(name="passport_number")
	private String passport_number;
	
	@OneToOne(mappedBy="passport",cascade=CascadeType.ALL)
	private Student student;
	
	public Passport() {
		
	}
	
	public Passport(int passport_id, String passport_number) {
		System.out.println("hi");
		this.passport_id = passport_id;
		this.passport_number = passport_number;
	}

	public int getPassport_id() {
		return passport_id;
	}
	public void setPassport_id(int passport_id) {
		this.passport_id = passport_id;
	}
	public String getPassport_number() {
		return passport_number;
	}
	public void setPassport_number(String passport_number) {
		this.passport_number = passport_number;
	}



	@Override
	public String toString() {
		return "Passport [passport_id=" + passport_id + ", passport_number=" + passport_number + "]";
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	

}

package com.akhilexpress.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="students")
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="student_name",length=70,nullable=false)
	private String name ;
	private long mobile;
	
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name="addressLine1",column=@Column(name="home_address_line1")),
		 @AttributeOverride(name="addressLine2",column=@Column(name="home_address_line2")),
		 @AttributeOverride(name="city",column=@Column(name="home_city"))
	})
	private Address homeAddress;
	
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name="addressLine1",column=@Column(name="hostel_address_line1")),
		 @AttributeOverride(name="addressLine2",column=@Column(name="hostel_address_line2")),
		 @AttributeOverride(name="city",column=@Column(name="hostel_city"))
	})
	private Address hostelAddress;

	
	

	public Student() {
		
	}
	
	public Student(int id, String name, long mobile) {
	
		this.id = id;
		this.name = name;
		this.mobile = mobile;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", mobile=" + mobile + ", homeAddress=" + homeAddress
				+ ", hostelAddress=" + hostelAddress + "]";
	}

	public Address getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}

	public Address getHostelAddress() {
		return hostelAddress;
	}

	public void setHostelAddress(Address hostelAddress) {
		this.hostelAddress = hostelAddress;
	}

	
	
	

}

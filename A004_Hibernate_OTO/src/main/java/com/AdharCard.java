package com;

import javax.persistence.*;

@Entity
@Table(name="adharcard")
public class AdharCard {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	String adharNo;
	
	@OneToOne(mappedBy = "adharCard",cascade = CascadeType.ALL)
	Citizen citizen;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdharNo() {
		return adharNo;
	}

	public void setAdharNo(String adharNo) {
		this.adharNo = adharNo;
	}

	public Citizen getCitizen() {
		return citizen;
	}

	public void setCitizen(Citizen citizen) {
		this.citizen = citizen;
	}
	
	
	
	
}

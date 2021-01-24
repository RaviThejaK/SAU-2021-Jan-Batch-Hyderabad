package hibernate.assignment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="Address")
@Setter
@Getter
@NoArgsConstructor
@Entity
public class Address {
	
	@Id
	@Column(name="AddressId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int AddressId;
	
	public int getAddressId() {
		return AddressId;
	}

	public void setAddressId(int addressId) {
		AddressId = addressId;
	}

	@Column(name="StreetName", length=25)
	private String streetName;
	
	@Column(name="Phone", length=15)
	private String city;

	@Column(name="Pincode")
	private int pincode;
	
	//
	public Address() {}
	
	public Address(String streetName, String city,int pincode)
	{
		this.streetName=streetName;
		this.city=city;
		this.pincode=pincode;
	}

	//
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Employee employee;
	

	//
	//Getters and Setters
	
	
	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
	
	
}

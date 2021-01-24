package hibernate.assignment.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="EmployeeTable")
@Setter
@Getter
@NoArgsConstructor
@Entity
public class Employee {
	
	@Id
	@Column(name="EmployeeId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int EmployeeId;
	
	@Column(name="firstname", length=25)
	private String FirstName;
	
	@Column(name="lastname", length=25)
	private String LastName;
	
	@Temporal(TemporalType.DATE)
	private Date joiningDate;
	
	//
	
	public Employee() {	}
	
	public Employee(String firstName, String lastName, Date joiningDate) {
		this.FirstName=firstName;
		this.LastName=lastName;
		this.joiningDate=joiningDate;
	}

	
	//Relations
	//1-1 Emp Det
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinTable(name = "emp_det_jointable")
	private EmployeeDetails employeeDetails;
	
	
	//1-m Address
	@OneToMany(cascade=CascadeType.ALL,targetEntity=hibernate.assignment.entity.Address.class)
	@JoinColumn
	private Set<Address> address = new HashSet<>();

	//n-m Courses
	@ManyToMany(cascade=CascadeType.ALL,targetEntity=hibernate.assignment.entity.Courses.class,mappedBy="employee")
	private List<Courses> courses = new ArrayList<>();


	
	//Getters and Setters
	
	public int getEmployeeId() {
		return EmployeeId;
	}

	public void setEmployeeId(int employeeId) {
		EmployeeId = employeeId;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	public EmployeeDetails getEmployeeDetails() {
		return employeeDetails;
	}

	public void setEmployeeDetails(EmployeeDetails employeeDetails) {
		this.employeeDetails = employeeDetails;
	}


	public Set<Address> getAddress() {
		return address;
	}

	public void setAddress(Set<Address> address) {
		this.address = address;
	}

	public List<Courses> getCourses() {
		return courses;
	}

	public void setCourses(List<Courses> courses) {
		this.courses = courses;
	}

	
	public void addAddress(Address address) {}

	
	
	
	
}

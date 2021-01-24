package hibernate.assignment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Table(name="EmployeeDetailsTable")
@Setter
@Getter
@NoArgsConstructor
@Entity
public class EmployeeDetails {

	
	@Id
	@Column(name="EmployeeId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int EmployeeId;
	
	@Column(name="Phone", length=25)
	private String Phone;
	
	@Column(name="EmailId", length=25)
	private String EmailId;
	
	//mapping
	@OneToOne(mappedBy="employeeDetails")
	@JoinColumn(name="EmpDId")
	private Employee employee;

	public void setEmployeeDetails(String Phone, String EmailId) {
		this.Phone=Phone;
		this.EmailId=EmailId;
	}
	
	
}

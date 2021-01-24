package hibernate.assignment.entity;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="CoursesTable")
@Setter
@Getter
@NoArgsConstructor
@Entity
public class Courses {
	
	
	@Id
	@Column(name="CourseId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int CourseId;
	
	@Column(name="coursename", length=25)
	private String CourseName;
	
	//
	
	public Courses(String CourseName)
	{
		this.CourseName=CourseName;
	}
	
	//mapping
	
	@ManyToMany
	private List<Employee> employee = new ArrayList<>();


	//
	

	public int getCourseId() {
		return CourseId;
	}

	public void setCourseId(int courseId) {
		CourseId = courseId;
	}

	public String getCourseName() {
		return CourseName;
	}

	public void setCourseName(String courseName) {
		CourseName = courseName;
	}

	public List<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}
	

}

package hibernate.assignment.demo;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.assignment.entity.Courses;
import hibernate.assignment.entity.Employee;
import hibernate.assignment.entity.EmployeeDetails;
import hibernate.assignment.entity.Address;


public class EmployeeDemo {

	public static void main(String[] args) {


	SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.addAnnotatedClass(EmployeeDetails.class)
				.addAnnotatedClass(Courses.class)
				.addAnnotatedClass(Address.class)
				.buildSessionFactory();
	
	Session session = sessionFactory.openSession();
	
	Employee employee = new Employee("Ravi","Theja",new Date());
	Employee employee2 = new Employee("Kolluru","Theja",new Date());
	Employee employee3 = new Employee("Kiran","Manam",new Date());
	
	EmployeeDetails details = new EmployeeDetails();
	details.setEmployeeDetails("9995559991","ravi@gmail.com");
	EmployeeDetails details2 = new EmployeeDetails();
	details2.setEmployeeDetails("9995559992","kolluru@gmail.com");
	
	employee.setEmployeeDetails(details);
	employee2.setEmployeeDetails(details2);
	
	Address address = new Address("street1","Hyderabad",12345);
	Address address2 = new Address("street2","Chennai",54321);
	//
	employee.getAddress().add(address);
	employee.getAddress().add(address2);
	
	
	
	//
	Courses course = new Courses("Java");
	Courses course2 = new Courses("Spring");
	Courses course3 = new Courses("Hibernate");
	
	course.getEmployee().add(employee);
	course.getEmployee().add(employee2);
	course2.getEmployee().add(employee2);
	course3.getEmployee().add(employee3);
	
	employee.getCourses().add(course);
	employee2.getCourses().add(course2);
	employee3.getCourses().add(course);
	employee3.getCourses().add(course3);
	
	
	try {
		session.beginTransaction();
		

		session.save(employee);
		session.save(employee2);
		session.save(employee3);
		
		session.save(details);
		session.save(details2);
		
//		session.save(address);
//		session.save(address2);
		//session.save(nses3);
//		
		session.getTransaction().commit();
		
//		Employee empFromDB = session.get(Employee.class,1);
//		System.out.println("DATA DB"+ empFromDB.getFirstName());
//		System.out.println("DATA DB"+ empFromDB.getSkillSet());
	
		}
	finally {
		session.close();
		sessionFactory.close();
	}
	
	}
}

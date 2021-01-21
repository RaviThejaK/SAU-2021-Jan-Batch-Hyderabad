
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Assignment {

	@CustomCapital(capital = "name")
	String name;
	@CustomCapital(capital = "review")
	String review;
	
	Date date;
	
	Assignment(String name, String review, Date date)
	{
		this.name=name;
		this.review=review;
		this.date=date;
	}

	Assignment(){}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	int id;
	
	public String getName() {
		return name;
	}
	@XmlElement
	public void setName(String name) {
		this.name = name;
	}
	public String getReview() {
		return review;
	}
	@XmlElement
	public void setReview(String review) {
		this.review = review;
	}
	public int getId() {
		return id;
	}
	@XmlAttribute
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Assignment [name=" + name + ", review=" + review + ", id=" + id + "]";
	}
	
	
	@Temporal(TemporalType.DATE)
	private Date joiningDate;

	public Date getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}
	
}
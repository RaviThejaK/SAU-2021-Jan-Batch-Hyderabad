
import javax.xml.bind.annotation.XmlElement;

class MyException extends Exception 
{ 
    public MyException(String s) 
    { 
        super(s); 
    } 
} 

public class Student {

	int marks;
	int roll;
	String subject;
	
	public int getMarks() {
		return marks;
	}
	
	@XmlElement
	public void setMarks(int marks) {
		try {
			if(marks>0)
				this.marks = marks;
			else
				throw new MyException("Marks can't be negative");
		}
		catch (MyException e)
		{
			System.out.println(e);
		}
		
		
	}
	public int getRoll() {
		return roll;
	}
	
	@XmlElement
	public void setRoll(int roll) {
		try {
			if(roll>0)
				this.roll = roll;
			else
				throw new MyException("Roll No. can't be negative");
		}
		catch (MyException e)
		{
			System.out.println(e);
		}
		
	}
	public String getSubject() {
		return subject;
	}
	
	@XmlElement
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	
	@Override
	public String toString() {
		return "Student [marks=" + marks + ", roll=" + roll + ", subject=" + subject + "]";
	}
	
	
	
}


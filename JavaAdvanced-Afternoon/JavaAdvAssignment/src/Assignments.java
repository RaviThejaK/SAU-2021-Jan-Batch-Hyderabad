
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Assignments {
	
	List<Assignment> assignment;

	
	public List<Assignment> getAssignment() {
		return assignment;
	}
	@XmlElement
	public void setAssignment(List<Assignment> assignment) {
		this.assignment = assignment;
	}


	@Override
	public String toString() {
		return "Assignments [assignments=" + assignment + "]";
	}
}

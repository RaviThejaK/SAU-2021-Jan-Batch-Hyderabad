import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLStreamException;

import java.io.*;
import java.io.File;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) throws IOException, JAXBException, XMLStreamException {
		
		try {
			
			//XML to Java
		File file = new File("./src/student.xml");
		JAXBContext jaxbContent = JAXBContext.newInstance(Students.class);
		Unmarshaller jaxbUnmarshaller = jaxbContent.createUnmarshaller();
		Students students = (Students) jaxbUnmarshaller.unmarshal(file);
		System.out.println(students);
		
		
		//Calculating Aggregate
		HashMap<Integer,Integer> mp = new HashMap<Integer,Integer>();
		mp=aggregateMarks(students);
		
		for (int i : mp.values()) {
			  System.out.println(i);
			}
		
		//Serialization
		Serialize(mp);

		
		}
		
		catch(Exception e)
		{
			System.out.println(e);
		}

			
	}

	//Serialization
	
	private static void Serialize(HashMap<Integer, Integer> mp) {
		try{  
			  FileOutputStream fout=new FileOutputStream("SerializedFile.txt");  
			  ObjectOutputStream out=new ObjectOutputStream(fout);  
			  out.writeObject(mp);  
			  out.flush();  
			  out.close();  
			  System.out.println("Serialized Succesfully");  
		   }
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

	
	//Calculating Aggregate
	
	private static HashMap<Integer, Integer> aggregateMarks(Students students) {
		HashMap<Integer, Integer> hmp = new HashMap<Integer,Integer>();
		for(Student s: students.student)
		{
			if(hmp.containsKey(s.getRoll()))
			hmp.put(s.getRoll(),hmp.get(s.getRoll())+s.getMarks());
			else
				hmp.put(s.getRoll(), s.getMarks());
		}
		
		return hmp;
	}

}

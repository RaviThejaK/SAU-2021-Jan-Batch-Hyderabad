import java.io.File;
import java.io.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLStreamException;

public class Information {

		public static void main(String[] args) throws IOException, JAXBException, XMLStreamException {
			
			try {
				//XML to Java using JAXB
			File file = new File("./src/assignment.xml");
			JAXBContext jaxbContent = JAXBContext.newInstance(Assignments.class);
			Unmarshaller jaxbUnmarshaller = jaxbContent.createUnmarshaller();
			Assignments assignments = (Assignments) jaxbUnmarshaller.unmarshal(file);
			System.out.println(assignments);
			}
			
			catch(Exception e)
			{
				System.out.println(e);
			}


	}

}

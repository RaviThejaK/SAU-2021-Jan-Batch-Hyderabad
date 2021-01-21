
import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLProcessingExample {

	public static void main(String[] args) {
		XMLProcessingExample xmlProcessingExample = new XMLProcessingExample();
//		xmlProcessingExample.domParser();
		xmlProcessingExample.jaxBParser(); 
	}

	void domParser() {
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(new File("./src/com/accolite/au/xmlprocessing/assignment.xml"));
		
			System.out.println(doc.getDocumentElement().getNodeName());
            
		    NodeList nList = doc.getElementsByTagName("assignment");
		    for (int temp = 0; temp < nList.getLength(); temp++) {

		        Node nNode = nList.item(temp);
		                
		        if (nNode.getNodeType() == Node.ELEMENT_NODE) {
		            Element eElement = (Element) nNode;
		            System.out.println("\nAssignment: " + eElement.getAttribute("id"));
		            System.out.println("Name : " + eElement.getElementsByTagName("name").item(0).getTextContent());
		            System.out.println("Review : " + eElement.getElementsByTagName("review").item(0).getTextContent());
		        }
		    }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	void jaxBParser() {
		try {
			File file = new File("./src/com/accolite/au/xmlprocessing/assignment.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Assignments.class);

	        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
	        Assignments assignments = (Assignments) jaxbUnmarshaller.unmarshal(file);
	        System.out.println(assignments);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}

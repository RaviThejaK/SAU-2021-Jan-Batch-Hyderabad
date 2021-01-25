

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Freaquency {

	public static void main(String[] args) throws IOException  {
		long startTime = System.currentTimeMillis();
		
		File file = new File("C:\\Users\\Ravi Theja Kolluru\\eclipse-workspace\\MultiThreadingAssignment\\Book.txt"); 
        FileInputStream fileStream = new FileInputStream(file); 
        InputStreamReader input = new InputStreamReader(fileStream); 
        BufferedReader reader = new BufferedReader(input);
		
        int tCount=1;
        int countWord = 0; 
        int sentenceCount = 0; 
        int characterCount = 0; 
        int paragraphCount = 1; 
        int whitespaceCount = 0; 
        String line; 
     
//        while((line = reader.readLine()) != null) {
//            countWord += line.split(" ").length;
//    	
//    }
    

        
        
	    while((line = reader.readLine()) != null) {
		if(line.equals("")) 
        { 
            paragraphCount++; 
        } else { 
            characterCount += line.length(); 
              
            String[] wordList = line.split("\\s+"); 
              
            countWord += wordList.length; 
            whitespaceCount += countWord -1; 
              
            String[] sentenceList = line.split("[!?.:]+"); 
              
            sentenceCount += sentenceList.length; 
        } 
	}
	    
	    System.out.println("Generic Freaquency calculator Method");
		
	    
	    System.out.println("Total word count = " + countWord); 
        System.out.println("Total number of sentences = " + sentenceCount); 
        System.out.println("Total number of characters = " + characterCount); 
        System.out.println("Number of paragraphs = " + paragraphCount); 
       
//        System.out.println("Number of Threads used"+tCount);
//		System.out.println("Total Number of Words found : "+countWord);
//		
		long endTime = System.currentTimeMillis();
				
		System.out.println("Time taken in milli seconds"+ (endTime-startTime));
		
	}

	
}

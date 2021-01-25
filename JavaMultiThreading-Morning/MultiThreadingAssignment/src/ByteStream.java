import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Multithreading extends Thread 
{ 
	
	private final byte[] chunk;
    	
	    int countWord = 0; 
	    int sentenceCount = 0; 
	    int characterCount = 0; 
	    int paragraphCount = 1; 
	    
	
	public Multithreading (byte[] chunk) {
        this.chunk = chunk;
       }
	
	@Override
    public void run() 
    { 
    	try {
       	 String line; 
   
       	InputStream is  = new ByteArrayInputStream(chunk);
       	BufferedReader reader = new BufferedReader(new InputStreamReader(is));
 		
       	while((line = reader.readLine()) != null) {
			if(line.equals("")) 
	        { 
	            paragraphCount++; 
	        } else { 
	            characterCount += line.length(); 
	              
	            String[] wordList = line.split("\\s+"); 
	              
	            countWord += wordList.length; 
	              
	            String[] sentenceList = line.split("[!?.:]+"); 
	              
	            sentenceCount += sentenceList.length; 
	        } 
		}

    	    
       }  
        catch (Exception e) 
        { 
            System.out.println("Error Occured");
        } 

    }
    
    public int[] count() {
    	int[] counta = new int[4];
    	counta[0]= countWord; 
    	counta[1]= sentenceCount; 
    	counta[2]=  characterCount ; 
    	counta[3]=  paragraphCount ; 
	    
    	
    	return counta;
    }
} 




public class ByteStream {

	public static void main(String[] args) throws InterruptedException, IOException {

		byte[] encoded = Files.readAllBytes(Paths.get("C:\\Users\\Ravi Theja Kolluru\\eclipse-workspace\\MultiThreadingAssignment\\Book.txt"));
		
		long startTime = System.currentTimeMillis();
		
		int tCount =10;
		
		int x = (encoded.length/tCount);  // chunk size
		int len = encoded.length;
		int counter = 0;//debug

		//int totalWords=0;
		int[] totalWords = new int[4];
		
		byte[][] newArray = new byte[tCount][];
		for (int i = 0; i < len; i += x)
		    newArray[counter++] = Arrays.copyOfRange(encoded, i, i+x);
	
		Multithreading[] threads = new Multithreading[tCount];
		
		for(int i=0;i<tCount;i++)
		{
		threads[i] = new Multithreading(newArray[i]);
		}

		for(int i=0;i<tCount;i++)
		{
		threads[i].run();
		threads[i].join();
		}
		
		for(int i=0;i<tCount;i++)
		{
		totalWords[0]+=threads[i].count()[0];
		totalWords[1]+=threads[i].count()[1];
		totalWords[2]+=threads[i].count()[2];
		totalWords[3]+=threads[i].count()[3];
		}
		
	    System.out.println("Complete Using the Bystream Method");
		System.out.println("Number of Threads used"+tCount);
		
	    
	    System.out.println("Total word count = " + totalWords[0]); 
        System.out.println("Total number of sentences = " + totalWords[1]); 
        System.out.println("Total number of characters = " + totalWords[2]); 
        System.out.println("Number of paragraphs = " + totalWords[3]); 

		
		
		
//		System.out.println("Using Bystream Method");
		System.out.println("Number of Threads used"+tCount);
//		System.out.println("Total Number of Words found : "+totalWords);
		
		long endTime = System.currentTimeMillis();
				
		System.out.println("Time taken in milli seconds"+ (endTime-startTime));
		
	}

}




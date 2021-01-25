import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

class MultithreadingDemo extends Thread 
{ 
	
	private final File file;
    
	
	  int countWord = 0; 
	    int sentenceCount = 0; 
	    int characterCount = 0; 
	    int paragraphCount = 1; 
	    int whitespaceCount = 0; 
	   
	
	public MultithreadingDemo (File file) {
        this.file = file;
        
    }
	
	
    public void run() 
    { 
    	try {
       	 String line; 
   
       	 
       	 FileInputStream fileStream = new FileInputStream(file); 
       	    InputStreamReader input = new InputStreamReader(fileStream); 
       	    BufferedReader reader = new BufferedReader(input);
       		
//    	    while((line = reader.readLine()) != null) {
//	            countWord += line.split(" ").length;
//	
       	    
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




public class FileSplit {

	public static void main(String[] args) throws InterruptedException, IOException {

		File file = new File("C:\\Users\\Ravi Theja Kolluru\\eclipse-workspace\\MultiThreadingAssignment\\Book.txt"); 
		int tCount = 10; // no of threads
		
		//int totalWords=0;
				int[] totalWords = new int[4];
				
		long startTime = System.currentTimeMillis();
		
		List<File> fileList = new ArrayList<>();
		
		Filesx2 f = new Filesx2();
		
		fileList = f.splitFile( file, tCount);		
		
		
		MultithreadingDemo[] threads = new MultithreadingDemo[tCount];
		
		for(int i=0;i<tCount;i++)
		{
		threads[i] = new MultithreadingDemo(fileList.get(i));
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
		
	    System.out.println("Complete Using the FileSplit Method");
		System.out.println("Number of Threads used"+tCount);
		
	    
	    System.out.println("Total word count = " + totalWords[0]); 
        System.out.println("Total number of sentences = " + totalWords[1]); 
        System.out.println("Total number of characters = " + totalWords[2]); 
        System.out.println("Number of paragraphs = " + totalWords[3]); 

		long endTime = System.currentTimeMillis();
				
		System.out.println("Time taken in milli seconds "+ (endTime-startTime));
		
	}

}



class Filesx2{

public List<File> splitFile(File file, int count) throws IOException {
    int counter =1;
    List<File> files = new ArrayList<File>();
    int sizeOfChunk = (int) (file.length()/(count));
    String eof = System.lineSeparator();
    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        String name = file.getName();
        String line = br.readLine();
        while (line != null) {
            File newFile = new File(file.getParent(), name + "."
                    + String.format("%03d", counter++));
            try (OutputStream out = new BufferedOutputStream(new FileOutputStream(newFile))) {
                int fileSize = 0;
                while (line != null) {
                    byte[] bytes = (line + eof).getBytes(Charset.defaultCharset());
                    if (fileSize + bytes.length > sizeOfChunk)
                        break;
                    out.write(bytes);
                    fileSize += bytes.length;
                    line = br.readLine();
                }
            }
            files.add(newFile);
        }
    }
    return files;
}

}

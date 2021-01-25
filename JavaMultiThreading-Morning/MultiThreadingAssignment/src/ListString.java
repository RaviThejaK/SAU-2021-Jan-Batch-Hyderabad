import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

class Multithreading2 extends Thread 
{ 
	
	private List<String> chunk;
    	
	    int countWord = 0; 
	    int sentenceCount = 0; 
	    int characterCount = 0; 
	    int paragraphCount = 1; 
	    int whitespaceCount = 0; 
	   
	
	public Multithreading2 (List<String> chunk) {
        this.chunk = chunk;
       }
	
	@Override
    public void run() 
    { 
    	try {

    		for (String s : chunk) {
                countWord += s.split(" ").length;
            }
    		
    		
    		    		
    		
    		
    		
       }  
        catch (Exception e) 
        { 
            System.out.println("Error Occured");
        } 

    }
    
    public int count() {
    	return countWord;
    }
} 




public class ListString {

	public static void main(String[] args) throws InterruptedException, IOException {


        List<String> string = Files.readAllLines(Paths.get("C:\\Users\\Ravi Theja Kolluru\\eclipse-workspace\\MultiThreadingAssignment\\Book.txt"));
        
		long startTime = System.currentTimeMillis();
		
		int tCount =1;
		
		int x = (string.size()/tCount);  // chunk size
		int offset =0;
		int totalWords=0;
			
		Multithreading2[] threads = new Multithreading2[tCount];
		
		for(int i=1;i<=tCount;i++)
		{
			List<String> chunks = string.subList(offset, x * i);
            threads[i-1] = new Multithreading2(chunks);
            offset = x * i;
            }

		for(int i=0;i<tCount;i++)
		{
		threads[i].run();
		threads[i].join();
		}
		
		for(int i=0;i<tCount;i++)
		{
		totalWords+=threads[i].count();
		}
		
		
		System.out.println("Using List String Method");
		System.out.println("Number of Threads used"+tCount);
		System.out.println("Total Number of Words found : "+totalWords);
		
		long endTime = System.currentTimeMillis();
				
		System.out.println("Time taken in milli seconds"+ (endTime-startTime));
		
	}

}




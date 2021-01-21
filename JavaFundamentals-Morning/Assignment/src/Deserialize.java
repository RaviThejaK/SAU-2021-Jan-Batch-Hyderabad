import java.io.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.opencsv.CSVWriter;

import java.lang.*;


public class Deserialize {

	public static void main(String[] args) {
		try{  
			
			//Deserializing
			  ObjectInputStream in=new ObjectInputStream(new FileInputStream("SerializedFile.txt"));  
			  HashMap<Integer,Integer> mp2 = (HashMap<Integer,Integer>)in.readObject();
			  System.out.println(mp2);  
			  in.close(); 
			  
			  
			  //Sorting the data
			  List<HashMap.Entry<Integer, Integer> > list = 
		               new LinkedList<HashMap.Entry<Integer, Integer> >(mp2.entrySet()); 
		  
			  Collections.sort(list, new Comparator<Map.Entry<Integer, Integer> >() { 
		            public int compare(Map.Entry<Integer, Integer> o1,  
		                               Map.Entry<Integer, Integer> o2) 
		            { 
		                return (o2.getValue().compareTo(o1.getValue())); 
		            } 
		        });
	        
			  HashMap<Integer,Integer> mp3 = new LinkedHashMap<Integer,Integer>();
			  for (Entry<Integer, Integer> l : list) { 
		            mp3.put(l.getKey(), l.getValue()); 
		        } 
		       
			  
			  //Sending Java to Excel
			  	
			  Set<Integer> keyset = mp3.keySet();
			  int rownum = 0;
			  int rank=1;
			  XSSFWorkbook workbook = new XSSFWorkbook(); 
			  XSSFSheet sheet = workbook.createSheet("Students Rank"); 
			  
			  Row rowh = sheet.createRow(rownum++); 
	            Cell cellh1 = rowh.createCell(0); 
	            Cell cellh2 = rowh.createCell(1); 
	            Cell cellh3 = rowh.createCell(2); 
	            cellh1.setCellValue((String)"Rank");
	            cellh2.setCellValue((String)"Roll");
	            cellh3.setCellValue((String)"Marks");
	              
		  
			  for(Integer key : keyset) { 
		            // this creates a new row in the sheet 
		            Row row = sheet.createRow(rownum++); 
		            Cell cell1 = row.createCell(0); 
		            Cell cell2 = row.createCell(1); 
		            Cell cell3 = row.createCell(2); 
	                
		            Integer value = mp2.get(key);
		            
		            cell1.setCellValue((Integer)rank);
		            cell2.setCellValue((Integer)key);
		            cell3.setCellValue((Integer)value);
		            
		            rank++;
		            if(rank>5)
		            	break;
		             
		        } 
		        try { 
		            FileOutputStream out = new FileOutputStream(new File("Top5.xlsx")); 
		            workbook.write(out); 
		            out.close(); 
		            System.out.println("Successfully sent data to excel"); 
		        } 
		        catch (Exception e) { 
		            e.printStackTrace(); 
		        } 
			  
			
			  }
		catch(Exception e)
		{
			System.out.println(e);
			}  
	}

}

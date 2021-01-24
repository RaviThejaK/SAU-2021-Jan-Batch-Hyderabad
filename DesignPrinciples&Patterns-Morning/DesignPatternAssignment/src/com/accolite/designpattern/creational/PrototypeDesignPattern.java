package com.accolite.designpattern.creational;



import java.util.HashMap; 
import java.util.Map; 
  
  
abstract class Fruits implements Cloneable 
{ 
      
    protected String fruits; 
       
    abstract void buy(); 
       
    public Object clone() 
    { 
        Object clone = null; 
        try 
        { 
            clone = super.clone(); 
        }  
        catch (CloneNotSupportedException e)  
        { 
            e.printStackTrace(); 
        } 
        return clone; 
    } 
} 
  
class Apple extends Fruits 
{ 
    public Apple()  
    { 
        this.fruits = "Apple"; 
    } 
   
    @Override
    void buy()  
    { 
        System.out.println("Apple added to basket"); 
    } 
      
} 
  
class Orange extends Fruits{ 
   
	 public Orange()  
	    { 
	        this.fruits = "Orange"; 
	    } 
	   
	    @Override
	    void buy()  
	    { 
	        System.out.println("Orange added to basket"); 
	    }  
} 
   
class Market { 
   
    private static Map<String, Fruits> fruitsMap = new HashMap<String, Fruits>();  
       
    static 
    { 
    	fruitsMap.put("orange", new Orange()); 
    	fruitsMap.put("apple", new Apple()); 
    } 
       
    public static Fruits getFruits(String fruit) 
    { 
        return (Fruits) fruitsMap.get(fruit).clone(); 
    } 
} 
  
  
// Driver class 
//class Prototype 
//{ 
//    public static void main (String[] args) 
//    { 
//        
//    } 
//} 






public class PrototypeDesignPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  Market.getFruits("orange").buy(); 
	        Market.getFruits("apple").buy(); 
	        Market.getFruits("apple").buy(); 
	      
	}

}



//@Override
//public Object clone() throws CloneNotSupportedException {
//  List<String> cloneList = new ArrayList<String>();
//  
//  for(String s : this.getFruitsList()) {
//    cloneList.add(s);
//  }
//  
//  return new Fruits(cloneList);
//}
package com.accolite.designpattern.structural;

import java.util.HashMap;

interface Fruits {
	   void buy();
	}

class Apple implements Fruits {
	   private String type;
	   
	   public Apple (String type){
	      this.type = type;		
	   }


	   @Override
	   public void buy() {
	      System.out.println("Apple added to basket");
	   }
	}

class FruitsFactory {

	   private static final HashMap appleMap = new HashMap();

	   public static Fruits getApple(String type) {
	      Apple apple = (Apple)appleMap.get(type);

	      if(apple == null) {
	    	  apple = new Apple(type);
	         appleMap.put(type, apple);
	         System.out.println("Adding " + type+ " apple to map");
	      }
	      return apple;
	   }
	}

public class Flyweight {

	public static void main(String[] args) {
		Apple apple = (Apple)FruitsFactory.getApple("Shimla");
		Apple apple2 = (Apple)FruitsFactory.getApple("Chile");
		Apple apple3 = (Apple)FruitsFactory.getApple("Green-mael");
		
		
		
		
		
		
		
	}

}

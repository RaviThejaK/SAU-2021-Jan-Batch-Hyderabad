class SingletonClass {

   private static SingletonClass singletonObj = new SingletonClass( );
   private SingletonClass() { }
   public static SingletonClass getInstance( ) {
      return singletonObj;
   }

   protected static void Method1( ) {
      System.out.println("This is a singleton class");
   }
}



public class SingletonSample {

	public static void main(String[] args) {
		  SingletonClass obj = SingletonClass.getInstance( );
	      obj.Method1( );
	}

}

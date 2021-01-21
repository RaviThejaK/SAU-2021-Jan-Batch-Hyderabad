import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class Annotations implements Runnable {

	public static void main(String[] args) {
		
		
		Annotations annotations = new Annotations();
		
		Date date = new Date();
		LocalDateTime ldt3 = LocalDateTime.ofInstant(date.toInstant(), ZoneId.of("Asia/Kolkata"));
		System.out.println("Old Date to LocalDateTime: " + ldt3);
		String a = "Java Master";
		String b = "Upcomming";
		Assignment assignment = new Assignment(a,b,date );
		
		annotations.customAnnotation(a,b);
	}
	
	@Override
	public void run() {
		// marking method with @Override ensures the we never have a 
		// scenario where sub class doesn't have expected method
	}


	private void customAnnotation(String a, String b) {
		
		
		try {
			System.out.println(CapitalizeName.capital(a));
			System.out.println(CapitalizeName.capital(b));
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}
	
	

}

public class enum_ex {
	enum Month {Jan, Feb, Mar, Apr, May, Jun, Jul, Aug, Sep, Oct, Nov, Dec}
	
	public static void main(String[] args) {
		//Month m;
		for (Month m:java.util.EnumSet.range(Month.Jun, Month.Aug)) {
			System.out.println("summer includes: " + m);	
		}
		System.out.println("*********");
		for (Month m:Month.values()) {
			System.out.println("summer includes: " + m);	
		}		
	}
}
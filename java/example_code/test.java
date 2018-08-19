public class test {
	public static void main(String[] args) {
			int i = 15;
			Integer myInt = new Integer(i);
			
			String s = myInt.toString();
			// System.out.println(s);
			s = myInt.toHexString(15);
			// System.out.println(s);
			
			i = Integer.parseInt("25662");
			i+=3;
			// System.out.println(i);
	}	
}
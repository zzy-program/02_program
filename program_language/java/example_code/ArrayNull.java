public class ArrayNull {
	public static void main(String argv[]) {
		System.out.println("test");
		int[] a = new int[0];
		int[] b = null;
		if(a==null) {
			System.out.println("a "+"is null");
		}
		if(b==null) {
			System.out.println("b "+"is null");
		}
		// a[0] = 5; // runtime error
		System.out.println("a's length is "+a.length);
		// System.out.println("b's length is "+b.length);
	}
}

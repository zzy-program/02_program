public class exception1{
	public static void main(String[] args) throws Exception{
		MyException e1 = new MyException();
		System.out.println("exception test");
		try{
			throw e1;
		} catch (MyException e) {
			System.out.println("in exception1 main, caught MyException");
			System.out.println(e.a(5));
		}	
	}
}
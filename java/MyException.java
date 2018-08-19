public class MyException extends Exception{
  public MyException(){System.out.println("MyException() construction");}
  public MyException(String smg){
		System.out.println("MyException");
	}
	public int a(int a) {
		return a;
	}
}
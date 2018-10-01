class thread2 extends Thread{
	thread2(String s) {
		super(s);
	}
	
	public void run() {
		String s = getName();
		System.out.println(s+": running");	
	}
	
	public static void main(String args[]) {
		new thread2("test1").start();
		new thread2("test2").start();
	}	
}
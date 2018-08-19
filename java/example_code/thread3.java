class Coffee extends Thread {
	public void run() {
		while(true) {
			System.out.println("I like coffee");	
			yield();
		}	
	}	
}

class Tea extends Thread {
	public void run() {
		while(true) {
			System.out.println("I like tea");	
			yield();
		}	
	}	
}

class thread3 {
	public static void main(String args[]) {
		Coffee t1 = new Coffee();
		t1.start();
		new Tea().start();
	}	
}
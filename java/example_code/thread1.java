class ExdOfThread extends Thread {
	public void run() {
		String s = getName();
		System.out.println(s+" Extension of Thread running");
		try {
			sleep(1000);
			System.out.println("ExdOfThread: after sleep");
		} 
		catch(InterruptedException ie) {
			return;
		}
	}	
}

class ImpOfRunnable implements Runnable {
	public void run() {
		Thread t = Thread.currentThread();
		String s = t.getName();
		System.out.println(s+" Implementation of Runnable running");
		try {
			Thread.sleep(1000);
			System.out.println("ImpOfRunnable: after sleep");
		}
		catch (InterruptedException ie) {
			return;	
		}
	}
}

class thread1 {
	public static void main(String args[]) {
		ExdOfThread t1 = new ExdOfThread();
		t1.start();
		
		Thread t2 = new Thread(new ImpOfRunnable());
		t2.start();		
	}
}
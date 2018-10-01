abstract class base {
	void print1() {
		System.out.println("base");	
	}
	
	abstract void print();
}

class child extends base {
	void print() {
		System.out.println("child");
	}	
}

class child2 extends base {
	void print() {
		System.out.println("child2");	
	}	
}

class polymorphism2 {
	public static void main(String args[]) {
		// base b = new base(); // compiler error
		base c = new child();
		base c2 = new child2();
		c.print();
		c.print1();
		c2.print();
		c2.print1();
	}
}
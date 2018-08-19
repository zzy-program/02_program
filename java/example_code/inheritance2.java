class Mammal {
	void print() {
		System.out.println("Mammal");
	}
	
	void print_pub() {
		this.print();
	}
}

class Dog extends Mammal {
	void print() {
		System.out.println("Dog");
	}
}

class Cat extends Mammal {
	void print() {
		System.out.println("Cat");
	}
}

class inheritance2 {
	static void print(Mammal m) {
		m.print_pub();
	}
	
	public static void main(String[] args) {
		Dog fido = new Dog();
		Cat kitty = new Cat();
		Mammal m = new Mammal();
		print(m);
		print(fido);
		print(kitty);
	}	
}
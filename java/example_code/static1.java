class static1 {
	static int obj_num = 0;
	
	static1() {
		obj_num++;
	}
	
	void print_objnum() {
		System.out.println("object number: " + obj_num);	
	}
	
	public static void main(String args[]) {		
		static1 c1 = new static1();
		static1 c2 = new static1();	
		c2.print_objnum();
	}	
}
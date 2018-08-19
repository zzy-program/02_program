class enum_switch {
	enum Test{test1, test2, test3, test4}
	public static void main(String[] args) {
		Test test = Test.test3;
		switch(test) {
			case test1:
			break;
			
			case test2:
			break;
			
			case test3:
			System.out.println("test3");
			break;
			
			case test4:
			break;
			
			default:
			break;
		}
	}	
}
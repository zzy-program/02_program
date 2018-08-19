enum enum_ex {
	ex1(3, 4.5),
	ex2(2, 4.6),
	ex3(8, 9.7);
	
	enum_ex(int ii, double dd) {
		i = ii;
		d = dd;	
	}

	int geti() {
		return i;	
	}
	double getd() {
		return d;	
	}

	private int i;
	private double d;
}

class enum_data {
	public static void main(String[] args) {
		// byte b = 5;
		// b = b+5;
		enum_ex ex;
		ex = enum_ex.ex1;
		System.out.println("" + (ex==enum_ex.ex1)+(ex.equals(enum_ex.ex1)));
		System.out.println(enum_ex.ex1 + " " + enum_ex.ex1.ordinal() + " " + enum_ex.ex1.geti());
		System.out.println(enum_ex.ex2 + " " + enum_ex.ex2.ordinal() + " " + enum_ex.ex2.getd());		
	}	
}
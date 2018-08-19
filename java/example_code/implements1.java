class implements1 implements Comparable{
	private int i;
	
	implements1(int ii) {
		i = ii;	
	}
	
	public static implements1 valueOf(int ii) {
		return new implements1(ii);
	}
	
	public int compareTo(Object other)
	{
		implements1 other_tmp = (implements1)other;
		return (this.i - other_tmp.i);
	}
	
	public static void main(String args[]) {
		implements1 i1 = new implements1(3);
		implements1 i2 = new implements1(4);
		implements1 i3 = new implements1(5);
		if(i1.compareTo(i2) < 0) {
				System.out.println("i1<i2");
		}
		
		Integer a1 = 1;
		Integer a2 = 2;
		if(a1<a2) {
			System.out.println("a1<a2");
		}
		//i1 = 5;
	}	
}
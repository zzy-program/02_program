import java.math.*;

class big_value {
	public static void main(String[] args) {
		BigInteger a, b;
		a = new BigInteger("5465464");
		b = new BigInteger("5646653");
		a = a.multiply(b);
		a = a.multiply(b);
		a = a.multiply(b);
		a = a.multiply(b);
		System.out.println(a);
		
		BigDecimal d1, d2;
		d1 = new BigDecimal("12.336");
		d2 = new BigDecimal("3465321321855644321313332.22");
		d1 = d1.multiply(d2);
		d1 = d1.multiply(d2);
		d1 = d1.multiply(d2);
		d1 = d1.multiply(d2);
		System.out.println(d1);
	}
}
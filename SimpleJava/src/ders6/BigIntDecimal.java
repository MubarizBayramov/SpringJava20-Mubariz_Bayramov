package ders6;

import java.math.BigDecimal;

public class BigIntDecimal {

	public static void main(String[] args) {

		double d1 = 3343.5454;
		double d2 = 31.5445554;
		System.out.println(d1 + d2);
		BigDecimal bi1 = new BigDecimal("5436543534534534534432446574.543534566765765878");
		BigDecimal bi2 = new BigDecimal("543654443432446574.543554634566765765878");
		BigDecimal bi3 = bi1.multiply(bi2);
		System.out.println(bi3);
	}

}
public class Main{
	public static void print(Object o){
		System.out.println(o);
	}
	public static void main(String[] args) {
		RationalFraction r1 = new RationalFraction(1, 1);
		RationalFraction r2 = new RationalFraction(1, 2);
		RationalComplexNumber q1 = new RationalComplexNumber(r1, r2);
		RationalFraction r3 = new RationalFraction(1, 3);
		RationalFraction r4 = new RationalFraction(1, 4);
		RationalComplexNumber q2 = new RationalComplexNumber(r3, r4);
		RationalFraction r5 = new RationalFraction(1, 5);
		RationalFraction r6 = new RationalFraction(1, 6);
		RationalComplexNumber q3 = new RationalComplexNumber(r5, r6);
		RationalFraction r7 = new RationalFraction(1, 7);
		RationalFraction r8 = new RationalFraction(1, 8);
		RationalComplexNumber q4 = new RationalComplexNumber(r7, r8);
		RationalComplexMatrix2x2 m1 = new RationalComplexMatrix2x2(q1, q2, q3, q4);
		m1.add(m1);
		m1.mult(m1);
	}
}
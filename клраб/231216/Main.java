public class Main{
	public static void main(String[] args) {
		A a = new A();
		A b = a.copy();
		a.a = 2;
		a.print();
		b.print();
	}
}
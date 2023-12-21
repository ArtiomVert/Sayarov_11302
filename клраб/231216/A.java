public class A{
	public int a = 1;
	public int b = 1;
	public int c = 1;
	public A copy(){
		A s = new A();
		s.a = a;
		s.b = b;
		s.c = c;
		return s;
	}
	public void print(){
		System.out.println(a + " " + b + " " + c);
	}
}
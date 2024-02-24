package cw240210;

public class A /*implements Comparable<A>*/{
	int a;
	int b;
	public A(int a, int b){
		this.a = a;
		this.b = b;
	}
	/*
	@Override
	public int compareTo(A a1) {
    	if(a!=a1.a){
			return a>a1.a?1:-1;
		}
		if(b!=a1.b){
			return b>a1.b?1:-1;
		}
		return 0;
	}
	*/
	void pr(){
		System.out.println(a + " " + b);
	}
}
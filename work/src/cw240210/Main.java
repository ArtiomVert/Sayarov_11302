import java.util.Arrays;
public class Main{
	public static void main(String[] args) {
		/*
		Comparator<A> comparator = new Comparator<A>(){
			public int compare(A a1, A a2) {
    			if(a2.a!=a1.a){
					return a2.a<a1.a?1:-1;
				}
				if(a2.b!=a1.b){
					return a2.b<a1.b?1:-1;
				}
				return 0;
			}
		};
		*/

		ComparatorA comparator = new ComparatorA();
		A[] a = {
			new A(1,1),
			new A(1,1),
			new A(0,2),
			new A(1,0),
			new A(3,4),
			new A(3,2),
			new A(0,3)
		};

		Arrays.sort(a, comparator);

		for (int i = 0; i < a.length; i++) {
			a[i].pr();
		}
	}
}
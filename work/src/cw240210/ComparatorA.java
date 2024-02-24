package cw240210;

import java.util.Comparator;
public class ComparatorA implements Comparator<A>{
	@Override
	public int compare(A a1, A a2) {
    	if(a2.a!=a1.a){
			return a2.a<a1.a?1:-1;
		}
		if(a2.b!=a1.b){
			return a2.b<a1.b?1:-1;
		}
		return 0;
	}
}
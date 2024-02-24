package cw240210;

import java.util.*;
public class MyArrayIterator implements Iterator<Integer>{
	private final int[] a;
	private int pos = 0;
	private int size;
	public MyArrayIterator(int[] a){
		this.a = a;
		size = a.length;
	}
	public boolean hasNext(){
		return pos<size;
	}
	public Integer next(){
		pos++;
		return a[pos-1];
	}

}
package cw240210;

public class MyList implements MyListInterface<Integer>{
	private int[] a;
	private int size;
	public MyList(int[] a){
		this.a = a;
		size = a.length;
	}
	public MyList(){
		a = new int[0];
		size = 0;
	}
	public Integer get(int i){
		return a[i];
	}
	public int size(){
		return size;
	}
	public void add(Integer integer){
		int[] a1 = new int[size+1];
		for (int i = 0; i < size; i++){
			a1[i] = a[i];
		}
		a1[size] = integer;
		size++;
		a = a1;
	}
	public void add(int it, Integer integer){
		int[] a1 = new int[size+1];
		for (int i = 0; i < size; i++){
			if (it==i){
				a1[it] = integer;
			}
			a1[i] = a[i];
		}
		for (int i = it; i < size; i++){
			a1[i+1] = a[i];
		}
		size++;
		a = a1;
	}
	public void remove(int it){
		int[] a1 = new int[size-1];
		for (int i = 0; i < it; i++){
			a1[i] = a[i];
		}
		for (int i = it; i < size; i++){
			a1[i-1] = a[i];
		}
		size--;
		a = a1;
	}
}
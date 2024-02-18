public class Main2{
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5,6,7,8,9};
		MyArrayIterator ita = new MyArrayIterator(a);
		while(ita.hasNext()){
			System.out.print(ita.next());
		}
	}
}
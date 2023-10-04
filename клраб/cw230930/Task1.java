public class Task1{
	public static void main(String[] args) {
		int[] a = {8,65,1,86,31,85,3,68,5,1,3};
		int max = a[0];
		for (int i:a){
			if (i>max){
				max = i;
			}
		}
		System.out.println(max);
	}
}
//3b
public class Task6{
	public static void main(String[] args) {
		int[] a = {8,6,4,7,3,4};
		int b = 900;
		int lena = a.length;
		for (int i = 0; i<lena; i++){
			a[i] = a[i]*b;
		}

		for (int i = 1; i < lena; i++){
			a[lena-i-1] += a[lena-i]/10;
			a[lena-i] = a[lena-i]%10;
		}
		for (int i = 0; i < lena; i++){
			System.out.print(a[i]);
		}
	}
}
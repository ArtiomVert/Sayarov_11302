//3a
public class Task4{
	public static void main(String[] args) {
		byte[] a1 = {1,9,4,3,9,9,9,5,4,9,9,9,9,9,9,9,9,9,9,9,9};
		byte[] b1 = {9,9,4,3,9,9,9,5,4,9,9,9,9,9,9,9,9,9,9,9,9};
		int lena1 = a1.length;
		int lenb1 = b1.length;
		int lena = lena1>lenb1?lena1:lenb1;
		int lenb = lena1>lenb1?lenb1:lena1;
		int[] a = new int[lena];
		byte[] b = new byte[lenb];
		if (lena == lena1){
			for (int i = 0; i < lena; i++){
				a[i] = a1[i];
			}
			for (int i = 0; i < lenb; i++){
				b[i] = b1[i];
			}
		}else {
			for (int i = 0; i < lena; i++){
				a[i] = b1[i];
			}
			for (int i = 0; i < lenb; i++){
				b[i] = a1[i];
			}
		}
		
		for (int i = 1; i <= lenb; i++){
			a[lena - i] += b[lenb - i];
		}
		for (int i = 1; i < lena; i++){
			a[lena-i-1] += a[lena-i]/10;
			a[lena-i] = a[lena-i] - a[lena-i]/10*10;
		}
		for (int i = 0; i < lena; i++){
			System.out.print(a[i]);
		}
		

	}
}
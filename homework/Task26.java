public class Task26{
	public static boolean ch(int a){
		while (a>0){
			if (a%2==0){
				return true;
			}
			a /= 10;
		}
		return false;
	}
	public static boolean task26(int[] a){
		for (int i = 0; i < a.length; i++) {
			if (a[i]>0){
				if (!ch(a[i])){
					return false;
				}
			}
		}
		return true;
	}
	public static void main(String[] args) {
		
	}
}
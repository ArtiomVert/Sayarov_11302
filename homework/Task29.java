public class Task29{
	public static boolean t29(int a){
		while (a > 0){
			if (a % 2 != 0){
				return false;
			}
			a /= 10;
		}
		return true;
	}
	public static boolean task29(int[][] a){
		for (int i = 0; i < a.length; i++) {
			boolean f = true;
			for (int j = 0; j < a[i].length && f; j++){
				if (t29(a[i][j])){
					f = false;
				}
			}
			if (f){
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		
	}
}
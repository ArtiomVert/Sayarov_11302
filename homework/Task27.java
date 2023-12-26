public class Task27{
	public static boolean task27(int[][] a){
		for (int i = 0; i < a.length; i++) {
			boolean f = true;
			for (int j = 0; j < a[i].length && f; j++){
				if (a[i][j]%3!=0){
					f = false;
				}
			}
			if (f){
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		
	}
}
public class Task24{
	
	public static boolean task24(int[] a){
		int c = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] < 0){
				c ++;
				if (c == 2){
					return true;
				}	
			}
		}
		return false;
	}

	public static void main(String[] args) {
		
	}
}
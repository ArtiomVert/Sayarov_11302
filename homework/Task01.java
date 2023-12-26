public class Task01{
	public static void main(String[] args) {
		int n = 5;
		for (int y = 0; y<n; y++){
			for (int x = 0; x<n; x++){
				if (x<=y){
					System.out.print(0);
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		System.out.println();
		for (int y = 0; y<n; y++){
			for (int x = 0; x<n; x++){
				if (x+y<n){
					System.out.print(0);
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		System.out.println();
		for (int y = 0; y<n; y++){
			for (int x = 0; x<n; x++){
				if (x+y>=n-1){
					System.out.print(0);
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
}
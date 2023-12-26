import java.util.Scanner;
public class Task02{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int c = 1;
		for (int i = 0; i < n; i++){
			for (int j = 0; j < 2*n-2-i; j++){
				System.out.print(" ");
			}
			for (int j = 0; j < c; j++){
				System.out.print("*");
			}
			c+=2;
			System.out.println();
		}
		c = 3;
		int pr = 2*n-5;
		for (int i = 1; i < n-1; i++){
			for (int j = 0; j < n-1-i; j++){
				System.out.print(" ");
			}
			for (int j = 0; j < c; j++){
				System.out.print("*");
			}
			for (int j = 0; j < pr; j++){
				System.out.print(" ");
			}
			for (int j = 0; j < c; j++){
				System.out.print("*");
			}
			c+=2;
			pr -= 2;
			System.out.println();
		}
		for(int i = 0; i < 4*n-3; i++){
			System.out.print("*");
		}
	}
	
}
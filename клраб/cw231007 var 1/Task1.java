import java.util.Scanner;
public class Task1{
	public static void main(String[] args) {
		Scanner inp = new Scanner(System.in);
		int n = inp.nextInt();
		int c = 1;
		for (int i = 0; i < n; i++){
			for (int j = 0; j < n - 1 - i; j++){
				System.out.print(" ");
			}
			for (int j = 0; j < c; j++){
				System.out.print("8");
			}
			c += 2;
			System.out.println();
		}
		c -= 4;
		for (int i = 0; i< n - 1; i++){
			for (int j = 0; j < i + 1; j++){
				System.out.print(" ");
			}
			for (int j = 0; j < c; j++){
				System.out.print("8");
			}
			c -= 2;
			System.out.println();
		}
	}
}
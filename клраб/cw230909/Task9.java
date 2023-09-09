import java.util.Scanner;
public class Task9{
	public static void main(String[] args) {
		Scanner inp = new Scanner(System.in);
		int n = inp.nextInt();
		int m = inp.nextInt();
		for (int y = 0; y<m; y++){
			for (int x = 0; x<n; x++){
				System.out.print("0");
			}
			System.out.println();
		}
	}
}
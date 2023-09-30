import java.util.Scanner;
public class Task1{
	public static void main(String[] args) {
		Scanner inp = new Scanner(System.in);
		int n = inp.nextInt();
		long s = 0;
		for (int k=1;k<=n;k++){
			s += k*k;
		}
		System.out.println(s);
	}
}
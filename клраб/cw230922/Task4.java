import java.util.Scanner;
public class Task4{
	public static void main(String[] args) {
		Scanner inp = new Scanner(System.in);
		int n = inp.nextInt();
		double s = 0;
		double sl = 1;
		for (int k=1;k<=n;k++){
			sl = sl * (k/2.0);
			s = s + sl;
		}
		System.out.println(s);
	}
}
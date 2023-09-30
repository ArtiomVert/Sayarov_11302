import java.util.Scanner;
public class Task5{
	public static void main(String[] args) {
		Scanner inp = new Scanner(System.in);
		int n = inp.nextInt();
		int m = inp.nextInt();
		long s = 0;
		for (int k=1;k<=n;k++){
			long p = 1;
			int sl = 1;
			for (int q = 1; q <= m; q++){
				sl *= 2;
				p *= (sl + k);
			}
			s += p;
		}
		System.out.println(s);
	}
}
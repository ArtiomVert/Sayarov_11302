import java.util.Scanner;
public class Task3{
	public static void main(String[] args) {
		Scanner inp = new Scanner(System.in);
		int n = inp.nextInt();
		long s = 0;
		for (int k=1;k<=n;k++){
			int sl = 1;
			for (int q = 1; q<=k;q++){
				sl *=2;
			}
			s+= sl + k*k;
		}
		System.out.println(s);
	}
}
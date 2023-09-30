import java.util.Scanner;
public class Task2{
	public static void main(String[] args) {
		Scanner inp = new Scanner(System.in);
		int n = inp.nextInt();
		long s = 0;
		int sl = 1;
		for (int k=1;k<=n;k++){
			sl*=2;
			s+=sl;
		}
		System.out.println(s);
	}
}
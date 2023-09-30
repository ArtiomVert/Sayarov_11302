import java.util.Scanner;
public class Task7{
	public static void main(String[] args) {
		Scanner inp = new Scanner(System.in);
		double x = inp.nextDouble();
		double n = 0;
		for (double i = 1; i >= 1e-10; i = i / 10){
			System.out.print(n + " ");
			if (Math.abs(n*n-x)<1e-8){
				break;
			}
			while (n*n<x){
				n = n + i;
			}
			System.out.println(n);
			if (Math.abs(n*n-x)<1e-8){
				break;
			}
			n = n - i;

		}
		System.out.println(n);
	}
}
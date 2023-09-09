import java.util.Scanner;
public class Task4{
	public static void main(String[] args) {
		Scanner inp = new Scanner(System.in);
		double x = inp.nextDouble();
		if (x<0){
			x *= -1;
		}
		System.out.println(x);
	}
}
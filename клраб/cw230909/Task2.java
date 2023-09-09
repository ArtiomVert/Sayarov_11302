import java.util.Scanner;
public class Task2{
	public static void main(String[] args) {
		Scanner inp = new Scanner(System.in);
		int a = inp.nextInt();
		int b = inp.nextInt();
		if (a>=b){
			System.out.println(a);
		} else {
			System.out.println(b);
		}
	}
}
import java.util.Scanner;
public class Task3{
	public static void main(String[] args) {
		Scanner inp = new Scanner(System.in);
		int a = inp.nextInt();
		int b = inp.nextInt();
		int c = inp.nextInt();
		if (a>=b){
			if (c>=a){
				System.out.println(c);
			} else {
				System.out.println(a);
			}
		} else {
			if (c>=b){
				System.out.println(c);
			} else {
				System.out.println(b);
			}
		}
	}
}
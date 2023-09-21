import java.util.Scanner;
public class Zadachi {
	
	public static void main(String[] args) {
		System.out.println("!!!!!000!!!!!");
		Scanner inp = new Scanner(System.in);
		Boolean f = true;
		while (f) {
			String s = inp.nextLine();
			switch (s){
			case "end":
				f = false;
				break;
			case "print":
				System.out.println(1e-1);
				break;
			default:
				System.out.println(s);
				break;
			}
		}
	}
}
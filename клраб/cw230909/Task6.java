import java.util.Scanner;
public class Task6{
	public static void main(String[] args) {
		Scanner inp = new Scanner(System.in);
		Double x = inp.nextDouble();
		Double y = inp.nextDouble();
		if ((x*x + y*y <= 16) && ((y>=2)||(x>=0 && y<=0))){
			System.out.println("YES");
		} else{
			System.out.println("NO");
		}
		//System.out.println();
	}
}
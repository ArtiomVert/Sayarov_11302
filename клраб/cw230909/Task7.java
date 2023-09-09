import java.util.Scanner;
public class Task7{
	public static void main(String[] args) {
		Scanner inp = new Scanner(System.in);
		//Double x = inp.nextDouble();
		//Double y = inp.nextDouble();
		for (double y = 4; y>=-4; y-=0.1){
			for (double x = -4; x<=4; x+=0.05){
				if (((x*x + y*y <= 16) && (x*x + (2-y)*(2-y) >= 4) && (x>=0)) || (x*x + (2+y)*(2+y) <= 4)){
					System.out.print("8");
				} else{
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
}
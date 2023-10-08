import java.util.Scanner;
public class Task3{

	static boolean func(double x, double y){
		if ((x >= 0) && ((x * x + (y - 3) * (y - 3)) <= 1)){
			return true;
		}
		if ( (y>=-1) && (y<=1) && (y>=x-2) && (y>=-x-2) ){
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner inp = new Scanner(System.in);
		double x = inp.nextDouble();
		double y = inp.nextDouble();
		System.out.println(func(x, y)?"YES":"NO");
		/*
		for (double yp = 5; yp >= -2; yp-= 0.2){
			for (double xp = -4; xp <= 4; xp+= 0.1){
				System.out.print(func(xp, yp)?"8":" ");
			}
			System.out.println();
		}
		*/
	}
}
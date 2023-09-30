import java.util.Scanner;
public class Task4{
	public static void main(String[] args) {
		//((n-1)/2)/n
		double n1 = ((3-1)/2.0)/3;
		double n2 = ((4-1)/2.0)/4;
		double n = 4;
		while (Math.abs(n1-n2)>1e-10){
			n += 1;
			n1 = n2;
			n2 = ((n-1)/2)/n;
		}
		System.out.println((int)(n2*1000) / 1000.0);
	}
}
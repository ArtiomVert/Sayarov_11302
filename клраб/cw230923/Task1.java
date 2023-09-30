//import java.util.Scanner;
public class Task1{
	public static void main(String[] args) {
		//Scanner inp = new Scanner(System.in);
		//int n = inp.nextInt(); (10000*n)/(n*n+1)
		double n1 = (10000*1)/(1*1.0+1);
		double n2 = (10000*2)/(2*2.0+1);
		double n = 2;
		while (Math.abs(n1-n2)>1e-10){
			n += 2;
			n1 = n2;
			n2 = (10000*n)/(n*n+1);
		}
		System.out.println(n2);

	}
}
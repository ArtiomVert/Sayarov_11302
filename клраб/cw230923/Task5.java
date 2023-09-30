//e^x
public class Task5{
	public static void main(String[] args) {
		double x = 2;
		double n1 = x;
		double n = 1;
		double s = 1;
		while (n1>1e-10){
			n += 1;
			s += n1;
			n1 = n1*(x/n);
		}
		System.out.println(s);
	}
}
//sin x
public class Task6{
	public static void main(String[] args) {
		double x = -Math.PI;
		double n1 = x;
		double n = 0;
		double s = 0;
		while (Math.abs(n1)>1e-15){
			n += 1;
			s += n1;
			n1 = n1*(x*x/(2*n*(2*n+1)))*(-1);
		}
		System.out.println((int)(s*1000) / 1000.0);
		System.out.println(s);
	}
}
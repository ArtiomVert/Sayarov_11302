//cos x
public class Task04{
	public static void main(String[] args) {
		double x = Math.PI/6;
		double n1 = 1;
		double n = 0;
		double s = 0;
		while (Math.abs(n1)>1e-15){
			n += 2;
			s += n1;
			n1 = n1*(x*x/(n*(n-1)))*(-1);
		}
		System.out.println((int)(s*1000) / 1000.0);
		System.out.println(s);
	}
}
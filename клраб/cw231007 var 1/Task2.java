public class Task2{
	public static void main(String[] args) {
		double x = 0.5;
		double s = 0;
		int kf = 2;
		double a1 = (1 * (x + 2)) / 1;
		double a2 = (x * (x + 2)) / 2;
		s = a1 + a2;
		while (Math.abs(a1 - a2) > 1e-15){
			a1 = a2;
			kf += 1;
			a2 *= x / kf;
			s += a2;
		}
		System.out.println(s);
	}
}
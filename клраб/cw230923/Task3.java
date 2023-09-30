public class Task3{
	public static void main(String[] args) { 
		double n1 = (-2 + 3)/(4 + 9.0);
		double n2 = (4 + 9)/(-8 + 27.0);
		double p2 = 4;
		double p3 = 9;
		while (Math.abs(n1-n2)>1e-10){
			p2 *= -2;
			p3 *= 3;
			n1 = n2;
			n2 = (p2+p3)/(p2*(-2) + p3*(3));
		}
		System.out.println((int)(n2*1000) / 1000.0);
	}
}
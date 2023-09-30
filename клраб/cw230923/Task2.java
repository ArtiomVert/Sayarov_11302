public class Task2{
	public static void main(String[] args) {
		double n1 = Math.sqrt(1+1) - Math.sqrt(1);
		double n2 = Math.sqrt(2+1) - Math.sqrt(2);
		double n = 2;
		while (Math.abs(n1-n2)>1e-10){
			n += 1;
			n1 = n2;
			n2 = Math.sqrt(n+1) - Math.sqrt(n);
		}
		System.out.println((int)(n2*1000) / 1000.0);
	}
}
public class Task8{
	public static void main(String[] args) {
		long s = 0;
		for (String n:args){
			int num = Integer.parseInt(n);
			s+=num;
		}
		System.out.println(s);
	}
}
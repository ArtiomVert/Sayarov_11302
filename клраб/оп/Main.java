public class Main{
	public static void print(Object o){
		System.out.println(o);
	}
	public static void main(String[] args) {
		try{
			RationalFraction r1 = new RationalFraction(1, 0);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}
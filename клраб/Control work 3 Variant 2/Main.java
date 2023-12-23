public class Main{
	public static void main(String[] args) {
		try{
			PromTime t1 = new PromTime(1, 50, 40);
			PromTime t2 = new PromTime(6, 40, 30);
			System.out.println(t1.addTime(t2).toString());
			System.out.println(t1.multTime(2).toString());
		}catch (Exception e) {
			
		}
		
	}
}
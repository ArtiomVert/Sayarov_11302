//2ab
public class Task3{
	public static void main(String[] args) {
		int[] masa = {10, 4, 57, 13, 7, 64, 7, 25, 67, 2, 14, 50, 88, 7, 21, 27};
		int[] masb = {1, 4, 75, 31, 7, 46, 7, 52, 76, 2, 41, 5, 88, 7, 12, 72};
		int n = masa.length;
		//a
		long scpr = 0;
		for (int i = 0; i < n;i ++){
			scpr += masa[i] * masb[i];
		}
		System.out.println(scpr);
		//b
		double da = 0;
		for (int i = 0; i < n;i ++){
			da += masa[i] * masa[i];
		}
		da = Math.sqrt(da);
		double db = 0;
		for (int i = 0; i < n;i ++){
			db += masb[i] * masb[i];
		}
		db = Math.sqrt(db);
		double cosab = scpr / (da * db);
		System.out.println(cosab);
	}
}
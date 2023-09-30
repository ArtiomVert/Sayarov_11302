public class Task6{
	public static void main(String[] args) {
		for (int m = 1; m <= 100;m ++){
			for (int n = 1; n <= 100; n ++){
				long s = 0;
				for (int i = 1; i <= m; i ++){
					int p = 1;
					for (int j = 1; j <= n; j ++){
						p*=Math.pow(-1, i + j);
					}
					s += p;
				}
				System.out.print(m + " " + n + " " + s + " ");
				if (m % 2 == 0){
					if (n % 2 == 1){
						System.out.println(0);
					} else {
						System.out.println((n / 2 % 2 == 1 ? -m: m));
					}
				} else{
					if (n % 2 == 1){
						System.out.println(((n - 1) / 2 % 2 == 1 ? -1: 1));
					} else {
						System.out.println((n / 2 % 2 == 1 ? -m: m));
					}
				}
			}
			
		}
	}
}
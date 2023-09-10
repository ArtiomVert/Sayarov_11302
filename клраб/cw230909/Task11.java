import java.util.Scanner;
public class Task11{
	public static String[][] pyr(int i, int n, int x, int y, String[][] mas){
		int x1 = 0;
		int y1 = 0;
		for (int c = 0; c < i; c++){
			int cnt = 1;
			for (int q = 0; q < n; q++){
				x1 = x - q;
				y1 = y + q;
				for (int w = 0; w < cnt; w++){
					mas[y1][x1+w] = "8";
				}
				cnt += 2;
			}
			x = x + 2 * n - 2;
		}
		return mas;
	}
	public static void main(String[] args) {
		Scanner inp = new Scanner(System.in);
		int n = inp.nextInt();
		int c = inp.nextInt();
		int ym = n * c - (c - 1);
		int xm = 2 * c * (n - 1) + 1;
		int x = n * c - c;
		int y = 0;
		String[][] mas = new String[ym][xm];
		for (int yo = 0; yo < ym; yo ++){
			for (int xo = 0; xo < xm; xo ++){
				mas[yo][xo] = " ";
			}
		}
		for (int i = 1; i <= c; i++){
			mas = pyr(i, n, x, y, mas);
			x = x - n + 1;
			y = y + n - 1;
			System.out.println(x + " " + y);
		}
		for (int yo = 0; yo < ym; yo ++){
			for (int xo = 0; xo < xm; xo ++){
				System.out.print(mas[yo][xo]);
			}
			System.out.println();
		}
	}
}

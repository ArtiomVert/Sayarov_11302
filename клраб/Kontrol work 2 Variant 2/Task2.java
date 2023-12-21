//Вариант 2
import java.util.Scanner;
public class Task2{
	public static double[][] ed(int m){
		double[][] e = new double[m][m];
		for (int i = 0; i < m; i++){
			e[i][i] = 1;
		}
		return e;
	}
	public static double[][] mult(double[][] a, double[][] b, int m){
		double[][] c = new double[m][m];
		for (int i = 0; i < m; i++){
			for (int j = 0; j < m; j++){
				double s = 0;
				for (int k = 0; k < m; k ++){
					s += a[i][k]*b[k][j];
				}
				c[i][j] = s;
			}
		}
		return c;
	}
	public static double[][] sum(double[][] a, double[][] b, int m){
		double[][] c = new double[m][m];
		for (int i = 0; i < m; i++){
			for (int j = 0; j < m; j++){
				c[i][j] = a[i][j] + b[i][j];
			}
		}
		return c;
	}
	public static void output(double[][] a, int m){
		for (int i = 0; i < m; i++){
			for (int j = 0; j < m; j++){
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int m = Integer.parseInt(in.nextLine());
		int n = Integer.parseInt(in.nextLine());
		double[][] a = new double[m][m];
		for (int i = 0; i < m; i++){
			String[] s = in.nextLine().split(" ");
			for (int j = 0; j < m; j++){
				a[i][j] = Double.parseDouble(s[j]);
			}
		}
		/*
		double[][] a = {
			{1, 1, 1, 1, 1},
			{1, 1, 1, 1, 1},
			{1, 1, 1, 1, 1},
			{1, 1, 1, 1, 1},
			{1, 1, 1, 1, 1}
		};//матрица A
		*/
		double[][] itog = ed(m);
		double[][] a_in_pow = mult(ed(m), a, m);
		for (int i = 0; i < n; i++){
			itog = sum(itog, a_in_pow, m);
			a_in_pow = mult(a_in_pow, a, m);
		}
		output(itog, m);
	}
}
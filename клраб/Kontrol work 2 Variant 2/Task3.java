//Вариант 2
import java.util.Scanner;
public class Task3{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[] t = new int[15];
		int n = in.nextInt();
		//С учётом, что повторений в массиве часов нет
		for (int i = 0; i < n; i++){
			int m = in.nextInt();
			for (int j = 0; j < m; j++){
				t[in.nextInt()-7] ++;
			}
		}
		for (int i = 0; i < 15; i++){
			System.out.println(i+7+":00: " + t[i] + " workers");
		}
	}
/*
5
3
8 9 10
4
12 13 14 15
3
9 10 11
2
11 12
3
18 19 20
*/
}
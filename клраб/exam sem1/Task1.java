import java.util.Scanner;
public class Task1{
	public static boolean isGl(char c){
		String s = "EYUIOAeyuioa";
		for (int i = 0; i < s.length(); i++){
			if (c == s.charAt(i)){
				return true;
			}
		}
		return false;
	}

	public static int amGl(String s){
		int c = 0;
		for (int i = 0; i < s.length(); i++){
			c += isGl(s.charAt(i))?1:0;
		}
		return c;
	}

	public static boolean task1(String[][] strs, int k){
		int n = strs.length;//строк
		int m = strs[0].length;//столбцов
		for(int i = 0; i < m; i++){
			int ag = 0;
			for(int j = 0; j < n && ag <= k; j++){
				ag += amGl(strs[j][i]);
			}
			if (ag>k){
				return false;
			}
		}
		return true;
	}
	public static int task2(String[][] strs){
		int sg = 0;
		int n = strs.length;//строк
		int m = strs[0].length;//столбцов
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				sg += amGl(strs[j][i]);
			}
		}
		return sg;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		int m = Integer.parseInt(sc.nextLine());
		String[][] s = new String[n][m];
		for(int i = 0; i < n; i++){
			String[] arg = sc.nextLine().split(" ");
			for(int j = 0; j < m; j++){
				s[i][j] = arg[j];
			}
		}
		int k = Integer.parseInt(sc.nextLine());
		System.out.println(task1(s, k));
		System.out.println(task2(s));
	}
}
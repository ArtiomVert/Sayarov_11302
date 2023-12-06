import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class Main{
	public static String str(Object s){
		return s + "";
	}
	public static boolean isGl(char c){
		return q(str(c), "[ayuioeAYUIOE]");
	}
	public static boolean task1(int[] a){
		for (int i = 0; i < a.length; i++) {
			if (a[i] < 0){
				return true;
			}
		}
		return false;
	}
	public static boolean q(String s, String reg){
		Pattern p = Pattern.compile(reg);
		Matcher m = p.matcher(s);
		return m.matches();
	}
	public static boolean task2(String s){
		for (int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			if (q(str(c), "[a-zA-Z]")){
				if (!isGl(c)){
					return false;
				}
			}
		}
		return true;
	}
	public static boolean task3(int[] a){
		int c = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] < 0){
				c ++;
				if (c == 2){
					return true;
				}	
			}
		}
		return false;
	}
	public static boolean task4(String s){
		int c = 0;
		for (int i = 0; i < s.length() && c<=4; i++){
			if (isGl(s.charAt(i))){
				c++;
			}
		}
		return c==3;
	}
	public static boolean t5(int a){
		while (a>0){
			if (a%10%2==0){
				return true;
			}
			a /= 10;
		}
		return false;
	}
	public static boolean task5(int[] a){
		for (int i = 0; i < a.length; i++) {
			if (a[i]>0){
				if (!t5(a[i])){
					return false;
				}
			}
		}
		return true;
	}
	public static boolean task6(int[][] a){
		for (int i = 0; i < a.length; i++) {
			boolean f = true;
			for (int j = 0; j < a[i].length && f; j++){
				if (a[i][j]%3!=0){
					f = false;
				}
			}
			if (f){
				return true;
			}
		}
		return false;
	}
	public static boolean task7(String[][] s){
		for (int i = 0; i < s[0].length; i++) {
			boolean f = true;
			for (int j = 0; j < s.length && f; j++){
				if (isGl(s[j][i].charAt(0))){
					f = false;
				}
			}
			if (f){
				return false;
			}
		}
		return true;
	}
	public static boolean t8(int a){
		while (a > 0){
			if (a % 2 != 0){
				return false;
			}
			a /= 10;
		}
		return true;
	}
	public static boolean task8(int[][] a){
		for (int i = 0; i < a.length; i++) {
			boolean f = true;
			for (int j = 0; j < a[i].length && f; j++){
				if (t8(a[i][j])){
					f = false;
				}
			}
			if (f){
				return false;
			}
		}
		return true;
	}
	public static boolean task9(String[][] s){
		for (int i = 0; i < s[0].length; i++) {
			boolean f = true;
			for (int j = 0; j < s.length && c<=3; j++){
				if ( isGl( s[j][i].charAt(0) ) ){
					c ++;
				}
			}
			if (c == 3){
				return false;
			}
		}
		return true;
	}
	public static boolean task10(int[][] a){
		for (int i = 0; i < a.length; i++) {
			boolean f = true;
			int c = 0;
			for (int j = 0; j < a[i].length && f; j++){
				if (t8(a[i][j])){
					c++;
				}
				if (c==3){
					f = false;
					break;
				}
			}
			if (f){
				return false;
			}
		}
		return true;
	}
/*
1)Проверить, что в массиве целых чисел существует отрицательное число.
2)Проверить, что в строке (String) все буквы ялвяются гласными.
3)Проверить, что в массиве целых чисел существует не менее двух отрицательных чисел.
4)Проверить, что в строке (String) ровно 3 буквы ялвяются гласными.
5)Проверить, что в массиве целых чисел все положительные числа содержат хотя бы одну четную цифру.
6)Проверить, что в двумерном массиве существует строчка, что все ее элементы делятся на 3.
7)Проверить, что в двумерном массиве строк (String) в каждом столбце есть строка, которая начинается на гласную букву английского алфавита.
8)Проверить, что в двумерном массиве чисел в любой строчке существует число, состоящее только из четных цифр.
9)Проверить, что в двумерном массиве строк (String) в каждом столбце есть не более двух строк, которая начинается на гласную букву английского алфавита.
10)Проверить, что в двумерном массиве чисел в любой строчке существует не менее 3х чисел, состоящих только из четных цифр.
*/
	public static void main(String[] args) {
		String[][] s = {
			{"Asgk","SAGL","qkgj"},
			{"Ikowf", "Bnsfaf","gjlsa"},
			{"jasb","Ythrh","g"}
		};
		int[][] a = {
			{4226, 4211, 3331},
			{5241, 8246, 4354},
			{677, 68, 79},
			{2462, 4642, 624}
		};
		System.out.println(task2("112ab"));
	}
}
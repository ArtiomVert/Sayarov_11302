import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Scanner;
public class Task2{
	public static boolean q(String s, String reg){
		Pattern p = Pattern.compile(reg);
		Matcher m = p.matcher(s);
		return m.matches();
	}
	public static String str(char c){return c+"";}
	public static boolean q1(String s){
		int cntg = 0;
		int cnts = 0;
		for (int i = 0; i < s.length(); i++){
			if (q(str(s.charAt(i)), "[A-Za-z]")){
				if (q(str(s.charAt(i)), "[AEYUIOaeyuio]")){
					cntg += 1;
				} else{
					cnts += 1;
				}
			}
		}
		return cntg > cnts;
	}
	public static boolean metSos(String s){
		int sost = 0;
		for (int i = 0; i < s.length(); i++){
			String s1 = str(s.charAt(i));
			switch (sost){
				case 0:
					if (q(s1, "[+-]")){
						sost = 1;
					} else if (q(s1, "[1-9]")){
						sost = 2;
					}else if (q(s1, "0")){
						sost = 3;
					}else{
						sost = 666;
					}
					break;
				case 1:
					if (q(s1, "[1-9]")){
						sost = 2;
					} else {
						sost = 666;
					}
					break;
				case 2:
					if (q(s1, "[0-9]")){
						sost = 2;
					} else {
						sost = 666;
					}
					break;
				case 3:
					sost = 666;
					break;
				default:
					break;
			}
		}
		return sost==3?true:sost==2;
	}
	private static boolean skobki(String s){
		int c = 0;
		for (int i = 0; i < s.length(); i++){
			switch (str(s.charAt(i))) {
				case "(":
					c+=1;
					break;
				case ")":
					c-=1;
			}
			if (c<0){
				return false;
			}
		}
		return c == 0;
	}
	public static void main(String[] args) {
		Scanner inp = new Scanner(System.in);
		while (true){
			String s = inp.nextLine();
			System.out.println("1. " + q(s, "[1-9][0-9]*"));
			System.out.println("2. " + metSos(s));
			System.out.println("2. " + q(s, "0|[+-]?[1-9][0-9]*"));
			System.out.println("3. " + q(s, "\\+7-([0-9]{3}-){2}[0-9]{2}-[0-9]{2}"));
			System.out.println("4. " + q(s, "1([5-8][0-9]{2}|49[2-9]|9[0-5][0-9]|96[0-2])"));
			System.out.println("5. " + q1(s));
			System.out.println("6. " + q(s, "[AEYUIO].*[AEYUIO]"));
			System.out.println("7. " + q(s, "[a-z][A-Za-z0-9_-]*"));
			System.out.println("8. " + skobki(s));
			System.out.println("9. " + q(s, "[a-z][A-Za-z0-9_]* = [a-z][A-Za-z0-9_]*( [+-/*] [a-z][a-z0-9_-]*)*;"));
		}
	}
}
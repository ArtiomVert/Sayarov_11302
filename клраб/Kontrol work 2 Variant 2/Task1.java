//Вариант 2
import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class Task1{
	public static String str(char s){
		return s + "";
	}
	public static boolean isIt(String s, String reg){
		Pattern p = Pattern.compile(reg);
		Matcher m = p.matcher(s);
		return m.matches();
	}
	public static boolean isGoodString(String s){
		int cn = 0;//кол-во цифр
		int cs = 0;//кол-во стр. букв
		for (int i = 0; i < s.length(); i++){
			String symbol = str(s.charAt(i));
			if (isIt(symbol, "[0-9]")){
				cn++;
			}
			if (isIt(symbol, "[a-z]")){
				cs++;
			}
		}
		return cn>cs;
	}
	public static void main(String[] args) {
		//String[] strs = {"123ewqr", "123qw", "1q2w3e", "1234e", "g gg3333"};
		String[] strs = args;
		int c = 0;
		for (int i = 0; i < strs.length && c!=3; i++) {
			c += isGoodString(strs[i])?1:0;
		}
		System.out.println(c==3);
	}
}
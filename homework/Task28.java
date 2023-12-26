import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class Task28{
	public static String str(Object s){
		return s + "";
	}
	public static boolean isGl(char c){
		return q(str(c), "[ayuioeAYUIOE]");
	}
	public static boolean q(String s, String reg){
		Pattern p = Pattern.compile(reg);
		Matcher m = p.matcher(s);
		return m.matches();
	}
	public static boolean task28(String[][] s){
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
	public static void main(String[] args) {
		
	}
}
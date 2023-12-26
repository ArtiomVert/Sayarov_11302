import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class Task25{
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
	public static boolean task25(String s){
		int c = 0;
		for (int i = 0; i < s.length() && c<=4; i++){
			if (isGl(s.charAt(i))){
				c++;
			}
		}
		return c==3;
	}
	public static void main(String[] args) {
		System.out.println(task25("AAwwwawa"));
	}
}
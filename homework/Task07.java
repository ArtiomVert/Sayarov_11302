import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Scanner;
public class Task07{
	public static boolean q(String s, String reg){
		Pattern p = Pattern.compile(reg);
		Matcher m = p.matcher(s);
		return m.matches();
	}
	public static void main(String[] args) {
		Scanner inp = new Scanner(System.in);
		String s = inp.nextLine();
		System.out.println(q(s, "[a-z][A-Za-z0-9_-]*"));
	}
}
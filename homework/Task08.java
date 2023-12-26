import java.util.Scanner;
public class Task08{
	public static String str(char c){return c+"";}
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
		String s = inp.nextLine();
		System.out.println(skobki(s));
	}
}
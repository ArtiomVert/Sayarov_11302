public class Skobki{
	public static int ns(char q){
		switch(q+""){
			case "(":return 0;
			case ")":return 1;
			case "{":return 3;
			case "}":return 4;
			case "[":return 6;
			case "]":return 7;
		}
		return 10;
	}
	public static boolean have(String s){
		for (int i = 0; i < s.length()-1; i++){
			if (ns(s.charAt(i))-ns(s.charAt(i+1)) == -1){
				return true;
			}
		}
		return false;
	}
	public static int find(String s){
		for (int i = 0; i < s.length()-1; i++){
			if (ns(s.charAt(i))-ns(s.charAt(i+1)) == -1){
				return i;
			}
		}
		return 0;
	}
	public static String zam(String s, int q){
		String s1 = "";
		for (int i = 0; i < s.length(); i+=1){
			if (i==q || i==q+1){
				continue;
			}
			s1+=s.charAt(i);
		}
		return s1;
	}
	public static void main(String[] args) {
		String s = "{()({})([])}([{(){[]}}]())";
		while (have(s)){
			s = zam(s, find(s));
		}
		System.out.println(s.equals(""));
	}
}
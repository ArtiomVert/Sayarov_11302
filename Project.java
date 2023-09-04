class Project {

	public static String [] list = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

	public static String get_number_in_words(int num){
		String s = Integer.toString(num);
		String s_out = new String("");
		int len_s = s.length();
		for (int i = 0; i<len_s-1; i++){
			s_out = s_out + list[Integer.valueOf(s.substring(0, 1))] + " ";
			s = s.substring(1);
		}
		s_out = s_out + list[Integer.valueOf(s)];
		return s_out;
	}

	static void pows(){
		for (int i = 1; i<51;i ++){
		 	int s = 1;
		 	for (int q = 0; q<5;q ++){s = s*i;}
		 	System.out.println(s);
		}
	}

	public static void main(String args[]){
		 System.out.println(get_number_in_words(12300));
	}
	
}
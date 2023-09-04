class Project {

	String [] list = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

	public String get_number_in_words(int num){
		return list[0];
	}

	static void pows(){
		for (int i = 0; i<50;i ++){
		 	int s = 1;
		 	for (int q = 0; q<5;q ++){s = s*i;}
		 	System.out.println(s);
		}
	}

	public static void main(String args[]){
		pows();
		 
	}
	
}
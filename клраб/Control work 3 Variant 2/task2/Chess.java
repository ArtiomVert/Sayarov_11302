public class Chess extends SportGame{
	private String[][] desk = new String[8][8];
	public Chess(){
		super("Chess", 2, 2);
	}
	protected void processGame(){
		int player = 1;
		while (true){
			switch(player){
				case 1:
					hod(1);
					player = 2;
					break;
				case 2:
					hod(2);
					player = 1;
					break;
			}
		}
	}
	private void hod(int a){
		System.out.println("Player " + a + " is going");
		//...
	}
}
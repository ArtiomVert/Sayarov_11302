public class BasketBall extends SportGame{
	private boolean ballInGame = true;
	public BasketBall(){
		super("BasketBall", 14, 2);
	}
	protected void processGame(){
		int comand = 1;
		while (ballInGame){
			switch(comand){
				case 1:
					podacha(1);
					comand = 2;
					break;
				case 2:
					podacha(2);
					comand = 1;
			}
		}
	}
	private void podacha(int a){
		System.out.println("Command " + a + " have ball");
		//...
		if (!successPodacha()){
			ballInGame = false;
		}
	}
	private boolean successPodacha(int power, int angle){
		//...
		return power*angle<100 && power*angle>50;
	}
}
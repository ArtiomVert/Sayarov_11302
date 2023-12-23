public abstract class ASportGame extends ASport{
	private int amount_players;
	private int amount_comands;
	public boolean game = false;
	public SportGame(String name, int ap, int ac){
		super(name);
		amount_players = ap;
		amount_comands = ac;
	}
	public int getAmountPlayers(){
		return amount_players;
	}
	public int getAmountComands(){
		return amount_comands;
	}
	public void start(){
		System.out.println(getName + " started");
		game = true;
		processGame();
	}
	public void end(){
		game = false;
		System.out.println(getName + " end");
	}
	protected abstract void processGame();

}
public abstract class AbstractBotPlayer extends APlayer{
	public AbstractBotPlayer(){
		String name = "COMPUTER";
		this.name = name;
	}
	public void kick(APlayer p){
		kick(p, strategy());
	}
	protected abstract double strategy();
}
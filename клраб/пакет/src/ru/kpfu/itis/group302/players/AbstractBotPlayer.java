package ru.kpfu.itis.group302.players;
public abstract class AbstractBotPlayer extends APlayer{
	public AbstractBotPlayer(){
		String name = "COMPUTER";
		this.name = name;
	}
	public void kick(APlayer p){
		this.kick(p, strategy());
	}
	protected abstract double strategy();
}
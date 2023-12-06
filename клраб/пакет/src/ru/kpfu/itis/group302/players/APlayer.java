package ru.kpfu.itis.group302.players;
public abstract class APlayer{
	private int max_hp = 100;
	private int hp = 100;
	private int power = 10;
	protected String name = "AbstractPlayer";
	public int getHp(){
		return hp;
	}
	protected void setHp(int hp){
		this.hp = hp>max_hp?max_hp:hp;
	}
	protected void setMaxHp(int max_hp){
		this.max_hp = max_hp;
	}
	protected void changeHp(int n){
		hp += n;
		hp = hp>max_hp?max_hp:hp;
	}
	protected void setPower(int power){
		this.power = power;
	}
	public String getName(){
		return name;
	}
	protected int makeHit(double mult){
		double p = 1/mult;
		if (Math.random()<=p){
			return (int)Math.floor(power*mult);
		}
		return 0;
	}
	public boolean alive(){
		return hp>0;
	}
	public void kick(APlayer p){
		kick(p, 1);
	}
	public void kick(APlayer p, double mult){
		p.changeHp((-1)*makeHit(mult));
	}
}
package ru.kpfu.itis.group302.players;
public class SuperPlayer extends Player{
	name = "SuperPlayer";
	private int heal_hp = 10;
	super.setPower(20);
	super.setMaxHp(200);
	super.setHp(200);
	public void battleCry(){
		System.out.println(text_battle_cry);
	}
	public void healHp(){
		super.changeHp(healHp);
	}
	public void comboKick(Player p){
		for (int i = 0; i < 5; i++){
			kick(p, 1+Math.random()*2);
		}
	}
}
import java.util.Scanner;
public class Game{
	private APlayer p1;
	private APlayer p2;
	View v = new View();
	public void gameMenu(){
		Scanner inp = new Scanner(System.in);
		boolean f = true;
		while(f){
			v.println("Выберите режим игры:");
			v.println("1.Два игрока");
			v.println("2.Против компьютера");
			v.println("3.Выйти из игры");
			String comand = inp.nextLine();
			switch(comand){
				case "1":
					gamePP();
					break;
				case "2":
					gamePB();
					break;
				case "3":
					f = false;
					break;
				default:
					v.println("Извините, команда не ясна, попробуйте снова :(");
					break;
			}
		}
	}
	
	private void gamePP(){
		Scanner in = new Scanner(System.in);
		v.println("Введите имя первого игрока");
		p1 = new Player(in.nextLine());
		v.println("Введите имя второго игрока");
		p2 = new Player(in.nextLine());
		APlayer kicker = p1;
		APlayer enemy = p2;
		while (p1.alive() && p2.alive()) {
			v.println(p1.getName() + " hp:" + p1.getHp() + ", " + p2.getName() + " hp:" + p2.getHp());
			v.print(kicker.getName() + " is going to kick " + enemy.getName() + " with force: ");
			double f = in.nextDouble();
			kicker.kick(enemy, f);
			APlayer swap = kicker;
			kicker = enemy;
			enemy = swap;
		}
		APlayer winner = p1.alive() ? p1: p2;
		v.println(winner.getName() + " won.");
	}
	private void gamePB(){
		Scanner in = new Scanner(System.in);
		v.println("Введите имя игрока");
		p1 = new Player(in.nextLine());
		p2 = new Bot();
		while (p1.alive() && p2.alive()) {
			v.println(p1.getName() + " hp:" + p1.getHp() + ", " + p2.getName() + " hp:" + p2.getHp());
			v.print(p1.getName() + " is going to kick " + p2.getName() + " with force: ");
			double f = in.nextDouble();
			p1.kick(p2, f);
			if (p2.alive()){
				p2.kick(p1);
			}
		}
		APlayer winner = p1.alive() ? p1: p2;
		v.println(winner.getName() + " won.");
	}
}
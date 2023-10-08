import java.util.Scanner;
public class CresNol{
	private void print(String s){
		System.out.println(s);
	}
	public void gameMenu(){
		Scanner inp = new Scanner(System.in);
		boolean f = true;
		while(f){
			print("Выберите режим игры:");
			print("1.Против бота");
			print("2.Два игрока");
			print("3.Выйти из игры");
			String comand = inp.nextLine();
			switch(comand){
				case "1":
					play1();
					break;
				case "2":
					play2();
					break;
				case "3":
					f = false;
					break;
				default:
					print("Извините, команда не ясна, попробуйте скова :(");
					break;
			}
		}
	}
	private String ch(byte n){
		switch(n){
			case 0:
				return " ";
			case 1:
				return "X";
			case 2:
				return "O";
		}
		return " ";
	}

	private void printDesc(byte[][] desc){
		print(ch(desc[0][0]) + "|" + ch(desc[0][1]) + "|" + ch(desc[0][2]));
		print("-+-+-");
		print(ch(desc[1][0]) + "|" + ch(desc[1][1]) + "|" + ch(desc[1][2]));
		print("-+-+-");
		print(ch(desc[2][0]) + "|" + ch(desc[2][1]) + "|" + ch(desc[2][2]));
	}

	private void play1(){
		//TODO single player game
	}

	private void play2(){
		//TODO multiplayer game
		Scanner inp = new Scanner(System.in);
		byte c = 1;
		byte[][] desc = {{0,0,0}, {0,0,0}, {0,0,0}};
		for (byte i = 0; i < 9){
			printDesc(desc);
			print("Ходит игрок " + c + ". Введите поле, куда хотите сходить(строка, столбец). Например '3 3'");
			do{
				int x = inp.nextInt();
				int y = inp.nextInt();
			}while(f)
		}
	}
}
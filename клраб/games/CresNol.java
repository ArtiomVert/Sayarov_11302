import java.util.Scanner;
import java.util.Random;
public class CresNol{
	private void clean(){
		try{
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		} catch(Exception e){
			System.out.println("Извините, какие-то ошибки");
		}
	}
	private void print(String s){
		System.out.println(s);
	}
	public void gameMenu(){
		clean();
		Scanner inp = new Scanner(System.in);
		boolean f = true;
		while(f){
			print("Выберите режим игры:");
			print("1.Против бота(Игрок ходит первый)");
			print("2.Против бота(Бот ходит превый)");
			print("3.Два игрока");
			print("4.Выйти из игры");
			String comand = inp.nextLine();
			switch(comand){
				case "1":
					play1((byte)(1));
					break;
				case "2":
					play1((byte)(2));
					break;
				case "3":
					play2();
					break;
				case "4":
					f = false;
					break;
				default:
					clean();
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

	private void printDesk(byte[][] desk){
		print(ch(desk[0][0]) + "|" + ch(desk[0][1]) + "|" + ch(desk[0][2]));
		print("-+-+-");
		print(ch(desk[1][0]) + "|" + ch(desk[1][1]) + "|" + ch(desk[1][2]));
		print("-+-+-");
		print(ch(desk[2][0]) + "|" + ch(desk[2][1]) + "|" + ch(desk[2][2]));
	}

	
	private boolean itisend(byte[][] desk){
		int q;
		for (int i = 0; i < 3; i++){
			q = desk[i][0]*desk[i][1]*desk[i][2];
			if (q == 1 || q == 8){
				return true;
			}
			q = desk[0][i]*desk[1][i]*desk[2][i];
			if (q == 1 || q == 8){
				return true;
			}
		}
		q = desk[0][0]*desk[1][1]*desk[2][2];
		if (q == 1 || q == 8){
			return true;
		}
		q = desk[0][2]*desk[1][1]*desk[2][0];
		if (q == 1 || q == 8){
			return true;
		}
		return false;
	}

	private int[] costyl(){
		while (true) {
        	try {
        		Scanner in = new Scanner(System.in);
        		return new int[] {in.nextInt(), in.nextInt()};
    		} catch (Exception e) {
        		print("Пожалуйста, не балуйтесь и попробуйте снова.");
    		}
		}
	}
	private void play1(byte who){
		//TODO single player game
		byte[][] desk = {{0,0,0}, {0,0,0}, {0,0,0}};
		boolean end = false;
		for (byte i = 0; i < 9; i++){
			clean();
			printDesk(desk);
			if ((i+who-1)%2==1){
				int x;
				int y;
				Random r = new Random();
				do{
					x = r.nextInt(3);
					y = r.nextInt(3);
				}while(desk[x][y]!=0);
				desk[x][y] = (byte)(1+who%2);
				//TODO сделать ход бота
			}else{
				print("Ходит игрок("+ch(who)+"). Введите поле, куда хотите сходить(строка, столбец). Например '3 3'");
				int x = 0;
				int y = 0;
				boolean f = true;
				do{
					int[] cos = costyl();
					x = cos[0];
					y = cos[1];
					x = (x-1)%3;
					y = (y-1)%3;
					try{
						if (desk[x][y]==0){
							f = false;
						}else{
							print("Это место занято, попробуйте другое.");
						}
			    	}catch(Exception e){
			    		print("Пожалуйста, не балуйтесь и попробуйте снова.");
			    	}
				}while(f);
				desk[x][y] = who;
			}
			clean();
			if (itisend(desk)){
				end = true;
				if ((i+who-1)%2==1){
					print("Бот выиграл");
				}else{
					print("Игрок выиграл");
				}
				
				break;
			}
		}
		if (end==false){
			print("Победила дружба! :)");
		}
		printDesk(desk);

	}

	private void play2(){
		byte[][] desk = {{0,0,0}, {0,0,0}, {0,0,0}};
		boolean end = false;
		for (byte i = 0; i < 9; i++){
			clean();
			printDesk(desk);
			print("Ходит игрок " + (1 + i%2) + " (1 - X, 2 - O). Введите поле, куда хотите сходить(строка, столбец). Например '3 3'");
			int x = 0;
			int y = 0;
			boolean f = true;
			do{
				int[] cos = costyl();
				x = cos[0];
				y = cos[1];
				x = (x-1)%3;
				y = (y-1)%3;
				try{
					if (desk[x][y]==0){
						f = false;
					}else{
						print("Это место занято, попробуйте другое.");
					}
			    }catch(Exception e){
			    	print("Пожалуйста, не балуйтесь и попробуйте снова.");
			    }
			}while(f);
			clean();
			desk[x][y] = (byte)(1+i%2);
			if (itisend(desk)){
				end = true;
				print("Игрок " + (1+i%2) +" выиграл");
				break;
			}
		}
		if (end==false){
			print("Победила дружба! :)");
		}
		printDesk(desk);
	}
}
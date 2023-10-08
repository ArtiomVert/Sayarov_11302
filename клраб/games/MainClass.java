import java.util.Scanner;
public class MainClass{
	private static void clean(){
		try{
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		} catch(Exception e){
			System.out.println("Извините, какие-то ошибки");
		}
	}
	private static void print(String s){
		System.out.println(s);
	}
	public static void main(String[] args) {
		Scanner inp = new Scanner(System.in);
		boolean f = true;
		while(f){
			clean();
			print("Выберите игру:");
			print("1.Крестики-нолики");
			print("2.Судоку");
			print("3.Сапёр");
			print("4.Выйти");
			String comand = inp.nextLine();
			switch(comand){
				case "1":
					new CresNol().gameMenu();
					break;
				case "2":
					//TODO сделать игру Судоку
					break;
				case "3":
					//TODO сделать игру Сапёр
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
}
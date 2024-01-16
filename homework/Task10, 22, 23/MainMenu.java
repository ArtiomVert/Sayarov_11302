import java.util.Scanner;
public class MainMenu{
	public static void main(String[] args) {
		View v = new View();
		Scanner inp = new Scanner(System.in);
		boolean f = true;
		while(f){
			v.println("Выберите игру:");
			v.println("1.Файтинг");
			v.println("2.Выйти");
			String comand = inp.nextLine();
			switch(comand){
				case "1":
					new Game().gameMenu();
					break;
				case "6":
					f = false;
					break;
				default:
					v.println("Извините, команда не ясна, попробуйте снова :(");
					break;
			}
		}
	}
}

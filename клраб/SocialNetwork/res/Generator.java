import java.util.Random;
import java.io.FileWriter;
public class Generator{
	public static void main(String[] args) {
		String[] name = {"Nikita", "Ivan", "Petr", "Egor", "Liza", "Nastya", "Arsen", "Damir", "Diana", "Boris", "Slava", "Timur", "Amir", "Roman", "Konstantin", "Danil", "Maksim", "Anna", "Maria", "Olya", "Lena", "Tanya", "Ilya", "Mohamed"};
		int n_name = name.length;
		String[] city = {"Vladivostok", "Yakutsk", "Sochi", "VelikyNovgorod", "Kaliningrad", "Voronezh", "Moscow", "Kazan", "SaintPetersburg", "Chelyabinsk", "NaberezhnyeChelny", "YoshkarOla", "Krasnodar", "Krasnoyarsk", "Donetsk", "Orenburg", "Sterlitamak", "Ufa", "Volgograd", "Murmansk"};
		int n_city = city.length;
		Random r = new Random();
		try{
			FileWriter w = new FileWriter("Users.txt", false);
			w.write("150\n");
			for (int i = 1; i <= 150; i++){
				w.write(i+" "+name[r.nextInt(n_name)]+" "+city[r.nextInt(n_city)]+"\n");
			}
			w.close();
		}catch (Exception e) {
			System.out.println("Error in User.txt");
		}
		try{
			FileWriter w = new FileWriter("Groups.txt", false);
			w.write(n_city+"\n");
			for (int i = 1; i <= n_city; i++){
				w.write(i+" novosti"+city[i-1]+" "+city[i-1]+"\n");
			}
			w.close();
		}catch (Exception e) {
			System.out.println("Error in Groups.txt");
		}
		try{
			FileWriter w = new FileWriter("Subscriptions.txt", false);
			w.write("700\n");
			for (int[] u:subs(150, 1000)){
				w.write(u[0]+" "+u[1]+"\n");
			}
			w.close();
		}catch (Exception e) {
			System.out.println("Error in Subscriptions.txt");
		}
		try{
			FileWriter w = new FileWriter("Members.txt", false);
			w.write("300\n");
			for (int[] u:mems(150, n_city, 600)){
				w.write(u[0]+" "+u[1]+"\n");
			}
			w.close();
		}catch (Exception e) {
			System.out.println("Error in Members.txt");
		}
	}
	public static boolean cor(int[][] u, int[] w){
		for (int[] w1:u){
			if (w1[0]==w[0] && w1[1]==w[1]){
				return true;
			}
		}
		return false;
	}
	public static int[][] subs(int n, int count){
		int[][] u = new int[count][2];
		Random r = new Random();
		for (int i = 0; i < count; i++){
			int[] x = new int[2];
			do{
				x[0] = 1+r.nextInt(n);
				x[1] = 1+r.nextInt(n);
			}while(cor(u, x) || x[0]==x[1]);
			u[i][0] = x[0];
			u[i][1] = x[1];
		}
		return u;
	}
	public static int[][] mems(int na, int nc, int count){
		int[][] u = new int[count][2];
		Random r = new Random();
		for (int i = 0; i < count; i++){
			int[] x = new int[2];
			do{
				x[0] = 1+r.nextInt(nc);
				x[1] = 1+r.nextInt(na);
			}while(cor(u, x));
			u[i][0] = x[0];
			u[i][1] = x[1];
		}
		return u;
	}
}
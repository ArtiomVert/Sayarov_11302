package ru.database;
import ru.models.User;
import ru.models.Group;
import ru.models.Members;
import ru.models.Subscriptions;
import java.util.Random;
public class FakeDataBase extends ADataBase{
	final int USERS_COUNT = 100;
	String[] name = {"Nikita", "Ivan", "Petr", "Egor", "Liza", "Nastya", "Arsen", "Damir", "Diana", "Boris", "Slava", "Timur", "Amir", "Roman", "Konstantin", "Danil", "Maksim", "Anna", "Maria", "Olya", "Lena", "Tanya", "Ilya", "Mohamed"};
	int n_name = name.length;
	String[] city = {"Vladivostok", "Yakutsk", "Sochi", "VelikyNovgorod", "Kaliningrad", "Voronezh", "Moscow", "Kazan", "SaintPetersburg", "Chelyabinsk", "NaberezhnyeChelny", "YoshkarOla", "Krasnodar", "Krasnoyarsk", "Donetsk", "Orenburg", "Sterlitamak", "Ufa", "Volgograd", "Murmansk"};
	int n_city = city.length;
	Random r = new Random();
	protected void fillUsers()throws Exception{
		int n = USERS_COUNT;
		users = new User[n];
		for (int i = 0; i < n; i++){
			users[i] = new User(i+1, name[r.nextInt(n_name)], city[r.nextInt(n_city)]);
		}
	}

	protected void fillGroups()throws Exception{
		int n = n_city;
		groups = new Group[n];
		for (int i = 0; i < n; i++){
			groups[i] = new Group(i+1, "novosti"+city[i], city[i], users[r.nextInt(USERS_COUNT)]);
		}
	}

	protected void fillSubs()throws Exception{
		int n = USERS_COUNT*(USERS_COUNT-50);
		for (int[] u:subs(USERS_COUNT, n)){
			subs.addSub(getUserOnId(u[0]), getUserOnId(u[1]));
		}
	}

	protected void fillMembers()throws Exception{
		int n = USERS_COUNT*2;
		for (int[] mem:mems(USERS_COUNT, n_city, n)){
			members.addMember(getGroupOnId(mem[0]), getUserOnId(mem[1]));
		}
	}

	private boolean cor(int[][] u, int[] w){
		for (int[] w1:u){
			if (w1[0]==w[0] && w1[1]==w[1]){
				return true;
			}
		}
		return false;
	}
	private int[][] subs(int n, int count){
		int[][] u = new int[count][2];
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
	private int[][] mems(int na, int nc, int count){
		int[][] u = new int[count][2];
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
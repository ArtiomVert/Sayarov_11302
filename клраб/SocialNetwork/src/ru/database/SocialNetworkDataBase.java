package ru.database;
import ru.models.User;
import ru.models.Group;
import ru.models.Members;
import ru.models.Subscriptions;
import java.util.Scanner;
import java.io.File;
public class SocialNetworkDataBase{

	public User[] users;
	public Group[] groups;
	public Subscriptions subs = new Subscriptions();
	public Members members = new Members();

	private void fillUsers(Scanner sc)throws Exception{
		int n = Integer.parseInt(sc.nextLine());
		users = new User[n];
		for (int i = 0; i < n; i++){
			String[] args = sc.nextLine().split(" ");
			users[i] = new User(Integer.parseInt(args[0]), args[1], args[2]);
		}
	}

	private void fillGroups(Scanner sc)throws Exception{
		int n = Integer.parseInt(sc.nextLine());
		groups = new Group[n];
		for (int i = 0; i < n; i++){
			String[] args = sc.nextLine().split(" ");
			groups[i] = new Group(Integer.parseInt(args[0]), args[1], args[2]);
		}
	}

	public User getUserOnId(int id){
		for (User u:users){
			if (u.id == id){
				return u;
			}
		}
		return null;
	}

	public Group getGroupOnId(int id){
		for (Group g:groups){
			if (g.id == id){
				return g;
			}
		}
		return null;
	}

	private void fillSubs(Scanner sc)throws Exception{
		int n = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < n; i++){
			String[] args = sc.nextLine().split(" ");
			int id1 = Integer.parseInt(args[0]);
			int id2 = Integer.parseInt(args[1]);
			subs.addSub(getUserOnId(id1), getUserOnId(id2));
		}
	}

	private void fillMembers(Scanner sc)throws Exception{
		int n = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < n; i++){
			String[] args = sc.nextLine().split(" ");
			int id1 = Integer.parseInt(args[0]);
			int id2 = Integer.parseInt(args[1]);
			members.addMember(getGroupOnId(id1), getUserOnId(id2));
		}
	}

	public SocialNetworkDataBase(){}
	public boolean init(){
		try{
			fillUsers(new Scanner(new File("res/Users.txt")));
			fillGroups(new Scanner(new File("res/Groups.txt")));
			fillSubs(new Scanner(new File("res/Subscriptions.txt")));
			fillMembers(new Scanner(new File("res/Members.txt")));
		}catch (Exception e) {
			return false;
		}
		return true;
	}
}
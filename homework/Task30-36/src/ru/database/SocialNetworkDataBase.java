package ru.database;
import ru.models.User;
import ru.models.Group;
import ru.models.Members;
import ru.models.Subscriptions;
import java.util.Scanner;
import java.io.File;
public class SocialNetworkDataBase extends ADataBase{

	protected void fillUsers()throws Exception{
		Scanner sc = new Scanner(new File("res/Users.txt"));
		int n = Integer.parseInt(sc.nextLine());
		users = new User[n];
		for (int i = 0; i < n; i++){
			String[] args = sc.nextLine().split(" ");
			users[i] = new User(Integer.parseInt(args[0]), args[1], args[2]);
		}
	}

	protected void fillGroups()throws Exception{
		Scanner sc = new Scanner(new File("res/Groups.txt"));
		int n = Integer.parseInt(sc.nextLine());
		groups = new Group[n];
		for (int i = 0; i < n; i++){
			String[] args = sc.nextLine().split(" ");
			groups[i] = new Group(Integer.parseInt(args[0]), args[1], args[2], getUserOnId(Integer.parseInt(args[3])));
		}
	}

	protected void fillSubs()throws Exception{
		Scanner sc = new Scanner(new File("res/Subscriptions.txt"));
		int n = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < n; i++){
			String[] args = sc.nextLine().split(" ");
			int id1 = Integer.parseInt(args[0]);
			int id2 = Integer.parseInt(args[1]);
			subs.addSub(getUserOnId(id1), getUserOnId(id2));
		}
	}

	protected void fillMembers()throws Exception{
		Scanner sc = new Scanner(new File("res/Members.txt"));
		int n = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < n; i++){
			String[] args = sc.nextLine().split(" ");
			int id1 = Integer.parseInt(args[0]);
			int id2 = Integer.parseInt(args[1]);
			members.addMember(getGroupOnId(id1), getUserOnId(id2));
		}
	}
}
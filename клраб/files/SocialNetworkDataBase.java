import java.util.Scanner;
import java.io.File;
public class SocialNetworkDataBase{

	public User[] users;
	public Group[] groups;
	public Subscriptions subs = new Subscriptions();
	public Members members = new Members();

	private void fillUsers()throws Exception{
		Scanner sc = new Scanner(new File("db/Users.txt"));
		int n = Integer.parseInt(sc.nextLine());
		users = new User[n];
		for (int i = 0; i < n; i++){
			String[] args = sc.nextLine().split(" ");
			users[i] = new User(Integer.parseInt(args[0]), args[1], args[2]);
		}
	}

	private void fillGroups()throws Exception{
		Scanner sc = new Scanner(new File("db/Groups.txt"));
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

	private void fillSubs()throws Exception{
		Scanner sc = new Scanner(new File("db/Subscriptions.txt"));
		int n = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < n; i++){
			String[] args = sc.nextLine().split(" ");
			int id1 = Integer.parseInt(args[0]);
			int id2 = Integer.parseInt(args[1]);
			subs.addSub(getUserOnId(id1), getUserOnId(id2));
		}
	}

	private void fillMembers()throws Exception{
		Scanner sc = new Scanner(new File("db/Members.txt"));
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
			fillUsers();
			fillGroups();
			fillSubs();
			fillMembers();
		}catch (Exception e) {
			return false;
		}
		return true;
	}
}
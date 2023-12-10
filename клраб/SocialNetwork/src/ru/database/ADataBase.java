package ru.database;
import ru.models.User;
import ru.models.Group;
import ru.models.Members;
import ru.models.Subscriptions;
public abstract class ADataBase{

	public User[] users;
	public Group[] groups;
	public Subscriptions subs = new Subscriptions();
	public Members members = new Members();

	public boolean init(){
		try{
			fillUsers();
			fillGroups();
			subs = new Subscriptions();
			fillSubs();
			members = new Members();
			fillMembers();
		}catch (Exception e) {
			return false;
		}
		return true;
	}
	protected abstract void fillUsers()throws Exception;
	protected abstract void fillGroups()throws Exception;
	protected abstract void fillSubs()throws Exception;
	protected abstract void fillMembers()throws Exception;

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
}
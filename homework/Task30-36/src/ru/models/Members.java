package ru.models;
public class Members{
	public int n = 0;
	public Group[] groups;
	public User[] users;
	public Members(){
		groups = new Group[0];
		users = new User[0];
	}
	public void addMember(Group g, User u){
		n++;
		Group[] new_groups = new Group[n];
		User[] new_users = new User[n];
		for (int i = 0; i<n-1; i++){
			new_groups[i] = groups[i];
			new_users[i] = users[i];
		}
		new_groups[n-1] = g;
		new_users[n-1] = u;
		groups = new Group[n];
		users = new User[n];
		groups = new_groups;
		users = new_users;
	}
	public Group[] getGroupsForUser(User uf){
		int id = uf.id;
		int c = 0;
		for (User u:users){
			if(u.id == id){
				c++;
			}
		}
		Group[] out_groups = new Group[c];
		c = 0;
		for (int i = 0; i < n; i++){
			if(users[i].id == id){
				out_groups[c] = groups[i];
				c++;
			}
		}
		return out_groups;
	}
	public User[] getUsersForGroup(Group gf){
		int id = gf.id;
		int c = 0;
		for (Group g:groups){
			if(g.id == id){
				c++;
			}
		}
		User[] out_users = new User[c];
		c = 0;
		for (int i = 0; i < n; i++){
			if(groups[i].id == id){
				out_users[c] = users[i];
				c++;
			}
		}
		return out_users;
	}
}
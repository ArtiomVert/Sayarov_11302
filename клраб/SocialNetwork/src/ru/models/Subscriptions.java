package ru.models;
public class Subscriptions{
	public int n = 0;
	public User[] users;
	public User[] his_sub;
	public Subscriptions(){
		users = new User[0];
		his_sub = new User[0];
	}
	public void addSub(User s, User u){
		n++;
		User[] new_users = new User[n];
		User[] new_his_sub = new User[n];
		for (int i = 0; i<n-1; i++){
			new_users[i] = users[i];
			new_his_sub[i] = his_sub[i];
		}
		new_users[n-1] = u;
		new_his_sub[n-1] = s;
		users = new User[n];
		his_sub = new User[n];
		users = new_users;
		his_sub = new_his_sub;
	}
	public User[] getSubsForUser(User uf){
		int id = uf.id;
		int c = 0;
		for (User u:users){
			if(u.id == id){
				c++;
			}
		}
		User[] out_his_subs = new User[c];
		c = 0;
		for (int i = 0; i < n; i++){
			if(users[i].id == id){
				out_his_subs[c] = his_sub[i];
				c++;
			}
		}
		return out_his_subs;
	}
}
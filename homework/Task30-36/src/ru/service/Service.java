package ru.service;
import ru.database.ADataBase;
import ru.models.Group;
import ru.models.User;
public class Service{
	public ADataBase db;
	public Service(ADataBase db){
		this.db = db;
	}
	public User work1(){
		User goodUser = null;
		int maxSubs = 0;
		for (User user:db.users){
			String city = user.city;
			User[] subs = db.subs.getSubsForUser(user);
			int c = 0;
			for (User sub: subs){
				if (city.equals(sub.city)){
					c++;
				}
			}
			if (c>=maxSubs){
				maxSubs = c;
				goodUser = user;
			}
		}
		System.out.println(goodUser.name + " from " + goodUser.city + " " + maxSubs);
		return goodUser;
	}
	public Group work2(){
		for (Group g:db.groups){
			String city = g.city;
			User[] us = db.members.getUsersForGroup(g);
			boolean f = true;
			for (User u:us){
				if (city.equals(u.city)){
					f = false;
					break;
				}
			}
			if (f){
				System.out.println(g.name + " " + us.length);
				return g;
			}
		}
		System.out.println("There are no such groups");
		return null;
	}
	private Group[] addGroup(Group[] gs, Group g){
		int n = gs.length;
		Group[] ngs = new Group[n+1];
		for (int i = 0; i < n; i++){
			ngs[i] = gs[i];
		}
		ngs[n] = g;
		return ngs;
	}
	private User[] addUser(User[] gs, User g){
		int n = gs.length;
		User[] ngs = new User[n+1];
		for (int i = 0; i < n; i++){
			ngs[i] = gs[i];
		}
		ngs[n] = g;
		return ngs;
	}
	public Group[] work3(){
		Group[] out_groups = new Group[0];
		for (Group g:db.groups){
			String city_admin = g.admin.city;
			User[] fols = db.members.getUsersForGroup(g);
			int pol = fols.length/2;
			int c = 0;
			for (User u:fols){
				if (!u.city.equals(city_admin)){
					c++;
				}
			}
			if (c>pol){
				//System.out.println(g.name + " " + c + "/" + fols.length);
				out_groups = addGroup(out_groups, g);
			}
		}
		return out_groups;
	}
	private boolean isFriends(User u1, User u2){
		User[] su1 = db.subs.getSubsForUser(u1);
		boolean f = false;
		for(User u:su1){
			if (u.id == u2.id){
				f = true;
				break;
			}
		}
		if (!f){
			return false;
		}
		User[] su2 = db.subs.getSubsForUser(u2);
		f = false;
		for(User u:su2){
			if (u.id == u1.id){
				f = true;
				break;
			}
		}
		return f;
	}
	private boolean isFriendGroup1(Group g){
		User[] ms = db.members.getUsersForGroup(g);
		for (User u: ms){
			for (User u1:ms){
				if (u.id==u1.id){
					continue;
				}
				if(!isFriends(u, u1)){
					return false;
				}
			}
		}
		return true;
	}
	private boolean isFriendGroup2(Group g){
		User[] ms = db.members.getUsersForGroup(g);
		for (User u: ms){
			boolean f = true;
			for (User u1:ms){
				if (u.id==u1.id){
					continue;
				}
				if(isFriends(u, u1)){
					f = false;
					break;
				}
			}
			if (f){
				return false;
			}
		}
		return true;
	}
	private User[] getFriendsForUser(User u){
		User[] f = new User[0];
		for(User u1:db.users){
			if (u.id == u1.id){
				continue;
			}
			if (isFriends(u, u1)){
				f = addUser(f, u1);
			}
		}
		return f;
	}


	private boolean have(User[] us1, User[] us2, User[] ms){
		for (User u: us2){
			if (!inUsers(us1, u) && inUsers(ms, u)){
				return false;
			}
		}
		return true;
	}
	private boolean inUsers(User[] us, User u){
		for (User u1:us){
			if (u.id == u1.id){
				return true;
			}
		}
		return false;
	}
	private User[] addUsers(User[] us1, User[] us2, User[] ms){
		for (User u:us2){
			if (inUsers(us1, u) || !inUsers(ms, u)){
				continue;
			}
			us1 = addUser(us1, u);
		}
		return us1;
	}
	
	private boolean isFriendGroup3(Group g){
		User[] ms = db.members.getUsersForGroup(g);
		User[] fs = new User[0];
		fs = addUsers(fs, getFriendsForUser(ms[0]), ms);
		fs = addUser(fs, ms[0]);
		int i = 0;
		while(i != fs.length){
			User[] f = getFriendsForUser(fs[i]);
			if (!have(fs, f, ms)){
				fs = addUsers(fs, f, ms);
			}
			i++;
		}
		for (User u : ms){
			if (!inUsers(fs, u)){
				return false;
			}
		}
		return true;
	}

	public void work4(){
		int c = db.groups.length;
		int c1 = 0;
		int c2 = 0;
		int c3 = 0;
		for (Group g: db.groups){
			if (isFriendGroup1(g)){
				c1++;
			}
			if (isFriendGroup2(g)){
				c2++;
			}
			if (isFriendGroup3(g)){
				c3++;
			}
		}
		System.out.println(c1+"/"+c);
		System.out.println(c2+"/"+c);
		System.out.println(c3+"/"+c);
	}
}
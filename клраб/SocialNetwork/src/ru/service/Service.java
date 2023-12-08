package ru.service;
import ru.database.SocialNetworkDataBase;
import ru.models.Group;
import ru.models.User;
public class Service{
	public SocialNetworkDataBase db;
	public Service(SocialNetworkDataBase db){
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
				System.out.println(g.name + " from " + g.city + " " + us.length);
				return g;
			}
		}
		return null;
	}
}
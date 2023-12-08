public class Main{
	public static void main(String[] args) {
		SocialNetworkDataBase db = new SocialNetworkDataBase();
		if (db.init()){
			System.out.println("All good");
			User goodUser = db.users[0];
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
				if (c>maxSubs){
					maxSubs = c;
					goodUser = user;
				}
			}
			System.out.println(goodUser.name + " from " + goodUser.city);
		} else{
			System.out.println("Error");
		}
	}
}
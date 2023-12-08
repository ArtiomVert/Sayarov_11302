package ru.main;
import ru.service.Service;
import ru.database.SocialNetworkDataBase;
import ru.models.Group;
import ru.models.User;
public class Main{
	public static void main(String[] args) {
		SocialNetworkDataBase db = new SocialNetworkDataBase();
		if (db.init()){
			System.out.println("All good");
			Service service = new Service(db);
			service.work1();
			service.work2();
		} else{
			System.out.println("Error in Database init");
		}
	}
}
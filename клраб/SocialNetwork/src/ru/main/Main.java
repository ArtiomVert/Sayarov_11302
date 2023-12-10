package ru.main;
import ru.service.Service;
import ru.database.*;
import ru.models.Group;
import ru.models.User;
public class Main{
	public static void main(String[] args) {
		SocialNetworkDataBase db = new SocialNetworkDataBase();
		//FakeDataBase db = new FakeDataBase();
		if (false){
			while (db.init()){
				System.out.println("All good");
				Service service = new Service(db);
				service.work1();
				service.work2();
				System.out.println("Count of groups " + service.work3().length);
				service.work4();
			}
			System.out.println("Error in Database init");
		} else{
			if(db.init()){
				System.out.println("All good");
				Service service = new Service(db);
				service.work1();
				service.work2();
				System.out.println("Count of groups " + service.work3().length);
				service.work4();
			} else{
				System.out.println("Error");
			}
		}
		
	}
}
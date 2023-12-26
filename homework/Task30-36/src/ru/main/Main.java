package ru.main;
import ru.service.Service;
import ru.database.*;
import ru.models.Group;
import ru.models.User;
public class Main{
	public static void main(String[] args) {
		ADataBase db;
		if (false){
			db = new FakeDataBase();
			while (db.init()){
				Service service = new Service(db);
				service.work1();
				service.work2();
				System.out.println("Count of groups " + service.work3().length);
				service.work4();
			}
			System.out.println("Error in Database init");
		} else{
			db = new SocialNetworkDataBase();
			if(db.init()){
				Service service = new Service(db);
				service.work1();
				service.work2();
				System.out.println("Count of groups " + service.work3().length);
				service.work4();
			} else{
				System.out.println("Error in Database init");
			}
		}
		
	}
}
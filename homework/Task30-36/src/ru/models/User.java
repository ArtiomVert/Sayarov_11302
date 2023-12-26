package ru.models;
public class User{
	public int id;
	public String city;
	public String name;
	public User(int id, String name, String city){
		this.id = id;
		this.name = name;
		this.city = city;
	}
}
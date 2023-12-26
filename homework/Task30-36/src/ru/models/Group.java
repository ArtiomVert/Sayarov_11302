package ru.models;
public class Group{
	public int id;
	public String name;
	public String city;
	public User admin;
	public Group(int id, String name, String city, User admin){
		this.id = id;
		this.name = name;
		this.city = city;
		this.admin = admin;
	}
}
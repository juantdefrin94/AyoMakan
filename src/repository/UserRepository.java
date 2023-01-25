package repository;

import java.util.ArrayList;

import models.User;

public class UserRepository {

	public static UserRepository instance = null;
	private ArrayList<User>userList;
	
	private UserRepository() {
		userList = new ArrayList<>();
	}
	
	public static UserRepository getInstance() {
		if(instance == null) {
			instance = new UserRepository();
		}
		return instance;
	}

	public ArrayList<User> getUserList() {
		return userList;
	}

	public void addUserList(User newUser) {
		userList.add(newUser);
	}
	
}

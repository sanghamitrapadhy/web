package com.designpattern.factory;

public class UserFactoryDemo {

	public static void main(String args[]){
		  UserFactory userFactory = new UserFactory();

	      //get an object of Admin and call its userType method.
	      IUser user1 = userFactory.getUser("ADMIN");

	      //call draw method of admin
	      user1.userType();

	      //get an object of normaluser and call its userType method.
	      IUser user2 = userFactory.getUser("NORMAL");

	      //call draw method of normal
	      user2.userType();
	}
}

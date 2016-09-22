package com.designpattern.builder;

public class UserBuilderDemo {

	public static void main(String args[]) {
		User.UserBuilder builder = new User.UserBuilder("Abc", "def");
		builder.age(60).address("Wall street").telephone(99999999L).build();
		
		User user = builder.build();
		System.out.println(user.getAddress());
	}
}
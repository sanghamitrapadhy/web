package com.designpattern.factory;

public class AdminUser implements IUser{
	
	@Override
	public void userType() {
		System.out.println("Admin user");
		
	}

}

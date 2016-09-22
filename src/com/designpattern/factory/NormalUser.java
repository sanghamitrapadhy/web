package com.designpattern.factory;

public class NormalUser implements IUser {

	@Override
	public void userType() {
		System.out.println("Normal user");
		
	}
}
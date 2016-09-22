package com.designpattern.factory;

public class UserFactory {

	//Create a Factory to generate object of concrete class based on given information
	//use userType method to get object of type IUser 
	
	  
	public IUser getUser(String userType){
	      if(userType == null || userType.equals("")){
	         return null;
	      }		
	      if(userType.equalsIgnoreCase("ADMIN")){
	         return new AdminUser();
	         
	      } else if(userType.equalsIgnoreCase("NORMAL")){
	         return new NormalUser();
	         
	      } 
	      return null;
	   }
}

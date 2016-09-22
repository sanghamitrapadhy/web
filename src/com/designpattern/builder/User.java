package com.designpattern.builder;

public class User {
	
	private final  String firstName;//required
	private final  String lastName;//required
	private final  Integer age;
	private final  Long telephone;
	private final String address;

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Integer getAge() {
		return age;
	}

	public Long getTelephone() {
		return telephone;
	}

	public String getAddress() {
		return address;
	}
	
	public User(UserBuilder userBuilder){
		this.firstName=userBuilder.firstName;
		this.lastName=userBuilder.lastName;
		this.age=userBuilder.age;
		this.telephone=userBuilder.telephone;
		this.address=userBuilder.address;
	}
	
	public static class UserBuilder {

		private final String firstName;
		private final String lastName;
		private Integer age;
		private Long telephone;
		private String address;

		public UserBuilder(String firstName, String lastName) {
			this.firstName = firstName;
			this.lastName = lastName;
		}

		public UserBuilder age(Integer age) {
			this.age = age;
			return this;
		}

		public UserBuilder address(String address) {
			this.address = address;
			return this;
		}
		
		public UserBuilder telephone(Long telephone) {
			this.telephone=telephone;
			return this;
		}
		
		public User build(){
			return new User(this);
		}
		
	}

}

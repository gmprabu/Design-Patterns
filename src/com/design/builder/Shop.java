package com.design.builder;

public class Shop {
	
	
	public static void main(String[] args) {
		
		
		Phone p = new PhoneBuilder().setOs("Android").setBattery(3000).getPhone();
		
		System.out.println(p);
		
		
	}

}
